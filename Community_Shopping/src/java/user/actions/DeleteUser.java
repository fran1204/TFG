/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fran
 */
public class DeleteUser extends ActionSupport {

    private String perfil_email;

    public DeleteUser() {

    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        int id =dao.get(perfil_email).getId();
        dao.delete(id);
        SessionDAO sdao = new SessionDAO();
        sdao.destroySession();
        return SUCCESS;
    }

    public String getPerfil_email() {
        return perfil_email;
    }

    public void setPerfil_email(String perfil_email) {
        this.perfil_email = perfil_email;
    }

}
