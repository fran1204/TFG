/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.actions;

import DAO.LotDetailDAO;
import DAO.SessionDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.LotDetail;

/**
 *
 * @author fmrodriguez
 */
public class ValidarSesion extends ActionSupport {
    
    private List<LotDetail> lotDetails;
    
    public ValidarSesion() {
        lotDetails = new LotDetailDAO().getAll();
    }
    
    public String execute() throws Exception {
        SessionDAO sdao = new SessionDAO();
        if(sdao.existeSesion()){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    public List<LotDetail> getLotDetails() {
        return lotDetails;
    }

    public void setLotDetails(List<LotDetail> lotDetails) {
        this.lotDetails = lotDetails;
    }
    
    
    
}
