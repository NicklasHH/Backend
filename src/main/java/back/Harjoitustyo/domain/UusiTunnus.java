package back.Harjoitustyo.domain;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class UusiTunnus {
	@Size(min = 4, max = 20, message = "Sallittu pituus 4-20 merkkiä")
	private String tunnus = "";

	@Size(min = 4, max = 20, message = "Sallittu pituus 4-20 merkkiä")
	private String salasana = "";

	@Column(name = "rooli")
	private String rooli;

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}

}