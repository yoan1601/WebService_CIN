/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

import connexion.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public static Propriete [] consulteProprietes(Connection connection,String CINcitoyen) throws Exception {
        boolean isOpened = false;
        try {
            if (connection == null) {
                isOpened = true;
                connection = Connect.getConnexionSQLite();
            }
            try {
                String requete = "SELECT * FROM proprietes WHERE idCINPropriete = ?";
                System.out.println(requete + " CINcitoyen " + CINcitoyen);
                PreparedStatement prepStat = connection.prepareStatement(requete);
                prepStat.setString(1, CINcitoyen);
                ResultSet resultSet = prepStat.executeQuery();

//                if (resultSet.beforeFirst()) {
//                    
//                }

                ArrayList<Propriete> lProprietes = new ArrayList<>();
                Propriete Propriete = null;
                String idPropriete = "";
                String idCINPropriete = "";
                String descriptionPropriete = "";
                
                while(resultSet.next()) {
                    idPropriete = resultSet.getString("idPropriete");
                    idCINPropriete = resultSet.getString("idCINPropriete");
                    descriptionPropriete = resultSet.getString("descriptionPropriete");
                    Propriete = new Propriete(idPropriete, idCINPropriete, descriptionPropriete);
                    lProprietes.add(Propriete);
                }
                
                if(lProprietes.isEmpty()) return new Propriete[0];
                
                Propriete [] la = Propriete.transArrayList(lProprietes);
                return la;

            } catch (Exception e) {
                System.out.println(">>> Propriete.consulteProprietes : "+e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (isOpened == true) {
                connection.close();
            }
        }

        return null;
    }
    
    public static Propriete[] transArrayList(ArrayList<Propriete> lProprietes) {
        Propriete [] la = new Propriete[lProprietes.size()];
        for (int i = 0; i < lProprietes.size(); i++) {
            la[i] = lProprietes.get(i);
        }
        return la;
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
