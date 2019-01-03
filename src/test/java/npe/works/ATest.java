package npe.works;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ATest {
	private static final byte[] EXPECTED_CONTENT = "Test".getBytes(StandardCharsets.UTF_8);

	@Autowired
	private DocumentAStore store;

	@Autowired
	private ARepository repository;

	@Test
	void getContentWorks() throws IOException {
		DocumentA doc = new DocumentA();
		store.setContent(doc, new ByteArrayInputStream(EXPECTED_CONTENT));

		A entity = new A();
		entity.setDocument(doc);
		A savedEntity = repository.save(entity);

		byte[] actualContent;
		try (InputStream stream = store.getContent(savedEntity.getDocument())) {
			actualContent = IOUtils.toByteArray(stream);
		}

		assertAll(
				() -> assertNotNull(savedEntity.getDocument().getContentId()),
				() -> Assertions.assertArrayEquals(EXPECTED_CONTENT, actualContent));
	}
}
