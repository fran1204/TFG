/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import modelo.User;

/**
 *
 * @author fran
 */
public class GetAllUser {

    private List<User> interlocutor;
    private List<User> proveedor;
    private List<User> prov;

    public GetAllUser() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        interlocutor = dao.getAllInterlocutor();
        prov = dao.getAllProveedor();

        Iterator it = prov.iterator();
        proveedor = new ArrayList<User>();
        while (it.hasNext()) {
            User p = (User) it.next();
            byte[] valueDecoded = Base64.getDecoder().decode(p.getBank());
            String bank = new String(valueDecoded);
            p.setBank(bank);
            proveedor.add(p);
        }

        return SUCCESS;
    }

    public List<User> getInterlocutor() {
        return interlocutor;
    }

    public void setInterlocutor(List<User> interlocutor) {
        this.interlocutor = interlocutor;
    }

    public List<User> getProveedor() {
        return proveedor;
    }

    public void setProveedor(List<User> proveedor) {
        this.proveedor = proveedor;
    }

    public List<User> getProv() {
        return prov;
    }

    public void setProv(List<User> prov) {
        this.prov = prov;
    }

}
