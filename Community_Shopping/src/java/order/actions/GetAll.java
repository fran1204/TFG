/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.OrderDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Order;

/**
 *
 * @author fran
 */
public class GetAll extends ActionSupport {
    private List<Order> orders;
    
    public GetAll() {

    }

    public String execute() throws Exception {
        OrderDAO odao = new OrderDAO();
        orders = odao.getAll();
        return SUCCESS;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
}
