package gsb.modele;

public class Visite {

	protected String ref;
	protected String dateVisite;
	protected String commentaire;
	protected Medecin unMedecin;
	protected Visiteur unVisiteur;
	
	/**
	 * @param ref
	 * @param datevisite
	 * @param commentaire
	 * @param unMedecin
	 * @param unVisiteur
	 */
	
	public Visite (String ref, String dateVisite, String commentaire, Medecin unMedecin,Visiteur unVisiteur) {
		this.ref = ref;
		this.dateVisite = dateVisite;
		this.commentaire = commentaire;
		this.unMedecin = unMedecin;
		this.unVisiteur = unVisiteur;

	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDatevisite() {
		return dateVisite;
	}

	public void setDatevisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Medecin getUnMedecin() {
		return unMedecin;
	}

	public void setUnMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}

	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
}
