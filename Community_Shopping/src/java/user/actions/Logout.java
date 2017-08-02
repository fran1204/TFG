/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SessionDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fmrodriguez
 */
public class Logout extends ActionSupport {
    
    public Logout() {
    }
    
    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        sdao.destroySession();
        return SUCCESS;
    }
    
}
