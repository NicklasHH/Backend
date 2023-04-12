package back.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Ruoka {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 20, message = "Sallittu pituus on 3-20 merkkiä")
	private String nimi;

	private String lisatietoja, pvm, kellonaika;

	public Ruoka() {
		super();
	}

	public Ruoka(String nimi, String lisatietoja, String pvm, String kellonaika) {
		super();
		this.nimi = nimi;
		this.lisatietoja = lisatietoja;
		this.pvm = pvm;
		this.kellonaika = kellonaika;
	}

	public Ruoka(Long id, String nimi, String lisatietoja, String pvm, String kellonaika) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.lisatietoja = lisatietoja;
		this.pvm = pvm;
		this.kellonaika = kellonaika;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
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

	public String getKellonaika() {
		return kellonaika;
	}

	public void setKellonaika(String kellonaika) {
		this.kellonaika = kellonaika;
	}

	@Override
	public String toString() {
		return "Ruoka [id=" + id + ", nimi=" + nimi + ", lisatietoja=" + lisatietoja + ", pvm=" + pvm + ", kellonaika="
				+ kellonaika + "]";
	}

}