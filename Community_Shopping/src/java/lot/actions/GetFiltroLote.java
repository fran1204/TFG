/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.AdvertisingDAO;
import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Category;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class GetFiltroLote extends ActionSupport {

    private Integer idCategory;
    private List<Category> categoris;
    private List anuncio;

    public GetFiltroLote() {

    }

    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        UserDAO dao = new UserDAO();
        SessionDAO sdao = new SessionDAO();
        AdvertisingDAO adao = new AdvertisingDAO();
        anuncio = new ArrayList(ldao.getAllFiltro(idCategory));
        anuncio.addAll(adao.getAllFiltro(idCategory));
        Collections.shuffle(anuncio);
        CategoryDAO cdao = new CategoryDAO();
        categoris = cdao.getAll();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        if (sdao.existeSesion()) {
            return "login";
        }else{
            return SUCCESS;
        }

    }

    public List getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(List anuncio) {
        this.anuncio = anuncio;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public List<Category> getCategoris() {
        return categoris;
    }

    public void setCategoris(List<Category> categoris) {
        this.categoris = categoris;
    }

}
