/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.AdvertisingDAO;
import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Category;
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
    private int idLote;
    private List<Category> categoris;
    private List anuncio;

    public ValidarLogin() {
        lotes = new LotDAO().getAll();
        anuncio = new ArrayList(new LotDAO().getAll());
        anuncio.addAll(new AdvertisingDAO().getAll());
        Collections.shuffle(anuncio);
    }

    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        UserDAO dao = new UserDAO();
        CategoryDAO cdao = new CategoryDAO();

        if (dao.validarLogin(email, password)) {
            sdao.getSession().put("email", email);
            sdao.getSession().put("id", dao.get(email).getId());
            sdao.getSession().put("proveedor", dao.get(email).isProvider());
            if (dao.get(email).getId() == 1) {
                return "admin";
            } else if (dao.get(email).isProvider()) {
                return NONE;
            } else if (!dao.get(email).isProvider() && idLote == 0) {
                categoris = cdao.getAll();
                return SUCCESS;
            } else if (idLote != 0 && !dao.get(email).isProvider()) {
                categoris = cdao.getAll();
                return "lotdetail";
            } else {
                mensajeError = "Usuario o contraseña incorrectos";
                return ERROR;
            }
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

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public List<Category> getCategoris() {
        return categoris;
    }

    public void setCategoris(List<Category> categoris) {
        this.categoris = categoris;
    }

    public List getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(List anuncio) {
        this.anuncio = anuncio;
    }

}
