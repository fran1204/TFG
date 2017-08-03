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
public class Logout extends ActionSupport {
    
     private List<Lot> lotes;
    
    public Logout() {
        lotes = new LotDAO().getAll();
    }
    
    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        sdao.destroySession();
        return SUCCESS;
    }
    
    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }
    
}
