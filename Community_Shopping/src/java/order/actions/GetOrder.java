/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.OrderDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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
        OrderDAO odao = new OrderDAO();
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        orderDetail = iodao.getLotDetailUser(u);
        Iterator ite = orderDetail.iterator();
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(ahora);
        while (ite.hasNext()) {
            InterlocutorOrder io = (InterlocutorOrder) ite.next();
            if (io.getLotDetail().getLot().getExpiryDate().before(ahora)) {
                if (!io.getOrder().getStateOrder().equals("Pagado")) {
                    odao.setState(io.getOrder(), "Caducado");
                    odao.setDateDelete(io.getOrder(), ahora);
                }
            }

        }
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
