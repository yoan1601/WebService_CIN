package server;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets.Sante;

@Stateless
@Remote(SanteServerInterface.class)
public class SanteServer implements SanteServerInterface {

    @Override
    public Sante consulteSante(String idCIN) {
        try {
            return Sante.consulteSante(idCIN);
        } catch (Exception ex) {
            Logger.getLogger(SanteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
