package foncier_java;

import javax.naming.Context;
import javax.naming.InitialContext;
import objets.Foncier;
import server.FoncierServerInterface;
public class EJBFoncierClient {
    
    public static FoncierServerInterface bs;
    
    public Foncier consulteFoncier(String idCIN) throws Exception {
        try {
            Context context = new InitialContext();
            bs = (FoncierServerInterface)
            context.lookup("java:global/ClientFrontGFish/FoncierServer!server.FoncierServerInterface");       
            return bs.consulteFoncier(idCIN);     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    public static int getSommeBanque() {
//        try {
//            Context context = new InitialContext();
//            bs = (FoncierServerInterface)
//            context.lookup("java:global/ClientFrontGFish/FoncierServer!server.FoncierServerInterface");       
//            return bs.somme();     
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//    
//    public static String getHello() {
//        try {
//            Context context = new InitialContext();
//            bs = (FoncierServerInterface)
//            context.lookup("java:global/ClientFrontGFish/FoncierServer!server.FoncierServerInterface");       
//            return bs.hello();     
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "kii";
//    }

}
