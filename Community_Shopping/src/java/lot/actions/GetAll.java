/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.LotDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.Lot;

/**
 *
 * @author fran
 */
public class GetAll extends ActionSupport {

    private List<Lot> lotess;
    
    public GetAll() {

    }

    public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        lotess = ldao.getAll();
        return SUCCESS;
    }

    public List<Lot> getLotess() {
        return lotess;
    }

    public void setLotess(List<Lot> lotess) {
        this.lotess = lotess;
    }
    
    
}
