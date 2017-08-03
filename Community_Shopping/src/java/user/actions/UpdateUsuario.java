/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.List;
import modelo.User;

/**
 *
 * @author Naiara
 */
public class UpdateUsuario extends ActionSupport {

    private String nombre;
    private String password;
    private User usuario;
    private String sesion_email;
    private String perfil_email;
    

    public UpdateUsuario() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        sesion_email=(String)new SessionDAO().getSession().get("email");
        usuario=dao.update(sesion_email,password, nombre);
        System.out.println("FRANNNNNN "+perfil_email);
        
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    @RequiredStringValidator(message = "Se requiere un nombre.")
    @StringLengthFieldValidator(
        maxLength = "45",
        message = "El tamaño del nombre es de máximo ${maxLength} caracteres"
    )
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Se requiere una contraseña.")
    @StringLengthFieldValidator(
        minLength="6",
        maxLength = "45",
        message = "La contraseña debe tener entre ${minLength} y ${maxLength} caracteres"
    )
    public void setPassword(String password) {
        this.password = password;
    }

   
    public User getUsuario() {
        usuario = new UserDAO().get((String)new SessionDAO().getSession().get("email"));
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getSesion_email() {
        sesion_email=(String)new SessionDAO().getSession().get("email");
        return sesion_email;
    }

    public void setSesion_email(String sesion_email) {
        this.sesion_email = sesion_email;
    }
    public String getPerfil_email() {
        perfil_email=(String)new SessionDAO().getSession().get("email");
        return sesion_email;
    }

    public void setPerfil_email(String perfil_email) {
        this.perfil_email = perfil_email;
    }

    
}
