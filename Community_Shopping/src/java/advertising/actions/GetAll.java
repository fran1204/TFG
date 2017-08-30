/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import DAO.PayOrderDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Advertising;
import modelo.PayOrder;

/**
 *
 * @author fran
 */
public class GetAll extends ActionSupport {
    private List<Advertising> anuncios;
    private List<PayOrder>payOrder;

    public GetAll() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        PayOrderDAO pdao = new PayOrderDAO();
        anuncios = adao.getAll();
        payOrder = pdao.getAll();
        return SUCCESS;
    }

    public List<Advertising> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Advertising> anuncios) {
        this.anuncios = anuncios;
    }

    public List<PayOrder> getPayOrder() {
        return payOrder;
    }

    public void setPayOrder(List<PayOrder> payOrder) {
        this.payOrder = payOrder;
    }

}
