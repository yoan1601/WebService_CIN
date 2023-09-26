package server;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets.Citoyen;

@Stateless
@Remote(PresidenceServerInterface.class)
public class PresidenceServer implements PresidenceServerInterface {
      
    @Override
    public Citoyen getCitoyenByCIN(Connection connection, String CIN) {
        try {
            return Citoyen.getCitoyenByCIN(connection, CIN);
        } catch (Exception ex) {
            Logger.getLogger(PresidenceServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
