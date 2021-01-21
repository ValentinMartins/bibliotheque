package fr.pgah.java.unbrco.model.bibliotheque;

import java.util.ArrayList;
import java.util.List;
import fr.pgah.java.unbrco.model.livre.Livre;
import fr.pgah.java.unbrco.model.livre.GenreLivre;

public class Bibliotheque {

  private Bibliothecaire gerant;
  private String nom;
  private List<Bibliotheque> branches;
  private List<Livre> livresReference = new ArrayList<Livre>();
  private List<Livre> livresRomans = new ArrayList<Livre>();
  private List<Livre> livresBiographie = new ArrayList<Livre>();
  private List<Livre> livresManuels = new ArrayList<Livre>();
  private List<Livre> livresCuisine = new ArrayList<Livre>();
  private List<List<Livre>> catalogue = new ArrayList<List<Livre>>();

  public Bibliotheque(String nom, Bibliothecaire gerant) {
    this.nom = nom;
    this.gerant = gerant;

  }

  public String getNom() {
    return nom;
  }

  public Bibliothecaire getGerant() {
    return gerant;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : stocke livre dans la collection appropriée de cet objet
  public void enregistrerLivre(Livre livre) {
    if (livre != null) {
      GenreLivre genre = livre.getGenre();

      switch (genre) {
        case REFERENCE:
          livresReference.add(livre);
          break;

        case ROMAN:
          livresRomans.add(livre);
          break;

        case BIBLIOGRAPHIE:
          livresBiographie.add(livre);
          break;

        case MANUEL:
          livresManuels.add(livre);
          break;

        case CUISINE:
          livresCuisine.add(livre);
          break;
      }

    }

  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliothèque
  // (qu'il soit actuellement emprunté ou non)
  public boolean estDansCatalogue(Livre livre) {

    catalogue.add(livresReference);
    catalogue.add(livresBiographie);
    catalogue.add(livresRomans);
    catalogue.add(livresManuels);
    catalogue.add(livresCuisine);

    if (livre != null) {

      for (List<Livre> uneListe : catalogue) {

        for (Livre unLivre : uneListe) {
          if (unLivre == livre) {
            return true;
          }
        }

      }
    }
    return false;
  }

  // PREREQUIS: livre != null
  // RENVOIE : vrai si livre est disponible à l'emprunt
  public boolean peutEtreEmprunte(Livre livre) {
    if (livre != null && livre.estSorti() == false) {
      return true;
    }
    return false;
  }

  // PREREQUIS : livre != null
  // RENVOIE : vrai si livre est dans le catalogue de cette bibliotheque
  // ou dans celui de l'un de ses branches
  public boolean estDansCatalogueEtendu(Livre livre) {
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est maintenant emprunté (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerSortie(Livre livre) {
    if (livre != null) {
      for (Bibliotheque bibliotheque : branches) {
        if (bibliotheque.estDansCatalogue(livre)) {
          return true;
        }
      }
    }
    return false;
  }

  // PREREQUIS : livre != null
  // MODIFIE : this
  // EFFETS : enregistre le fait que livre est revenu (si possible)
  // RENVOIE : vrai si l'opération est un succès
  public boolean enregistrerRetour(Livre livre) {
    return false;
  }

  // PREREQUIS : gerant != null
  // MODIFIE : this
  // EFFETS : set le nouveau gérant
  // RENVOIE : vrai si l'opération est un succès
  public boolean engagerGerant(Bibliothecaire bibliothecaire) {

    if (gerant != null) {
      this.gerant = bibliothecaire;
      return true;
    } else {
      return false;
    }

  }

  // EFFETS : affiche le catalogue de cette bibliothèque
  // (toutes les informations de chaque livre)
  public void afficherCatalogue() {

  }
}
