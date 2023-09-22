/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import objets.Sante;
import jakarta.ejb.Remote;
import objets.Citoyen;

@Remote
public interface SanteServerInterface {
    public Citoyen getCitoyenByCINWithoutConsultation(String CIN);
    public Sante consulteSante(String idCIN);
}
