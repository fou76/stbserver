package fr.univ.rouen.stbserver.model;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;


@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.NONE)

public class OPReport implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlElement
	private Integer id;
	@XmlElement
	private Status status;
	
	public OPReport() {
	}
	
	public OPReport(Status status) {
		super();
		this.status = status;
	}
	
	public OPReport(Integer id, Status status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
