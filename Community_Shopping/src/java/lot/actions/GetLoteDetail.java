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
import modelo.Lot;
import modelo.LotDetail;

/**
 *
 * @author fmrodriguez
 */
public class GetLoteDetail extends ActionSupport{
    private Lot lote;
    private int id;
    private List<LotDetail> details;
    private String category;
    
     public GetLoteDetail(){
         
     }
     
     public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        CategoryDAO cdao = new CategoryDAO();
        lote = ldao.get(id);
        category = cdao.get(lote.getCategory().getId()).getType();
        LotDetailDAO ddao = new LotDetailDAO();
        details = ddao.getAllDetailLot(id);
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

    public List<LotDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LotDetail> details) {
        this.details = details;
    }

   

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
     
     
}
