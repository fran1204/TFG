/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fran
 */
public class DeleteUser extends ActionSupport {

    private String email;

    public DeleteUser() {

    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        dao.delete(email);
        return SUCCESS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
