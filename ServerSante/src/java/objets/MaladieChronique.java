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
    
    public static MaladieChronique [] consulteMaladieChroniques(Connection connection, String CINcitoyen) throws Exception {
        boolean isOpened = false;
        try {
            if (connection == null) {
                isOpened = true;
                connection = Connect.getConnexionPostgreS­ql();
            }
            try {
                String requete = "SELECT * FROM maladieChroniques WHERE idCINMaladieChronique = ?";
                System.out.println(requete + " CINcitoyen " + CINcitoyen);
                PreparedStatement prepStat = connection.prepareStatement(requete);
                prepStat.setString(1, CINcitoyen);
                ResultSet resultSet = prepStat.executeQuery();

//                if (resultSet.beforeFirst()) {
//                    
//                }

                ArrayList<MaladieChronique> lMaladieChroniques = new ArrayList<>();
                MaladieChronique MaladieChronique = null;
                String idMaladieChronique = "";
                String idCINMaladieChronique = "";
                String descriptionMaladieChronique = "";
                
                while(resultSet.next()) {
                    idMaladieChronique = resultSet.getString("idMaladieChronique");
                    idCINMaladieChronique = resultSet.getString("idCINMaladieChronique");
                    descriptionMaladieChronique = resultSet.getString("descriptionMaladieChronique");
//                    System.out.println("idMaladieChronique "+idMaladieChronique+" idCINMaladieChronique "+ idCINMaladieChronique + " descriptionMaladieChronique "+descriptionMaladieChronique);
                    MaladieChronique = new MaladieChronique(idMaladieChronique, idCINMaladieChronique, descriptionMaladieChronique);
                    lMaladieChroniques.add(MaladieChronique);
                }
                
                if(lMaladieChroniques.isEmpty()) return new MaladieChronique[0];
                
                MaladieChronique [] la = MaladieChronique.transArrayList(lMaladieChroniques);
                return la;

            } catch (Exception e) {
                System.out.println(">>> MaladieChronique.consulteMaladieChroniques : "+e.getMessage());
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
    
    public static MaladieChronique[] transArrayList(ArrayList<MaladieChronique> lMaladieChroniques) {
        MaladieChronique [] la = new MaladieChronique[lMaladieChroniques.size()];
        for (int i = 0; i < lMaladieChroniques.size(); i++) {
            la[i] = lMaladieChroniques.get(i);
        }
        return la;
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
