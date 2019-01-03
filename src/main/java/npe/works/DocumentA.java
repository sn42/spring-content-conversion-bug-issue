package npe.works;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

@Entity
public class DocumentA {
	@Id
	@GeneratedValue
	private Long id;

	@ContentId
	private String contentId;

	@ContentLength
	private long contentLength;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public Long getId() {
		return id;
	}

	public DocumentA(String sampleProp) {
	}

	public DocumentA() {
	}
}
