/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author cayetano
 */
public class ValidarSesion extends ActionSupport {
    
   // private List<Evento> eventos;
    
    public ValidarSesion() {
      //  eventos = new EventoDAO().getAll();
    }
    
    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        if(sdao.existeSesion()){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

//    public List<Evento> getEventos() {
//        return eventos;
//    }
//
//    public void setEventos(List<Evento> eventos) {
//        this.eventos = eventos;
//    }
    
    
    
}
