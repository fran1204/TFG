/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.bind.StringInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;

/**
 *
 * @author cayetano
 */
public class ExisteUsuario extends ActionSupport {

    //HttpServletResponse response = ServletActionContext.getResponse();
    private String email;
    private InputStream respuesta;

    public ExisteUsuario() {
    }

    public String execute() throws Exception {
//        response.setContentType("text/plain");
//        PrintWriter out = response.getWriter();
        if (new UserDAO().existeUsuario(email)) {
            respuesta = new StringInputStream("existe");
        } else {
            respuesta = new StringInputStream("noExiste");
        }
        return SUCCESS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InputStream getRespuesta() {
        return respuesta;
    }
}
