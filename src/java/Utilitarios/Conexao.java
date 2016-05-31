/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;



/**
 *
 * @author mateus
 */
public class Conexao {
    private final String driver = "org.gjt.mm.mysql.Driver";
    private final String url = "jdbc:mysql://localhost:3306/agenda";
    private final String usuario = "root";
    private final String senha = "123456";
    private Connection Con;

    public Conexao(){
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public Connection getConnection(){
        if (Con == null){
            try {
                Con = DriverManager.getConnection(url,usuario,senha);
                Con.setAutoCommit(false);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return Con;
    }
    
    public void desconecta(){
        try {
            Con.close();
            Con = null;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}