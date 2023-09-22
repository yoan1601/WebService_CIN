/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

/**
 *
 * @author ADMIN
 */
public class Sante {
    Allergie [] allergies;
    MaladieChronique [] maladieChroniques;
    
    public static Sante consulteSante(String CINcitoyen) throws Exception {
        Sante s = new Sante();
        Allergie [] lAllergies = Allergie.consulteAllergies(CINcitoyen);
        MaladieChronique [] lMaladieChroniques = MaladieChronique.consulteMaladieChroniques(CINcitoyen);
        s.setAllergies(lAllergies);
        s.setMaladieChroniques(lMaladieChroniques);
        return s;
    }

    public Allergie[] getAllergies() {
        return allergies;
    }

    public void setAllergies(Allergie[] allergies) {
        this.allergies = allergies;
    }

    public MaladieChronique[] getMaladieChroniques() {
        return maladieChroniques;
    }

    public void setMaladieChroniques(MaladieChronique[] maladieChroniques) {
        this.maladieChroniques = maladieChroniques;
    }
    
    
}
