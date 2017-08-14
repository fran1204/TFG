/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fran
 */
public class DeleteAnuncio extends ActionSupport {

    private int id;

    public DeleteAnuncio() {

    }

    public String execute() throws Exception {
        AdvertisingDAO dao = new AdvertisingDAO();
        dao.delete(id);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
