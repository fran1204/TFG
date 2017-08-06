/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Lot;
import modelo.User;

/**
 *
 * @author fran
 */
public class UpdateLote extends ActionSupport {

    private int category;
    private String title;
    private String desciption;
    private int numSet;
    private float price;
    private String photo;
    private String expiryDate;
    private String fechaErronea;
    private int loteId;
    private Lot lote;

    public UpdateLote() {

    }

    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        CategoryDAO cdao = new CategoryDAO();
        Date ahora = new Date();
        Date expiry = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(ahora);
        expiry = formateador.parse(expiryDate);
        if (expiry.before(ahora)) {
            fechaErronea = "La fecha no puede ser menor que el día actual";
            return ERROR;
        }
        ldao.update(loteId, cdao.get(category), title, desciption, numSet, price, expiry);
        lote = ldao.get(loteId);
        return SUCCESS;

    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getNumSet() {
        return numSet;
    }

    public void setNumSet(int numSet) {
        this.numSet = numSet;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getFechaErronea() {
        return fechaErronea;
    }

    public void setFechaErronea(String fechaErronea) {
        this.fechaErronea = fechaErronea;
    }

    public int getLoteId() {
        return loteId;
    }

    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }

    public Lot getLote() {
        return lote;
    }

    public void setLote(Lot lote) {
        this.lote = lote;
    }

}
