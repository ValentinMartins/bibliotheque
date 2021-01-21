package fr.pgah.java.unbrco.model.livre;

import fr.pgah.java.unbrco.model.bibliotheque.Bibliotheque;

public class Livre {

  private String titre;
  private String auteur;
  private GenreLivre genre;
  private int annee;
  private int edition;
  private Bibliotheque bibliothequeMere;
  private boolean estSortie;

  public Livre(String titre, String auteur, GenreLivre genre, int annee, int ed) {
  }

  public String getTitre() {
    return this.titre;
  }

  public String getAuteur() {
    return this.auteur;
  }

  public GenreLivre getGenre() {
    return this.genre;
  }

  public int getAnnee() {
    return this.annee;
  }

  public int getEdition() {
    return this.edition;
  }

  public Bibliotheque getBibliothequeMere() {
    return this.bibliothequeMere;
  }

  public void setBibliothequeMere(Bibliotheque home) {
  }

  // MODIFIE : this
  // EFFETS : enregistre le fait que le livre est revenu
  public void enregistrerRetour() {
    this.estSortie = false;
  }

  // RENVOIE : vrai si le livre est sorti
  public boolean estSorti() {
    return false;
  }

  // MODIFIE : this
  // EFFETS : enregistre le fait que le livre est sorti
  public void enregistrerSortie() {
  }
}
