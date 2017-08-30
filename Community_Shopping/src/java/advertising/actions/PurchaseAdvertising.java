/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.AdvertisingDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Advertising;

/**
 *
 * @author fran
 */
public class PurchaseAdvertising extends ActionSupport {

    private int id;
    private boolean pago;
    private String datePurchase;

    public PurchaseAdvertising() {

    }

    public String execute() throws Exception {
        AdvertisingDAO adao = new AdvertisingDAO();
        Advertising ad = new Advertising();
        ad = adao.get(id);
        if (pago) {
            ad.setPagado(true);
        } else {
            ad.setPagado(false);
        }
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(datePurchase);
        ad.setPurshaceDate(date);
        adao.updatePurchase(ad);

        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

}
