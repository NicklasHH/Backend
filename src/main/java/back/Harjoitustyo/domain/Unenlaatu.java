package back.Harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Unenlaatu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String laatu;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unenlaatu")
	@JsonIgnore
	private List<Uni> unet;

	public Unenlaatu() {
		super();
	}

	public Unenlaatu(Long id, String laatu, List<Uni> unet) {
		super();
		this.id = id;
		this.laatu = laatu;
		this.unet = unet;
	}

	public Unenlaatu(Long id, String laatu) {
		super();
		this.id = id;
		this.laatu = laatu;
	}

	public Unenlaatu(String laatu, List<Uni> unet) {
		super();
		this.laatu = laatu;
		this.unet = unet;
	}

	public Unenlaatu(String laatu) {
		super();
		this.laatu = laatu;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLaatu() {
		return laatu;
	}

	public void setLaatu(String laatu) {
		this.laatu = laatu;
	}

	public List<Uni> getUnet() {
		return unet;
	}

	public void setUnet(List<Uni> unet) {
		this.unet = unet;
	}

	@Override
	public String toString() {
		return "Unenlaatu [id=" + id + ", laatu=" + laatu + "]";
	}

}