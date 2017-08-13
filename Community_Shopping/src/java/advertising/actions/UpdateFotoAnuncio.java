/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import modelo.Advertising;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fmrodriguez
 */
public class UpdateFotoAnuncio extends ActionSupport {

    private int idAnuncio;
    private String nombre_foto;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    public UpdateFotoAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
            String extension = (fileUploadFileName.split("\\."))[1];
            fileUploadFileName = System.currentTimeMillis() + "." + extension;
            String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
            url = url.split("build")[0] + "web/";
            adao.resize(fileUpload.getAbsolutePath(), url + "img/" + fileUploadFileName, 480, 480);
            adao.updateFoto(fileUploadFileName, idAnuncio);
            File fotoAntigua = new File(url + "img/" + nombre_foto);
            fotoAntigua.delete();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
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

}
