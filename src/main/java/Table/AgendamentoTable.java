/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import com.ucm.agendamento.models.Client;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guest-00
 */
public class AgendamentoTable extends AbstractTableModel {

    public static final int COL_ID=0;
    public static final int COL_NAME=1;
    public static final int COL_APELIDO=2;
    public static final int COL_PHONE=3;
    public static final int COL_EMAIL=4;
    public static final int COL_ADDRESS=5;
    public ArrayList<Client>lista;

    public AgendamentoTable(ArrayList<Client> l) {
        lista =  new ArrayList<Client>(l);
        
    }
     
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        Client client = lista.get(linhas);
        if(colunas == COL_ID) return client.getId();
        if(colunas == COL_NAME) return client.getName();
        if(colunas == COL_APELIDO) return client.getApelido();
        if(colunas == COL_EMAIL) return client.getEmail();
        if(colunas == COL_PHONE) return client.getPhone();
        if(colunas == COL_ADDRESS) return client.getAddress();
        return " ";
    }
    
    @Override
    public String getColumnName(int colunas){
         if(colunas == COL_ID) return "Codigo";
        if(colunas == COL_NAME) return "Name";
        if(colunas == COL_APELIDO) return "Apelido"; 
        if(colunas == COL_EMAIL) return "Email";
        if(colunas == COL_PHONE) return "Phone";
        if(colunas == COL_PHONE) return "Address";
        return "";
    }
}
