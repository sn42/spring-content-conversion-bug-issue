package npe.works;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class A {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private DocumentA document;

	public DocumentA getDocument() {
		return document;
	}

	public void setDocument(DocumentA document) {
		this.document = document;
	}

	public Long getId() {
		return id;
	}
}
