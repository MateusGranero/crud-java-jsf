/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utilitarios.Conexao;
import bean.ContatoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class ContatoDAO {
    private Conexao Con;
    
    public ContatoDAO(){
        Con = new Conexao();
    }
    
    public boolean salvarContato(ContatoBean contato){
        try{
            String sql = "INSERT INTO CONTATO(NOME)VALUES(?);";
        
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            stm.setString(1, contato.getNome());
            
            stm.execute();
            
             Con.getConnection().commit();
             
             return true;
        } catch(SQLException ex){
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    
    public List<ContatoBean> listarContato(){
        List<ContatoBean> lista = new ArrayList<ContatoBean>();
        try{
            String sql = "Select * from Contato;";
            
            PreparedStatement stm = Con.getConnection().prepareStatement(sql);
            
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                ContatoBean contato = new ContatoBean();
                contato.setId(rs.getInt("ID"));
                contato.setNome(rs.getString("NOME"));
                
                lista.add(contato);
            }
            
            return lista;
        }catch(SQLException ex){
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return lista;
    }
}
