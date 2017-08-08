/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import DAO.OrderDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.InterlocutorOrder;
import modelo.Lot;
import modelo.LotDetail;
import modelo.Order;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class Adherirse extends ActionSupport {
    private int idDetail; 
    private int idLot;
    private User u;
    private Lot l;
    private LotDetail ld;
    private Order order;
    private InterlocutorOrder iorder;
    private int cant;
    private List<Lot> lotes;
            
    public Adherirse(){
        
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        LotDAO ldao = new LotDAO();
        LotDetailDAO lddao = new LotDetailDAO();
        OrderDAO odao = new OrderDAO();
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(ahora);
        u = dao.get((String) new SessionDAO().getSession().get("email"));
        l = ldao.get(idLot);
        order = odao.getOrderByLot(idLot);
        ld = lddao.get(idDetail);
        lotes = ldao.getAll();
        if(order != null) {
            //LotDetail lotDetail, Order order, User user, float paidTotal, int amount, Date createdDate
            iorder = new InterlocutorOrder(ld,order,u,0,cant,ahora);
            iodao.add(iorder);
            return SUCCESS;
        }else {
            //Lot lot,User user, String stateOrder, Date createdDate
            order = new Order(l,u,"Abierto",ahora);
            odao.add(order);
            iorder = new InterlocutorOrder (ld,order,u,0,cant,ahora);
            iodao.add(iorder);            
            return SUCCESS;
        }
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Lot getL() {
        return l;
    }

    public void setL(Lot l) {
        this.l = l;
    }

    public LotDetail getLd() {
        return ld;
    }

    public void setLd(LotDetail ld) {
        this.ld = ld;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public InterlocutorOrder getIorder() {
        return iorder;
    }

    public void setIorder(InterlocutorOrder iorder) {
        this.iorder = iorder;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }
    
    
    
}
