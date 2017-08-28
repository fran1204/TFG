/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.InterlocutorOrderDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.InterlocutorOrder;

/**
 *
 * @author fran
 */
public class DeleteOrderUser extends ActionSupport {

    public int id;

    public DeleteOrderUser() {

    }

    public String execute() throws Exception {
        InterlocutorOrderDAO odao = new InterlocutorOrderDAO();
        Date hoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(hoy);
        InterlocutorOrder il = odao.get(id);
        LotDetailDAO lddao = new LotDetailDAO();
        LotDAO ldao = new LotDAO();
        int cantDetail = il.getLotDetail().getQuantityAvailable();
        int cantLot = il.getOrder().getLot().getQuantityAvailable();
        int totalDetail = cantDetail + il.getAmount();
        int totalLot = cantLot + il.getAmount();
        lddao.setQuantityAvailable(il.getLotDetail().getId(), totalDetail);
        ldao.setQuantityAvailable(totalLot, il.getOrder().getLot().getId());
        
        odao.deleteOrder(id,hoy);

        return SUCCESS;
    }

}
