/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.InterlocutorOrder;
import modelo.User;

/**
 *
 * @author fran
 */
public class GetOrder extends ActionSupport {
    private List<InterlocutorOrder> orderDetail;
    private String message;
    private User session;
    
    public GetOrder() {

    }

    public String execute() throws Exception {
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        UserDAO dao = new UserDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        orderDetail = iodao.getLotDetailUser(u);
        session = u;
        
        return SUCCESS;
    }

    public List<InterlocutorOrder> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<InterlocutorOrder> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSession() {
        return session;
    }

    public void setSession(User session) {
        this.session = session;
    }

  
}
