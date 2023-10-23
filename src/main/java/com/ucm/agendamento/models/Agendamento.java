/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucm.agendamento.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guest-00
 */
public class Agendamento {
    private int id;
    private String nomeCliente;
    private String servico;
    private String price;
    private String date;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getServico() {
        return servico;
    }

    public Agendamento(int id, String nomeCliente, String servico, String price, String date) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.servico = servico;
        this.price = price;
        this.date = date;
    }

    public Agendamento(String nomeCliente, String servico, String date, String price) {
        this.nomeCliente = nomeCliente;
        this.servico = servico;
        this.date = date;
        this.price = price;
        
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
public String getDataFormatada(){
    return new SimpleDateFormat("dd/MM/yyyy").format(date);
}
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
