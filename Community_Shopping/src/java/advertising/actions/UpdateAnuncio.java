/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Advertising;
import modelo.User;

/**
 *
 * @author fran
 */
public class UpdateAnuncio extends ActionSupport {

    private List<Advertising> anuncios;
    private String image;
    private String url;
    private int duration;
    private Advertising a;
    private int id;

    public UpdateAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        anuncios = adao.getAllUser(u);
        a=adao.update(id,image,url,duration);
        return SUCCESS;
    }
}
