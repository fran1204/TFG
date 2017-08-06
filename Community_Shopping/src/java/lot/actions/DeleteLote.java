/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.LotDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author fran
 */
public class DeleteLote extends ActionSupport{
    
    public int id;
    
    public DeleteLote(){
        
    }
    
    public String execute() throws Exception {
        LotDAO dao = new LotDAO();
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
