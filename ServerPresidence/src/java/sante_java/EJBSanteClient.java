package sante_java;

//import jakarta.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import objets.Citoyen;
import objets.Sante;
//import objets.Sante;
import server.SanteServerInterface;
import java.sql.Connection;

public class EJBSanteClient {
//    @EJB
    public SanteServerInterface ss;
    
    public Sante consulteSante(String idCIN) throws Exception {
        try {
            Context context = new InitialContext();
            ss = (SanteServerInterface)
            context.lookup("java:global/ClientFrontGFish/SanteServer!server.SanteServerInterface");       
            return ss.consulteSante(idCIN);     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
