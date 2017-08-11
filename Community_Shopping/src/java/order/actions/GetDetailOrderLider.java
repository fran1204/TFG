/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.LotDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class GetDetailOrderLider extends ActionSupport {
    private int id;
    private List<InterlocutorOrder> io;
    private float price;

    public GetDetailOrderLider() {

    }

    public String execute() throws Exception {
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        LotDAO ldao = new LotDAO();
        io = iodao.getOrderDetailClienteLider(id);
        int idLot = io.get(0).getLotDetail().getLot().getId();
        price = ldao.getPrecioLot(idLot);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<InterlocutorOrder> getIo() {
        return io;
    }

    public void setIo(List<InterlocutorOrder> io) {
        this.io = io;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
