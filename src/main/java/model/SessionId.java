package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SessionId implements Serializable{
	
	@Column(name = "id_compte")
	private int idCompte;
	@Column(name = "id_partie")
	private int idPartie;
		
	public SessionId() {}

	public SessionId(int idCompte, int idPartie) {
		super();
		this.idCompte = idCompte;
		this.idPartie = idPartie;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}

	@Override
	public String toString() {
		return "SessionId [IdCompte=" + idCompte + ", IdPartie=" + idPartie + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompte, idPartie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionId other = (SessionId) obj;
		return idCompte == other.idCompte && idPartie == other.idPartie;
	}
	
}
