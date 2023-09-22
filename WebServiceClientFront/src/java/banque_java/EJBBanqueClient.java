package banque_java;

import javax.naming.Context;
import javax.naming.InitialContext;
import server.BanqueServerInterface;

public class EJBBanqueClient {
    
    public static BanqueServerInterface bs;
    public static int getSommeBanque() {
        try {
            Context context = new InitialContext();
            bs = (BanqueServerInterface)
            context.lookup("java:global/ServerBanque/BanqueServer!server.BanqueServerInterface");       
            return bs.somme();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    
}
