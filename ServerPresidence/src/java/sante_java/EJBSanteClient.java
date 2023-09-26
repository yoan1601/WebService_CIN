package sante_java;

//import jakarta.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import objets.Citoyen;
import objets.Sante;
//import objets.Sante;
import server.SanteServerInterface;

public class EJBSanteClient {
//    @EJB
    public SanteServerInterface ss;
    
    public Citoyen getCitoyenByCINWithoutConsultation(String CIN) throws Exception {
        try {
            Context context = new InitialContext();
            ss = (SanteServerInterface)
            context.lookup("java:global/ClientFrontGFish/SanteServer!server.SanteServerInterface"); 
            System.out.println("SUUUURA");
            Citoyen c = ss.getCitoyenByCINWithoutConsultation(CIN);
            System.out.println("VITA SUUUURA");
            return c;     
//return new Citoyen("1", "123456", "RAB", "Harena", "16/01/2003");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Sante consulteSante(String idCIN) throws Exception {
        try {
//            Context context = new InitialContext();
//            ss = (SanteServerInterface)
//            context.lookup("java:global/ClientFrontGFish/SanteServer!server.SanteServerInterface");       
            return ss.consulteSante(idCIN);     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
