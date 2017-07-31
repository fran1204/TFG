/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sector.actions;

import DAO.SectorDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import modelo.Sector;

/**
 *
 * @author fmrodriguez
 */
public class GetAll {
      private List<Sector> sectores;
    
    public GetAll() {
        sectores = new ArrayList();
    }
    
    public String execute() throws Exception {
        SectorDAO dao = new SectorDAO();
        sectores = dao.getAll();
        return SUCCESS;
    }

    public List<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(List<Sector> sectores) {
        this.sectores = sectores;
    }
}
