/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import DAO.CategoryDAO;
import DAO.PayOrderDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import PDF.PDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Advertising;
import modelo.PayOrder;
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
            int total= 0;

            //CREAR ORDEN DE PAGO
            PDF pdf = new PDF();
            Document document = new Document();
            String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
            String name = System.currentTimeMillis() + u.getCompanyName();
            url = url.split("build")[0] + "web/pdf/" + name + ".pdf";
            File file = new File(url);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            pdf.addMetaData(document);
            String cuerpo = "ID Anuncio: " + a.getId() + "\n"
                    + "Proveedor: " + a.getUser().getName() + "Compañia: " + a.getUser().getCompanyName() + "\n"
                    + "Fecha Creación: " + a.getCreatedDate() + "\n" + "Duración: " + a.getDuration() + " mes \n";
            if (a.getDuration() == 1) {
                cuerpo += "Total a pagar: 30€";
                total = 30;
            } else {
                cuerpo += "Total a pagar: 75€";
                total = 75;
            }

            Date hoy = new Date();
            formateador.format(hoy);
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String convertido = fechaHora.format(hoy);
            pdf.addTitlePage(document, "Orden de Pago", convertido, cuerpo);
            //pdf.addContent(document);
            document.close();

            PayOrderDAO podao = new PayOrderDAO();
            PayOrder po = new PayOrder();
            po.setAdvertising(a);
            po.setPdf(name + ".pdf");
            po.setTotal(total);
            po.setPaymentDate(ahora);
            podao.add(po);

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
