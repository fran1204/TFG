/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.AdvertisingDAO;
import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import DAO.SessionDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Category;
import modelo.Lot;
import modelo.LotDetail;

/**
 *
 * @author fmrodriguez
 */
public class Logout extends ActionSupport {

    private List<Lot> lotes;
    private List<Category> categoris;
    private List<LotDetail> detalles;
    private List anuncio;

    public Logout() {
        lotes = new LotDAO().getAll();
        detalles = new LotDetailDAO().getAll();
        anuncio = new ArrayList(new LotDAO().getAll());
        anuncio.addAll(new AdvertisingDAO().getAll());
        Collections.shuffle(anuncio);
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

    public List<LotDetail> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<LotDetail> detalles) {
        this.detalles = detalles;
    }

    public List getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(List anuncio) {
        this.anuncio = anuncio;
    }

}
