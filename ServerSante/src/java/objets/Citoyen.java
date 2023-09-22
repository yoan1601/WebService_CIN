/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

import Banque.Finance;

/**
 *
 * @author ADMIN
 */
public class Citoyen {
    String idCitoyen;
    String idCIN;
    String nom;
    String prenom;
    String dateNaissance;
    Sante sante;
    Foncier foncier;
    Finance finance;

    public Citoyen() {
    }

    public Citoyen(String idCitoyen, String idCIN, String nom, String prenom, String dateNaissance) {
        this.idCitoyen = idCitoyen;
        this.idCIN = idCIN;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    
    public static Citoyen getCitoyenByCINWithoutConsultation(String CIN) throws Exception {
        Citoyen citoyen = new Citoyen("1", "123456", "RABARIJAONA", "Harena", "16 Janvier 2003");
        return citoyen;
    }

    public String getIdCitoyen() {
        return idCitoyen;
    }

    public void setIdCitoyen(String idCitoyen) {
        this.idCitoyen = idCitoyen;
    }

    public String getIdCIN() {
        return idCIN;
    }

    public void setIdCIN(String idCIN) {
        this.idCIN = idCIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Sante getSante() {
        return sante;
    }

    public void setSante(Sante sante) {
        this.sante = sante;
    }

    public Foncier getFoncier() {
        return foncier;
    }

    public void setFoncier(Foncier foncier) {
        this.foncier = foncier;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }
    
}
