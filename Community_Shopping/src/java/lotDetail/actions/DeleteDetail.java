/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotDetail.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Category;
import modelo.Lot;
import modelo.LotDetail;

/**
 *
 * @author fmrodriguez
 */
public class DeleteDetail extends ActionSupport {

    private Lot lote;
    private List<LotDetail> details;
    private int idDetail;
    private int idLot;
    private List<Category> category;

    public DeleteDetail() {

    }

    public String execute() throws Exception {
        LotDetailDAO lddao = new LotDetailDAO();
        LotDAO ldao = new LotDAO();
        lddao.delete(idDetail);
        details = lddao.getAllDetailLot(idLot);
        lote = ldao.get(idLot);
        CategoryDAO dao = new CategoryDAO();
        category = dao.getAll();
        return SUCCESS;
    }

    public Lot getLote() {
        return lote;
    }

    public void setLote(Lot lote) {
        this.lote = lote;
    }

    public List<LotDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LotDetail> details) {
        this.details = details;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
