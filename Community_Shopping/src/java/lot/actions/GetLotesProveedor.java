/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.LotDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Lot;
import modelo.User;

/**
 *
 * @author fran
 */
public class GetLotesProveedor extends ActionSupport{
 
    private List<Lot> lotes;
    
    public GetLotesProveedor() {
        
    }
    
    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        lotes = ldao.getAllUSer(u);
        return SUCCESS;
    }

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }
    
}
