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
    private String emailUser;

    public DeleteOrderLider() {

    }

    public String execute() throws Exception {
        InterlocutorOrderDAO ildao = new InterlocutorOrderDAO();
        OrderDAO odao = new OrderDAO();
        LotDetailDAO lddao = new LotDetailDAO();
        LotDAO ldao = new LotDAO();
        int idUser = (Integer) new SessionDAO().getSession().get("id");
        if (odao.IsLeader(ildao.get(idInterOrder).getUser().getId(), lddao.get(idLotDetail).getLot().getId())) {
            List<InterlocutorOrder> allUserOrder = ildao.getAllUserOrder(ildao.get(idInterOrder).getOrder().getId());
            if (allUserOrder.size() > 1) {
                int idOrder = ildao.get(idInterOrder).getOrder().getId();
                InterlocutorOrder il = ildao.get(idInterOrder);
                int cantDetail = il.getLotDetail().getQuantityAvailable();
                int cantLot = il.getOrder().getLot().getQuantityAvailable();
                int totalDetail = cantDetail + il.getAmount();
                int totalLot = cantLot + il.getAmount();
                lddao.setQuantityAvailable(il.getLotDetail().getId(), totalDetail);
                ldao.setQuantityAvailable(totalLot, il.getOrder().getLot().getId());

                ildao.delete(idLotDetail, idUser);//pasar el user tambien
                allUserOrder = ildao.getAllUserOrder(idOrder);
                odao.updateClienteLider(idOrder, allUserOrder.get(0).getUser());
                emailUser = allUserOrder.get(0).getUser().getEmail();
                //ENVIAR CORREO AL NUEVO CLIENTE LIDER PARA AVISARLO
                //ENVIAR CORREO A LOS ADHERIDOS DEL NUEVO CLIENTE LIDER 
            } else {
                int idOrder = ildao.get(idInterOrder).getOrder().getId();
                ildao.delete(idLotDetail, idUser);
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

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

}
