package fr.pgah.java.unbrco.model.bibliotheque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import fr.pgah.java.unbrco.model.livre.Livre;
import fr.pgah.java.unbrco.model.livre.GenreLivre;

public class BibliothequeTests {

  private Livre livreRef;
  private Livre livreRom;
  private Livre livreBiblio;
  private Livre livreMan;
  private Livre livreCui;
  private Bibliotheque testBibliotheque;
  private Bibliothecaire testBibliothecaire;

  @BeforeEach
  public void setUp() {
    testBibliotheque = new Bibliotheque("Bibliothèque privée Dampierre", testBibliothecaire);
    testBibliothecaire = new Bibliothecaire("Kevin Roy", 10, testBibliotheque, livreRom);

    livreRef = new Livre("Dormir n'importe où", "E. Clément, B. Briendo", GenreLivre.REFERENCE, 2021, 1);
    livreRef.setBibliothequeMere(testBibliotheque);
    livreRom = new Livre("Pizza mon amour", "T. Geneste", GenreLivre.ROMAN, 2020, 2);
    livreRom.setBibliothequeMere(testBibliotheque);
    livreBiblio = new Livre("Ma vie avec lui", "A. Krzykawsky", GenreLivre.BIBLIOGRAPHIE, 2023, 1);
    livreBiblio.setBibliothequeMere(testBibliotheque);
    livreMan = new Livre("Introduction à la programmation C#", "M. Giera", GenreLivre.MANUEL, 2035, 2);
    livreMan.setBibliothequeMere(testBibliotheque);
    livreCui = new Livre("Maîtriser l'Art de l'Américain-cervelas", "Q. Delaporte", GenreLivre.CUISINE, 2020, 2);
    livreCui.setBibliothequeMere(testBibliotheque);

  }

  @Test
  public void testGetNomBibliotheque() {
    assertEquals(testBibliotheque.getNom(), "Bibliothèque privée Dampierre");
  }

  @Test
  public void testEstDansCatalogue() {
    assertEquals(testBibliotheque.estDansCatalogue(livreRef), true);
    assertEquals(testBibliotheque.estDansCatalogue(livreCui), true);
    assertEquals(testBibliotheque.estDansCatalogue(livreRom), true);
    assertEquals(testBibliotheque.estDansCatalogue(livreMan), true);
  }

  @Test
  public void testPeutEtreEmprunteSiSortie() {
    assertEquals(testBibliotheque.peutEtreEmprunte(livreRef), true);
    testBibliotheque.enregistrerSortie(livreRef);
    assertEquals(testBibliotheque.peutEtreEmprunte(livreRef), false);

    assertEquals(testBibliotheque.peutEtreEmprunte(livreCui), true);
    testBibliotheque.enregistrerSortie(livreCui);
    assertEquals(testBibliotheque.peutEtreEmprunte(livreCui), false);
  }

  @Test
  public void testPeutEtreEmprunteSiRetour() {
    assertEquals(testBibliotheque.peutEtreEmprunte(livreMan), true);
    assertEquals(testBibliotheque.enregistrerSortie(livreMan), true);
    assertEquals(testBibliotheque.peutEtreEmprunte(livreMan), false);
    assertEquals(testBibliotheque.enregistrerRetour(livreMan), true);
    assertEquals(testBibliotheque.peutEtreEmprunte(livreMan), true);
  }
}
