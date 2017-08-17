/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.LotDetailDAO;
import DAO.OrderDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class DeleteOrderLider extends ActionSupport {

    private int idInterOrder;
    private int idLotDetail;

    public DeleteOrderLider() {

    }

    public String execute() throws Exception {
        InterlocutorOrderDAO ildao = new InterlocutorOrderDAO();
        OrderDAO odao = new OrderDAO();
        LotDetailDAO lddao = new LotDetailDAO();
        if (odao.IsLeader(ildao.get(idInterOrder).getUser().getId(), lddao.get(idLotDetail).getLot().getId())) {
            List<InterlocutorOrder> allUserOrder = ildao.getAllUserOrder(ildao.get(idInterOrder).getOrder().getId());
            if (allUserOrder.size() > 1) {
                ildao.delete(idLotDetail);
                allUserOrder = ildao.getAllUserOrder(ildao.get(idInterOrder).getOrder().getId());
                odao.updateClienteLider(ildao.get(idInterOrder).getOrder().getId(),allUserOrder.get(0).getUser());
                //ENVIAR CORREO AL NUEVO CLIENTE LIDER
                //PENSAR ESTO, SI TENGO EL DINERO Y LE PASO AL MARRON AL OTRO QUE?
            }else{
                int idOrder = ildao.get(idInterOrder).getOrder().getId();
                ildao.delete(idLotDetail);
                odao.delete(idOrder);
            }
        }

        return SUCCESS;
    }

    public int getIdInterOrder() {
        return idInterOrder;
    }

    public void setIdInterOrder(int idInterOrder) {
        this.idInterOrder = idInterOrder;
    }

    public int getIdLotDetail() {
        return idLotDetail;
    }

    public void setIdLotDetail(int idLotDetail) {
        this.idLotDetail = idLotDetail;
    }

}
