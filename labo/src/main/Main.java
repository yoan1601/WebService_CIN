/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import objet.Propriete;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        try {
            Propriete [] lProprietes = Propriete.consulteProprietes(null, "123456");
            for (Propriete p : lProprietes) {
                System.out.println("id "+p.getIdPropriete()+" CIN "+p.getIdCINPropriete()+" descri "+p.getDescriptionPropriete());
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
