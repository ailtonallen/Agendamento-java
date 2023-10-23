/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucm.agendamento.DAO;

import com.ucm.agendamento.models.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Guest-00
 */
public class AgendamentoDAO {

    private final Connection connection;

    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }

    public AgendamentoDAO() throws SQLException {
        this.connection = new Conexao().getConnection();
    }

    public ArrayList<Agendamento> searchAgendamento() throws SQLException {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM schedule";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeCliente = rs.getString("nomeCliente");
                String servico = rs.getString("servico");
                String price = rs.getString("price");
                String date = rs.getString("date");
                Agendamento agenda = new Agendamento(id, nomeCliente, servico, price, date);
                agendamentos.add(agenda);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agendamentos;
    }

    public void insert(Agendamento agendamento) throws SQLException {
        String sql = "INSERT INTO schedule (price, date, servico, nomeCliente) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, agendamento.getPrice());
            prepareStatement.setString(2, agendamento.getDate());
            prepareStatement.setString(3, agendamento.getServico());
            prepareStatement.setString(4, agendamento.getNomeCliente());
            prepareStatement.executeUpdate();
            prepareStatement.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro ao inserir agendamento: " + erro);
        }
    }

    public void alter(Agendamento agendamento) throws SQLException {
        String sql = "UPDATE schedule SET price = ?, date = ?, servico = ?, nomeCliente = ? WHERE id = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, agendamento.getPrice());
            prepareStatement.setString(2, agendamento.getDate());
            prepareStatement.setString(3, agendamento.getServico());
            prepareStatement.setString(4, agendamento.getNomeCliente());
            prepareStatement.setInt(5, agendamento.getId());
            prepareStatement.executeUpdate();
            prepareStatement.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro ao alterar agendamento: " + erro);
        }
    }

    public void remove(int id) throws SQLException {
        String sql = "DELETE FROM schedule WHERE id = ?";
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);
            prepareStatement.executeUpdate();
            prepareStatement.close();
        } catch (Exception erro)       
        {JOptionPane.showMessageDialog(null, "Removido com sucesso");
            throw new RuntimeException("Erro ao remover agendamento: " + erro);
            
           
        }
    }
}