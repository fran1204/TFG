/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static javassist.CtMethod.ConstParameter.string;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class UpdateOrderLider extends ActionSupport {

    private int id;
    private int amount;
    private float paidTotal;
    private String datePurchase;
    private String estadoPago;
    private int idOrder;

    public UpdateOrderLider() {

    }

    public String execute() throws Exception {
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(datePurchase);
        InterlocutorOrder io = iodao.update(id, amount, paidTotal, date, estadoPago);
        idOrder = io.getOrder().getId();
        if (idOrder != 0) {
            return SUCCESS;
        } else {
            return INPUT;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPaidTotal() {
        return paidTotal;
    }

    public void setPaidTotal(float paidTotal) {
        this.paidTotal = paidTotal;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

}
