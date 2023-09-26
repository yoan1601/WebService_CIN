/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presidence_java;

import javax.naming.Context;
import javax.naming.InitialContext;
import server.PresidenceServerInterface;
import java.sql.Connection;
import objets.Citoyen;

/**
 *
 * @author ADMIN
 */
public class EJBPresidenceClient {
    public static PresidenceServerInterface bs;
    
    public Citoyen consulteCitoyen(Connection connection ,String idCIN) throws Exception {
        try {
            Context context = new InitialContext();
            bs = (PresidenceServerInterface)
            context.lookup("java:global/ClientFrontGFish/PresidenceServer!server.PresidenceServerInterface");       
            return bs.getCitoyenByCIN(connection, idCIN);     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
