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
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class GetDetailOrderLider extends ActionSupport {

    private int id; // id del pedido
    private List<InterlocutorOrder> io;
    private float price;
    private int cantidadOferta;
    private boolean comprar;
    private String bank;

    public GetDetailOrderLider() {

    }

    public String execute() throws Exception {
        comprar = false;
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        LotDAO ldao = new LotDAO();
        io = iodao.getOrderDetailClienteLider(id);
        int idLot = io.get(0).getLotDetail().getLot().getId();
        price = ldao.getPrecioLot(idLot);
        cantidadOferta = io.get(0).getLotDetail().getLot().getNumSet();
        Iterator it = io.iterator();
        boolean pagado = true;
        while (it.hasNext()) {
            InterlocutorOrder intorder = (InterlocutorOrder) it.next();
            if (!intorder.getState().equals("pagado")) {
                pagado = false;
            }
        }

        if (pagado) {
            if (ldao.get(idLot).getQuantityAvailable() == 0) {
                comprar = true;
                byte[] valueDecoded = Base64.getDecoder().decode(ldao.get(idLot).getUser().getBank());
                bank = new String(valueDecoded);
            }
        }

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

    public int getCantidadOferta() {
        return cantidadOferta;
    }

    public void setCantidadOferta(int cantidadOferta) {
        this.cantidadOferta = cantidadOferta;
    }

    public boolean isComprar() {
        return comprar;
    }

    public void setComprar(boolean comprar) {
        this.comprar = comprar;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}
