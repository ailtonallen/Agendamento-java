/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucm.agendamento.DAO;

import com.ucm.agendamento.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;

/**
 *
 * @author tiago
 */
public class ClientDAO {

    /**
     * Insere um usuario dentro do banco de dados
     *
     * @param usuario exige que seja passado um objeto do tipo usuario
     */
    public final Connection connection;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Client> lista = new ArrayList<Client>();

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public ClientDAO() throws SQLException {
        connection = new Conexao().getConnection();
    }

    public ArrayList<Client> searchClient() throws SQLException {
         ArrayList<Client> clientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM client";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Client cliente = new Client();
                cliente.setId(rs.getInt("id"));
                cliente.setName(rs.getString("name"));
                cliente.setPhone(rs.getString("phone"));
                cliente.setAddress(rs.getString("address"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void insert(Client client) throws SQLException {

        String sql = "insert into client(name, apelido, email, phone, address) values(?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, client.getName());
            prepareStatement.setString(2, client.getApelido());
            prepareStatement.setString(3, client.getEmail());
            prepareStatement.setString(4, client.getPhone());
            prepareStatement.setString(5, client.getAddress());
            prepareStatement.execute();
            connection.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro 1" + erro);
        }
    }

    public void alter(Client client) throws SQLException {

        String sql = "update client set name = ?, apelido = ?, email = ?, phone = ?, address = ? where id = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, client.getName());
            prepareStatement.setString(2, client.getApelido());
            prepareStatement.setString(3, client.getEmail());
            prepareStatement.setString(4, client.getPhone());
            prepareStatement.setString(5, client.getAddress());
            prepareStatement.execute();
            connection.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro 2" + erro);
        }

    }

    public void remove(int id) throws SQLException {

        String sql = "delete from client where id = " + id;
        try {
            st = connection.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro 3" + erro);
        }

    }
}
