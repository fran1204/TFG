/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 *
 * @author fran
 */
public class DeleteFotoPerfil {

    private String perfil_email;

    public DeleteFotoPerfil() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        dao.updateFoto("defecto.jpeg", perfil_email);
        return SUCCESS;
    }

    public String getPerfil_email() {
        return perfil_email;
    }

    public void setPerfil_email(String perfil_email) {
        this.perfil_email = perfil_email;
    }
}
