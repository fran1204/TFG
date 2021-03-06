/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import modelo.User;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fran
 */
public class UpdateFotoPerfil extends ActionSupport {

    private String perfil_email;
    private String nombre_foto;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;

    public UpdateFotoPerfil() {

    }

    public String execute() throws Exception {
        if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
            UserDAO dao = new UserDAO();
            String extension = (fileUploadFileName.split("\\."))[1];
            fileUploadFileName = System.currentTimeMillis() + "." + extension;
            String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
            url = url.split("build")[0] + "web/";
            dao.resize(fileUpload.getAbsolutePath(), url + "img/perfil/" + fileUploadFileName, 480, 480);
            dao.updateFoto(fileUploadFileName,perfil_email);
            if (!nombre_foto.equals("defecto.jpeg")) {
                File fotoAntigua = new File(url + "img/perfil/" + nombre_foto);
                fotoAntigua.delete();
            }

            return SUCCESS;
        } else {
            perfil_email = (String) new SessionDAO().getSession().get("email");
            return INPUT;
        }
    }

    public String getPerfil_email() {
        return perfil_email;
    }

    public void setPerfil_email(String perfil_email) {
        this.perfil_email = perfil_email;
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
