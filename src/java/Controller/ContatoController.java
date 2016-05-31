/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ContatoDAO;
import bean.ContatoBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author mateus
 */
@ManagedBean
@SessionScoped
public class ContatoController  implements Serializable{
    private ContatoBean contatoB;
    private DataModel listaContatos;
    
    public ContatoController(){
        contatoB = new ContatoBean();
    }

    public ContatoBean getContatoB() {
        return contatoB;
    }

    public DataModel getListaContatos() {
        ContatoDAO cD = new ContatoDAO();
        listaContatos = new ListDataModel(cD.listarContato());
        return listaContatos;
    }

    public void setContatoB(ContatoBean contatoB) {
        this.contatoB = contatoB;
    }

    public void setListaContatos(DataModel listaContatos) {
        this.listaContatos = listaContatos;
    }
    
    public void novoContato(){
        contatoB = new ContatoBean();
    }
    
    public String salvaContato(){
        ContatoDAO cD = new ContatoDAO();
        if(cD.salvarContato(contatoB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cadastrado com sucesso!!",""));
            return "listarcontatos";
        }else{
            return "erro";
        }
    }
}
