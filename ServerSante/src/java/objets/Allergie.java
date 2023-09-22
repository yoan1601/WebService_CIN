/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

/**
 *
 * @author ADMIN
 */
public class Allergie {
    String idAllergie;
    String idCINAllergie;
    String descriptionAllergie;
    
    public Allergie() {
        
    }

    public Allergie(String idAllergie, String idCINAllergie, String descriptionAllergie) {
        setIdAllergie(idAllergie);
        setIdCINAllergie(idCINAllergie);
        setDescriptionAllergie(descriptionAllergie);
    }
    
    public static Allergie [] consulteAllergies(String CINcitoyen) throws Exception {
        Allergie a1 = new Allergie("1", "123456", "Crevete");
        Allergie a2 = new Allergie("2", "123456", "Crabe");
        Allergie [] lAllergies = { a1, a2 };
        return lAllergies;
    }

    public String getIdAllergie() {
        return idAllergie;
    }

    public void setIdAllergie(String idAllergie) {
        this.idAllergie = idAllergie;
    }

    public String getIdCINAllergie() {
        return idCINAllergie;
    }

    public void setIdCINAllergie(String idCINAllergie) {
        this.idCINAllergie = idCINAllergie;
    }

    public String getDescriptionAllergie() {
        return descriptionAllergie;
    }

    public void setDescriptionAllergie(String descriptionAllergie) {
        this.descriptionAllergie = descriptionAllergie;
    }
    
    
}
