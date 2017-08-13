/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fran
 */
public class DeleteFotoPerfil {

    private String perfil_email;
    private String nombre_foto;

    public DeleteFotoPerfil() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
        url = url.split("build")[0] + "web/img/perfil/";
        File fotoAntigua = new File(url + nombre_foto);
        fotoAntigua.delete();
        dao.updateFoto("defecto.jpeg", perfil_email);
        return SUCCESS;
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
    
}
