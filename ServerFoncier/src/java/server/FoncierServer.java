package server;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;
import objets.Foncier;

@Stateless
@Remote(FoncierServerInterface.class)
public class FoncierServer implements FoncierServerInterface {
    
    @Override
    public Foncier consulteFoncier(String idCIN) {
        try {
            return Foncier.consulteFoncier(idCIN);
        } catch (Exception ex) {
            Logger.getLogger(FoncierServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public int somme() {
        return 46;
    }
    
    @Override
    public String hello() {
        return "hello zanjy ah";
    }
}
