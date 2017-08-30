/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.PurchaseDAO;
import com.opensymphony.xwork2.ActionSupport;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class GetDetailOrder extends ActionSupport {
    private int id;
    private InterlocutorOrder io;
    private String pdf;
    
    public GetDetailOrder(){
        
    }
    
    public String execute() throws Exception {
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        io = iodao.get(id); 
        PurchaseDAO pdao = new PurchaseDAO();
        pdf = pdao.getByOrder(iodao.get(id).getOrder().getId()).getPdf();
        
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InterlocutorOrder getIo() {
        return io;
    }

    public void setIo(InterlocutorOrder io) {
        this.io = io;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
    
}
