/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.LotDetailDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import modelo.LotDetail;

/**
 *
 * @author fran
 */
public class GetDetail {
    
    private Integer id;
    private LotDetail detail;
    
     public GetDetail() {
    }
    
    public String execute() throws Exception {
        LotDetailDAO dao = new LotDetailDAO();
        detail = dao.get(id);
        return SUCCESS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LotDetail getDetail() {
        return detail;
    }

    public void setDetail(LotDetail detail) {
        this.detail = detail;
    }
    
    
}
