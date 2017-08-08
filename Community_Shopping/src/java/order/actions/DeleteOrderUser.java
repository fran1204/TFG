/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fran
 */
public class DeleteOrderUser  extends ActionSupport{
    public int id;
    
    public DeleteOrderUser(){
        
    }
    
     public String execute() throws Exception {
         InterlocutorOrderDAO odao = new InterlocutorOrderDAO();
         odao.delete(id);
         
         return SUCCESS;
     }
    
}
