/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objets;

import Banque.Finance;
import banque_dotnet.DotNetWebServiceClient;
import connexion.Connect;
import foncier_java.EJBFoncierClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sante_java.EJBSanteClient;

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
    
    public static Citoyen getCitoyenByCIN(Connection connection, String CINcitoyen) throws Exception {
        EJBSanteClient eJBSanteClient = new EJBSanteClient();
        EJBFoncierClient eJBFoncierClient = new EJBFoncierClient();
        Citoyen citoyen = Citoyen.getCitoyenByCINWithoutConsultation(connection, CINcitoyen);
        Sante sante = eJBSanteClient.consulteSante(citoyen.getIdCIN());
        Foncier foncier = eJBFoncierClient.consulteFoncier(citoyen.getIdCIN());
        Finance finance = DotNetWebServiceClient.consulteFinance(citoyen.getIdCIN());

        citoyen.setSante(sante);
        citoyen.setFoncier(foncier);
        citoyen.setFinance(finance);
        
        return citoyen;
    }
    
    public static Citoyen getCitoyenByCINWithoutConsultation(Connection connection, String CINcitoyen) throws Exception {
        boolean isOpened = false;
        try {
            if (connection == null) {
                isOpened = true;
                connection = Connect.getConnexionPostgreS­ql();
            }
            try {
                String requete = "SELECT * FROM citoyens WHERE idcin = ?";
                System.out.println(requete + " CINcitoyen " + CINcitoyen);
                PreparedStatement prepStat = connection.prepareStatement(requete);
                prepStat.setString(1, CINcitoyen);
                ResultSet resultSet = prepStat.executeQuery();

//                if (resultSet.beforeFirst()) {
//                    
//                }

                String idcitoyen = "";
                String idcin = "";
                String nom = "";
                String prenom = "";
                String datenaissance = "";
                Citoyen citoyen = null;
                
                if(resultSet.next()) {
                    idcitoyen = resultSet.getString("idcitoyen");
                    idcin = resultSet.getString("idcin");
                    nom = resultSet.getString("nom");
                    prenom = resultSet.getString("prenom");
                    datenaissance = resultSet.getString("datenaissance");
                    
                    citoyen = new Citoyen(idcitoyen, idcin, nom, prenom, datenaissance);
                }

                return citoyen;

            } catch (Exception e) {
                System.out.println(">>> Citoyen.getCitoyenByCINWithoutConsultation : "+e.getMessage());
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
    
    public static Citoyen [] getAllCitoyen(Connection connection) throws Exception {
        boolean isOpened = false;
        try {
            if (connection == null) {
                isOpened = true;
                connection = Connect.getConnexionPostgreS­ql();
            }
            try {
                String requete = "SELECT * FROM citoyens";
                System.out.println(requete);
                PreparedStatement prepStat = connection.prepareStatement(requete);
                ResultSet resultSet = prepStat.executeQuery();

//                if (resultSet.beforeFirst()) {
//                    
//                }

                ArrayList<Citoyen> lCitoyens = new ArrayList<>();
                String idcitoyen = "";
                String idcin = "";
                String nom = "";
                String prenom = "";
                String datenaissance = "";
                Citoyen citoyen = null;
                
                while(resultSet.next()) {
                    idcitoyen = resultSet.getString("idcitoyen");
                    idcin = resultSet.getString("idcin");
                    nom = resultSet.getString("nom");
                    prenom = resultSet.getString("prenom");
                    datenaissance = resultSet.getString("datenaissance");
                    
                    citoyen = new Citoyen(idcitoyen, idcin, nom, prenom, datenaissance);
                    lCitoyens.add(citoyen);
                }
                
                if(lCitoyens.isEmpty()) return new Citoyen[0];
                
                Citoyen [] la = Citoyen.transArrayList(lCitoyens);
                return la;

            } catch (Exception e) {
                System.out.println(">>> Citoyen.getAllCitoyen : "+e.getMessage());
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
    
    public static Citoyen[] transArrayList(ArrayList<Citoyen> lCitoyens) {
        Citoyen [] la = new Citoyen[lCitoyens.size()];
        for (int i = 0; i < lCitoyens.size(); i++) {
            la[i] = lCitoyens.get(i);
        }
        return la;
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
