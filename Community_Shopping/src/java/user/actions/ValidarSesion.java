/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.LotDAO;
import DAO.SessionDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Lot;

/**
 *
 * @author fmrodriguez
 */
public class ValidarSesion extends ActionSupport {
    
    private List<Lot> lotes;
    
    public ValidarSesion() {
        lotes = new LotDAO().getAll();
    }
    
    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        if(sdao.existeSesion()){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> eventos) {
        this.lotes = lotes;
    }
    
    
    
}
