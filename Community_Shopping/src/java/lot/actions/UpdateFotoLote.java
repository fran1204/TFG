/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import DAO.SessionDAO;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.List;
import modelo.Category;
import modelo.Lot;
import modelo.LotDetail;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fmrodriguez
 */
public class UpdateFotoLote extends ActionSupport {

    private int idLote;
    private String nombre_foto;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private Lot lote;
    private List<Category> category;
    private List<LotDetail> details;

    public UpdateFotoLote() {

    }

    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
            String extension = (fileUploadFileName.split("\\."))[1];
            fileUploadFileName = System.currentTimeMillis() + "." + extension;
            String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
            url = url.split("build")[0] + "web/";
            ldao.resize(fileUpload.getAbsolutePath(), url + "img/" + fileUploadFileName, 480, 480);
            ldao.updateFoto(fileUploadFileName, idLote);
            if (!nombre_foto.equals("defecto.jpeg")) {
                File fotoAntigua = new File(url + "img/perfil/" + nombre_foto);
                fotoAntigua.delete();
            }
            LotDetailDAO lddao = new LotDetailDAO();
            CategoryDAO dao = new CategoryDAO();
            category = dao.getAll();
            lote = ldao.get(idLote);
            details = lddao.getAllDetailLot(lote.getId());
            return SUCCESS;
        } else {

            return INPUT;
        }
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public String getNombre_foto() {
        return nombre_foto;
    }

    public void setNombre_foto(String nombre_foto) {
        this.nombre_foto = nombre_foto;
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

    public Lot getLote() {
        return lote;
    }

    public void setLote(Lot lote) {
        this.lote = lote;
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
