/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banque;

/**
 *
 * @author ADMIN
 */
public class Transaction {
    String idTransaction;
    String nomBanque;
    double depot;
    double retrait;
    String dateHeureTransaction;

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public double getDepot() {
        return depot;
    }

    public void setDepot(double depot) {
        this.depot = depot;
    }

    public double getRetrait() {
        return retrait;
    }

    public void setRetrait(double retrait) {
        this.retrait = retrait;
    }

    public String getDateHeureTransaction() {
        return dateHeureTransaction;
    }

    public void setDateHeureTransaction(String dateHeureTransaction) {
        this.dateHeureTransaction = dateHeureTransaction;
    }
    
    
}
