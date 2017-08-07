/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.LotDAO;
import DAO.LotDetailDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Lot;
import modelo.LotDetail;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class ValidarSesion extends ActionSupport {

    private List<Lot> lotes;
    private List<LotDetail> detalles;

    public ValidarSesion() {
        lotes = new LotDAO().getAll();
        detalles = new LotDetailDAO().getAll();
    }

    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        if (sdao.existeSesion()) {
            if (dao.get(u.getEmail()).isProvider()) {
                return NONE;
            } else {
                return SUCCESS;
            }
        } else {
            return ERROR;
        }
    }

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }

    public List<LotDetail> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<LotDetail> detalles) {
        this.detalles = detalles;
    }

}
