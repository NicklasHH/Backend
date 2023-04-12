package back.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Uni {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String maara;

	private String lisatietoja, pvm;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unenlaatuid")
	private Unenlaatu unenlaatu;

	public Uni() {
		super();
	}

	public Uni(String maara, String lisatietoja, String pvm) {
		super();
		this.maara = maara;
		this.lisatietoja = lisatietoja;
		this.pvm = pvm;
	}

	public Uni(Long id, String maara, String lisatietoja, String pvm, Unenlaatu unenlaatu) {
		super();
		this.id = id;
		this.maara = maara;
		this.lisatietoja = lisatietoja;
		this.pvm = pvm;
		this.unenlaatu = unenlaatu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaara() {
		return maara;
	}

	public void setMaara(String maara) {
		this.maara = maara;
	}

	public String getLisatietoja() {
		return lisatietoja;
	}

	public void setLisatietoja(String lisatietoja) {
		this.lisatietoja = lisatietoja;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public Unenlaatu getUnenlaatu() {
		return unenlaatu;
	}

	public void setUnenlaatu(Unenlaatu unenlaatu) {
		this.unenlaatu = unenlaatu;
	}

	@Override
	public String toString() {
		return "Uni [id=" + id + ", maara=" + maara + ", lisatietoja=" + lisatietoja + ", pvm=" + pvm + ", unenlaatu="
				+ unenlaatu + "]";
	}

}