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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Advertising;
import modelo.User;

/**
 *
 * @author fran
 */
public class AddAnuncio extends ActionSupport {

    private List<Advertising> anuncios;
    private String image;
    private String url;
    private int duration;
    private Advertising a;

    public AddAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        anuncios = adao.getAllUser(u);
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(ahora);
        a = new Advertising(u, image, url,ahora,duration);
        adao.add(a);
        return SUCCESS;
    }

    public List<Advertising> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Advertising> anuncios) {
        this.anuncios = anuncios;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Advertising getA() {
        return a;
    }

    public void setA(Advertising a) {
        this.a = a;
    }

    

}
