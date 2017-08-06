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
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fran
 */
public class UpdateFotoPerfil extends ActionSupport{

    private String perfil_email;
    private String nombre_foto;
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    
    public UpdateFotoPerfil(){
        
    }
    
    public String execute() throws Exception {
        if (fileUpload != null && (fileUploadContentType.equals("image/png") || fileUploadContentType.equals("image/jpg") || fileUploadContentType.equals("image/jpeg"))) {
            UserDAO dao = new UserDAO();
            String extension = (fileUploadFileName.split("\\."))[1];
            fileUploadFileName = System.currentTimeMillis() + "." + extension;
            dao.updateFoto(fileUploadFileName, perfil_email);
            dao.resize(fileUpload.getAbsolutePath(), ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"img/" + fileUploadFileName, 480, 480);
            return SUCCESS;
        } else {
            perfil_email = (String)new SessionDAO().getSession().get("email");
            return INPUT;
        }
    }
    
    
}
