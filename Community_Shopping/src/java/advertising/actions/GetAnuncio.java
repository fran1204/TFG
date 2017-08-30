/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import DAO.CategoryDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Advertising;
import modelo.Category;

/**
 *
 * @author fmrodriguez
 */
public class GetAnuncio extends ActionSupport {

    private Advertising ad;
    private int id;
    private List<Category> categoris;

    public GetAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        ad = adao.get(id);
        CategoryDAO cdao = new CategoryDAO();
        categoris = cdao.getAll();
        return SUCCESS;
    }

    public Advertising getAd() {
        return ad;
    }

    public void setAd(Advertising ad) {
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> getCategoris() {
        return categoris;
    }

    public void setCategoris(List<Category> categoris) {
        this.categoris = categoris;
    }

}
