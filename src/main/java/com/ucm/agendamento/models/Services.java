/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucm.agendamento.models;

/**
 *
 * @author Guest-00
 */
public class Services {
    private int id;
    private String description;
 

    public Services(int id, String description) {
        this.id = id;
        this.description = description;
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

}
