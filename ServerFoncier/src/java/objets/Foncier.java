/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

import connexion.Connect;
import java.sql.Connection;

public class Foncier {
    Propriete [] proprietes;
    
    public static Foncier consulteFoncier(String CINcitoyen) throws Exception {
        Connection connection = Connect.getConnexionSQLite();
        
        Foncier f = new Foncier();
//        Propriete [] lProprietes = Propriete.consulteProprietes(CINcitoyen);
        Propriete [] lProprietes = Propriete.consulteProprietes(connection, CINcitoyen);
        f.setProprietes(lProprietes);
        
        connection.close();
        return f;
    }

    public Propriete[] getProprietes() {
        return proprietes;
    }

    public void setProprietes(Propriete[] proprietes) {
        this.proprietes = proprietes;
    }
    
    
} 
