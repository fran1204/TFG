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
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.io.File;
import modelo.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Lot;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fran
 */
public class AddLote extends ActionSupport {

    private int category;
    private String title;
    private String description;
    private int numSet;
    private float price;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
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
            if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
                String extension = (fileUploadFileName.split("\\."))[1];
                fileUploadFileName = System.currentTimeMillis() + "." + extension;
                String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
                url = url.split("build")[0]+"web/";
                ldao.resize(fileUpload.getAbsolutePath(), url + "img/" + fileUploadFileName, 480, 480);
                //Category category, User user, String title, String description, int numSet, float price, String photo,Date expiryDate, Date createDate
                lote = new Lot(cdao.get(category), u, title, description, numSet, price, fileUploadFileName, expiry, ahora);
                ldao.add(lote);
                return SUCCESS;
            } else {
                fechaErronea = "La imagen tiene el formato erroneo";
                return ERROR;
            }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
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
