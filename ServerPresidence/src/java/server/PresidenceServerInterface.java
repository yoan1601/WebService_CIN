/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import jakarta.ejb.Remote;
import java.sql.Connection;
import objets.Citoyen;

@Remote
public interface PresidenceServerInterface {
    public Citoyen getCitoyenByCIN(Connection connection, String CIN);
}
