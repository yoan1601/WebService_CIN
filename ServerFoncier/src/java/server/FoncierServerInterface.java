package server;
import jakarta.ejb.Remote;
import objets.Foncier;

@Remote
public interface FoncierServerInterface {
    public int somme();
    public String hello();
    public Foncier consulteFoncier(String idCIN);
}
