/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fmrodriguez
 */
public class LoginAnonimo extends ActionSupport {

    private int idLote;

    public LoginAnonimo() {

    }

    public String execute() throws Exception {

        return SUCCESS;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }


}
