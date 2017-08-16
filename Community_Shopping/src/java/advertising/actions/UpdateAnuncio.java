/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import DAO.CategoryDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Advertising;
import modelo.Category;
import modelo.User;

/**
 *
 * @author fran
 */
public class UpdateAnuncio extends ActionSupport {

    private Advertising ad;
    private String url;
    private int anuncioId;
    private List<Category> categoris;
    private int category;

    public UpdateAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        CategoryDAO cdao = new CategoryDAO();
        adao.update(anuncioId, url,cdao.get(category));
        ad = adao.get(anuncioId);
        categoris = cdao.getAll();
        return SUCCESS;
    }

    public Advertising getAd() {
        return ad;
    }

    public void setAd(Advertising ad) {
        this.ad = ad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAnuncioId() {
        return anuncioId;
    }

    public void setAnuncioId(int anuncioId) {
        this.anuncioId = anuncioId;
    }

    public List<Category> getCategoris() {
        return categoris;
    }

    public void setCategoris(List<Category> categoris) {
        this.categoris = categoris;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
