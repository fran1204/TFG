/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.List;
import modelo.User;

/**
 *
 * @author Naiara
 */
public class AddUser extends ActionSupport {

    private String email;
   // private String ciudad;
    private String name;
    private String password;
    private User u;
    //private List<Ciudad> ciudades;
    private String existeUsuario;

    public AddUser() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        SessionDAO sdao = new SessionDAO();

        if (dao.existeUsuario(email)) {
            existeUsuario = "El usuario ya existe.";
            return ERROR;
        } else {
            u = new User();
            //u.setFoto("defecto.jpeg");
            dao.add(u);
            sdao.getSession().put("email", email);
            return SUCCESS;
        }
    }
    
    @Override
    public void validate(){
        if(email==null || email.equals("")){
            addFieldError("email", "Se requiere un email.");
        }else{
            if(email.length()>45){
                addFieldError("email", "El tamaño del email es de máximo 45 caracteres");
             }else{
                if(!email.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$")){
                    addFieldError("email","Formato del email incorrecto");
                }
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getCiudad() {
//        return ciudad;
//    }
//
//    public void setCiudad(String ciudad) {
//        this.ciudad = ciudad;
//    }

    public String getName() {
        return name;
    }

    @RequiredStringValidator(message = "Se requiere un nombre.")
    @StringLengthFieldValidator(
        maxLength = "45",
        message = "El tamaño del nombre es de máximo ${maxLength} caracteres"
    )
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Se requiere una contraseña.")
    @StringLengthFieldValidator(
        minLength="5",
        maxLength = "45",
        message = "La contraseña debe tener entre ${minLength} y ${maxLength} caracteres"
    )
    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Ciudad> getCiudades() {
//        ciudades = new CiudadDAO().getAll();
//        return ciudades;
//    }
//
//    public void setCiudades(List<Ciudad> ciudades) {
//        this.ciudades = ciudades;
//    }

    public String isExisteUsuario() {
        return existeUsuario;
    }

    public void setExisteUsuario(String existeUsuario) {
        this.existeUsuario = existeUsuario;
    }

}
