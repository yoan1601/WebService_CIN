/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

public class Foncier {
    Propriete [] proprietes;
    
    public static Foncier consulteFoncier(String CINcitoyen) throws Exception {
        Foncier f = new Foncier();
        Propriete [] lProprietes = Propriete.consulteProprietes(CINcitoyen);
        f.setProprietes(lProprietes);
        return f;
    }

    public Propriete[] getProprietes() {
        return proprietes;
    }

    public void setProprietes(Propriete[] proprietes) {
        this.proprietes = proprietes;
    }
    
    
} 
