/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import objets.Sante;
import jakarta.ejb.Remote;

@Remote
public interface SanteServerInterface {
    public Sante consulteSante(String idCIN);
}
