/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucm.agendamento.models;

/**
 *
 * @author Guest-00
 */
public class Client {
    private int id;
    private String name;
    private String apelido;
    private String email;
    private String phone;
    private String address;

    public Client(String name, String apelido, String email, String phone, String address) {
        this.name = name;
        this.apelido = apelido;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Client() {
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client(String name) {
        this.name = name;
    }

  
}
