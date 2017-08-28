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
    private List<Lot> lotes;
    private String message;
    private int amount;

    public Adherirse() {

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
        if (order != null) {
            //LotDetail lotDetail, Order order, User user, float paidTotal, int amount, Date createdDate
            iorder = new InterlocutorOrder(ld, order, u, 0, amount, ahora);
            int cantidadDisponible = lddao.getCantidadDisponible(idDetail);
            if (cantidadDisponible >= amount) {
                //actualizo la cantidad disponible del detalle
                int total = cantidadDisponible - amount;
                lddao.setQuantityAvailable(idDetail, total);

                //actualizo la cantidad disponible del lote
                ldao.setQuantityAvailable(l.getQuantityAvailable() - amount, idLot);

                iodao.add(iorder);
                message = "Enhorabuena, te has inscrito en el pedido!!!!";
                return SUCCESS;
            } else {
                message = "La cantidad es mayor de la que disponemos!!!!";
                return ERROR;
            }

        } else {
            int cantidadDisponible = lddao.getCantidadDisponible(idDetail);
            if (cantidadDisponible > amount) {
                //actualizo la cantidad disponible del detalle
                int total = cantidadDisponible - amount;
                lddao.setQuantityAvailable(idDetail, total);

                //actualizo la cantidad disponible del lote
                ldao.setQuantityAvailable(l.getQuantityAvailable() - amount, idLot);

                order = new Order(l, u, "Abierto", ahora);
                odao.add(order);
                iorder = new InterlocutorOrder(ld, order, u, 0, amount, ahora);
                iodao.add(iorder);
                message = "Enhorabuena, eres el CLIENTE LIDER del pedido!!";
                return SUCCESS;
            } else {
                message = "La cantidad es mayor de la que disponemos!!!!";
                return ERROR;
            }

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

    public List<Lot> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lot> lotes) {
        this.lotes = lotes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
