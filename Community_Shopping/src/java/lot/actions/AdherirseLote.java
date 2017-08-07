/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.CategoryDAO;
import DAO.LotDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Lot;
import modelo.User;

/**
 *
 * @author fran
 */
public class AdherirseLote extends ActionSupport {

    private int idDetail;
    private int idLot;
    private User u;

    public AdherirseLote() {
        
    }

    public String execute() throws Exception {
        

        
        
        
        
        return SUCCESS;
    }
}
