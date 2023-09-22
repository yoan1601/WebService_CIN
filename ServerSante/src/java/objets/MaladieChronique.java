/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

/**
 *
 * @author ADMIN
 */
public class MaladieChronique {
    String idMaladieChronique;
    String idCINMaladieChronique;
    String descriptionMaladieChronique;

    public MaladieChronique() {
    }

    public MaladieChronique(String idMaladieChronique, String idCINMaladieChronique, String descriptionMaladieChronique) {
        setIdMaladieChronique(idMaladieChronique);
        setIdCINMaladieChronique(idCINMaladieChronique);
        setDescriptionMaladieChronique(descriptionMaladieChronique);
    }
    
    public static MaladieChronique [] consulteMaladieChroniques(String CINcitoyen) throws Exception {
        MaladieChronique m1 = new MaladieChronique("1", "1234", "asme");
        MaladieChronique m2 = new MaladieChronique("1", "1234", "tremblotte");
        MaladieChronique [] lMaladieChroniques = { m1, m2 };
        return lMaladieChroniques;
    }

    public String getIdMaladieChronique() {
        return idMaladieChronique;
    }

    public void setIdMaladieChronique(String idMaladieChronique) {
        this.idMaladieChronique = idMaladieChronique;
    }

    public String getIdCINMaladieChronique() {
        return idCINMaladieChronique;
    }

    public void setIdCINMaladieChronique(String idCINMaladieChronique) {
        this.idCINMaladieChronique = idCINMaladieChronique;
    }

    public String getDescriptionMaladieChronique() {
        return descriptionMaladieChronique;
    }

    public void setDescriptionMaladieChronique(String descriptionMaladieChronique) {
        this.descriptionMaladieChronique = descriptionMaladieChronique;
    }
    
    
}
