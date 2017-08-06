/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Advertising;
import modelo.User;

/**
 *
 * @author fran
 */
public class GetAnuncios extends ActionSupport {
    
    private List<Advertising> anuncios;

    public GetAnuncios() {

    }
    
    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        anuncios = adao.getAllUser(u);        
        return SUCCESS;
    }

    public List<Advertising> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Advertising> anuncios) {
        this.anuncios = anuncios;
    }
    
    

}
