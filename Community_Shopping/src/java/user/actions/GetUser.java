/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.SectorDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import modelo.Sector;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class GetUser extends ActionSupport {

    private User usuario;
    private String perfil_email;
    private String sesion_email;
    private List<Sector> sectores;
    private String bank;

    public GetUser() {
        this.sesion_email = (String) new SessionDAO().getSession().get("email");
        sectores = new ArrayList();
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        SectorDAO sdao = new SectorDAO();
        usuario = dao.get(perfil_email);
        sectores = sdao.getAll();
        if (usuario.getBank() != "" || usuario.getBank() != null) {
            byte[] valueDecoded = Base64.getDecoder().decode(usuario.getBank());
            bank = new String(valueDecoded);
        }
        return SUCCESS;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
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

    public List<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}
