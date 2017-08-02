/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Lot;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class GetUser extends ActionSupport {
    
    private User usuario;
    private String perfil_email;
    private String sesion_email;
    private List<Lot> lotes;
    
    public GetUser() {
        this.sesion_email = (String)new SessionDAO().getSession().get("email");
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        //CiudadDAO cdao = new CiudadDAO();
        //ciudades = cdao.getAll();
        usuario = dao.get(perfil_email);
        return SUCCESS;
    }

    public User getUser() {
        return usuario;
    }

    public void setUser(User usuario) {
        this.usuario = usuario;
    }

    public String getPerfil_email() {
        return perfil_email;
    }

    public void setPerfil_email(String perfil_email) {
        this.perfil_email = perfil_email;
    }

    public String getSesion_email() {
        return sesion_email;
    }

    public void setSesion_email(String sesion_email) {
        this.sesion_email = sesion_email;
    }

//    public List<Ciudad> getCiudades() {
//        return ciudades;
//    }
//
//    public void setCiudades(List<Ciudad> ciudades) {
//        this.ciudades = ciudades;
//    }

    
    
    
    
}
