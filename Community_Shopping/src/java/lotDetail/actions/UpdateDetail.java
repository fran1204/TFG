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
public class UpdateDetail extends ActionSupport {

    private Integer id;
    private Lot lote;
    private List<LotDetail> details;
    private List<Category> category;
    private String title;
    private int quantity;
    private String color;
    private String size;
    private Integer capacity;

    public UpdateDetail() {

    }

    public String execute() throws Exception {
        LotDetailDAO lddao = new LotDetailDAO();
        lddao.update(id, title, quantity, size, color, capacity);
        int idLot = lddao.get(id).getLot().getId();
        details = lddao.getAllDetailLot(idLot);
        LotDAO ldao = new LotDAO();
        lote = ldao.get(idLot);
        CategoryDAO dao = new CategoryDAO();
        category = dao.getAll();
        return SUCCESS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
