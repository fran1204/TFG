/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.SessionDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Category;
import modelo.Lot;

/**
 *
 * @author fmrodriguez
 */
public class Logout extends ActionSupport {

    private List<Lot> lotes;
    private List<Category> categoris;

    public Logout() {
        lotes = new LotDAO().getAll();
    }

    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        sdao.destroySession();
        CategoryDAO cdao = new CategoryDAO();
        categoris = cdao.getAll();
        return SUCCESS;
    }

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }

    public List<Category> getCategoris() {
        return categoris;
    }

    public void setCategoris(List<Category> categoris) {
        this.categoris = categoris;
    }

}
