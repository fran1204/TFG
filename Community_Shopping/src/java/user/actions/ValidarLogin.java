/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.LotDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import modelo.Lot;

/**
 *
 * @author fmrodriguez
 */
public class ValidarLogin extends ActionSupport {

    private String email;
    private String password;
    private List<Lot> lotes;
    private String mensajeError;

    public ValidarLogin() {
        lotes = new LotDAO().getAll();
    }

    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        UserDAO dao = new UserDAO();
        if (dao.validarLogin(email, password)) {
            sdao.getSession().put("email", email);
            return SUCCESS;
        } else {
            mensajeError = "Usuario o contraseña incorrectos";
            return ERROR;
        }

    }
    public String getEmail() {
        return email;
    }
    
    @StringLengthFieldValidator(
        maxLength = "45",
        message = "El tamaño del email es de máximo ${maxLength} caracteres"
    )
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    @StringLengthFieldValidator(
        maxLength = "45",
        message = "El tamaño del password es de máximo ${maxLength} caracteres"
    )
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    
    
    

}
