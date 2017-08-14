/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Category;
import modelo.Lot;

/**
 *
 * @author fmrodriguez
 */
public class GetFiltroLote extends ActionSupport {

    private Integer idCategory;
    private List<Lot> lotes;
    private List<Category> categoris;

    public GetFiltroLote() {

    }

    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        lotes = ldao.getAllFiltro(idCategory);
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
