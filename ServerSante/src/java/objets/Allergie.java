/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

import connexion.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public static Allergie[] consulteAllergies(Connection connection, String CINcitoyen) throws Exception {
//        Allergie a1 = new Allergie("1", "123456", "Crevete");
//        Allergie a2 = new Allergie("2", "123456", "Crabe");
//        Allergie [] lAllergies = { a1, a2 };
//        return lAllergies;
        boolean isOpened = false;
        try {
            if (connection == null) {
                isOpened = true;
                connection = Connect.getConnexionPostgreS­ql();
            }
            try {
                String requete = "SELECT * FROM allergies WHERE idCINAllergie = ?";
                System.out.println(requete + " CINcitoyen " + CINcitoyen);
                PreparedStatement prepStat = connection.prepareStatement(requete);
                prepStat.setString(1, CINcitoyen);
                ResultSet resultSet = prepStat.executeQuery();

//                if (resultSet.beforeFirst()) {
//                    
//                }

                ArrayList<Allergie> lAllergies = new ArrayList<>();
                Allergie allergie = null;
                String idAllergie = "";
                String idCINAllergie = "";
                String descriptionAllergie = "";
                
                while(resultSet.next()) {
                    idAllergie = resultSet.getString("idAllergie");
                    idCINAllergie = resultSet.getString("idCINAllergie");
                    descriptionAllergie = resultSet.getString("descriptionAllergie");
                    System.out.println("idAllergie "+idAllergie+" idCINAllergie "+ idCINAllergie + " descriptionAllergie "+descriptionAllergie);
                    allergie = new Allergie(idAllergie, idCINAllergie, descriptionAllergie);
                    lAllergies.add(allergie);
                }
                
                if(lAllergies.isEmpty()) return new Allergie[0];
                
                Allergie [] la = Allergie.transArrayList(lAllergies);
                return la;

            } catch (Exception e) {
                System.out.println(">>> Allergie.consulteAllergies : "+e.getMessage());
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
    
    public static Allergie[] transArrayList(ArrayList<Allergie> lAllergies) {
        Allergie [] la = new Allergie[lAllergies.size()];
        for (int i = 0; i < lAllergies.size(); i++) {
            la[i] = lAllergies.get(i);
        }
        return la;
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
