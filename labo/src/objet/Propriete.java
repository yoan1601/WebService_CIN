/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

/**
 *
 * @author ADMIN
 */
public class Propriete {
    String idPropriete;
    String idCINPropriete;
    String descriptionPropriete;

    public Propriete(String idPropriete, String idCINPropriete, String descriptionPropriete) {
        setIdPropriete(idPropriete);
        setIdCINPropriete(idCINPropriete);
        setDescriptionPropriete(descriptionPropriete);
    }
    
    public static Propriete [] consulteProprietes(String CINcitoyen) throws Exception {
        Propriete p1 = new Propriete("1", "123456", "VC 67 Ter Ambatonakanga");
        Propriete p2 = new Propriete("2", "123456", "03 D 09 Ampatana");
        Propriete [] lProprietes = { p1, p2 };
        return lProprietes;
    }

    public String getIdPropriete() {
        return idPropriete;
    }

    public void setIdPropriete(String idPropriete) {
        this.idPropriete = idPropriete;
    }

    public String getIdCINPropriete() {
        return idCINPropriete;
    }

    public void setIdCINPropriete(String idCINPropriete) {
        this.idCINPropriete = idCINPropriete;
    }

    public String getDescriptionPropriete() {
        return descriptionPropriete;
    }

    public void setDescriptionPropriete(String descriptionPropriete) {
        this.descriptionPropriete = descriptionPropriete;
    }
    
    
}
