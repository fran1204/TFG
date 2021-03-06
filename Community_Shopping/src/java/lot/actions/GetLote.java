/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Category;
import modelo.Lot;
import modelo.LotDetail;

/**
 *
 * @author fran
 */
public class GetLote extends ActionSupport {

    private Lot lote;
    private int id;
    private List<Category> category;
    private List<LotDetail> details;

    public GetLote() {

    }

    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        LotDetailDAO lddao = new LotDetailDAO();
        
        CategoryDAO dao = new CategoryDAO();
        category = dao.getAll();
        lote = ldao.get(id);
        details = lddao.getAllDetailLot(id);
        return SUCCESS;
    }

    public Lot getLote() {
        return lote;
    }

    public void setLote(Lot lote) {
        this.lote = lote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<LotDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LotDetail> details) {
        this.details = details;
    }

}
