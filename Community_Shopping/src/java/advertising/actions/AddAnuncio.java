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
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Advertising;
import modelo.User;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fran
 */
public class AddAnuncio extends ActionSupport {

    private List<Advertising> anuncios;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private String url;
    private int duration;
    private Advertising a;
    private String ErrorImg;
    private int category;

    public AddAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        anuncios = adao.getAllUser(u);
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(ahora);
        if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
            String extension = (fileUploadFileName.split("\\."))[1];
            fileUploadFileName = System.currentTimeMillis() + "." + extension;
            String urlDir = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
            urlDir = urlDir.split("build")[0] + "web/";

            adao.resize(fileUpload.getAbsolutePath(), urlDir + "img/" + fileUploadFileName, 480, 480);
            CategoryDAO cdao = new CategoryDAO();
            //Category category, User user, String image, String url, Date createdDate, int duration
            a = new Advertising(cdao.get(category), u, fileUploadFileName, url, ahora, duration);
            adao.add(a);
            return SUCCESS;
        } else {
            ErrorImg = "La imagen tiene el formato erroneo";
            return ERROR;
        }

    }

    public List<Advertising> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Advertising> anuncios) {
        this.anuncios = anuncios;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Advertising getA() {
        return a;
    }

    public void setA(Advertising a) {
        this.a = a;
    }

    public String getErrorImg() {
        return ErrorImg;
    }

    public void setErrorImg(String ErrorImg) {
        this.ErrorImg = ErrorImg;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
