/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import com.opensymphony.xwork2.ActionSupport;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class GetDetailOrder extends ActionSupport {
    private int id;
    private InterlocutorOrder io;
    public GetDetailOrder(){
        
    }
    
    public String execute() throws Exception {
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        io = iodao.get(id);       
        
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
    
}
