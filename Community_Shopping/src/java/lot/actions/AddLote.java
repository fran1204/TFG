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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.io.File;
import modelo.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Lot;

/**
 *
 * @author fran
 */
public class AddLote extends ActionSupport {

    private int category;
    private String title;
    private String desciption;
    private int numSet;
    private float price;
    private File photoLote;
    private String userImageContentType;
    private String userImageFileName;
    private String expiryDate;
    private Date createDate;
    private Lot lote;
    private String fechaErronea;

    public AddLote() {

    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        SessionDAO sdao = new SessionDAO();
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
        } else {
            User u = dao.get((String) new SessionDAO().getSession().get("email"));
            lote = new Lot(cdao.get(category), u, title, desciption, numSet, price, userImageFileName, expiry, ahora);
            ldao.add(lote);

            return SUCCESS;
        }

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

    @RequiredStringValidator(message = "Se requiere un titulo.")
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

    @IntRangeFieldValidator(min = "1",
            message = "No puede ser menor que 1")
    public void setNumSet(int numSet) {
        this.numSet = numSet;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public File getPhotoLote() {
        return photoLote;
    }

    public void setPhotoLote(File photoLote) {
        this.photoLote = photoLote;
    }

    public String getUserImageContentType() {
        return userImageContentType;
    }

    public void setUserImageContentType(String userImageContentType) {
        this.userImageContentType = userImageContentType;
    }

    public String getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Lot getLote() {
        return lote;
    }

    public void setLote(Lot lote) {
        this.lote = lote;
    }

    public String getFechaErronea() {
        return fechaErronea;
    }

    public void setFechaErronea(String fechaErronea) {
        this.fechaErronea = fechaErronea;
    }

}
