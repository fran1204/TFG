/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import DAO.CategoryDAO;
import DAO.InterlocutorOrderDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import DAO.SessionDAO;
import DAO.UserDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import modelo.InterlocutorOrder;
import modelo.Lot;
import modelo.LotDetail;
import modelo.User;

/**
 *
 * @author fmrodriguez
 */
public class GetLoteDetail extends ActionSupport{
    private Lot lote;
    private int id;
    private List<LotDetail> details;
    private String category;
    private String session;
    private List<InterlocutorOrder> io;
    
     public GetLoteDetail(){
         this.session = (String)new SessionDAO().getSession().get("email");
     }
     
     public String execute() throws Exception {
        LotDAO ldao = new LotDAO();
        UserDAO dao = new UserDAO();
        InterlocutorOrderDAO iodao = new InterlocutorOrderDAO();
        CategoryDAO cdao = new CategoryDAO();
        lote = ldao.get(id);
        category = cdao.get(lote.getCategory().getId()).getType();
        LotDetailDAO ddao = new LotDetailDAO();
        details = ddao.getAllDetailLot(id);
        User u = dao.get((String) new SessionDAO().getSession().get("email"));
        io = iodao.getLotDetailUser(u);
        
        return SUCCESS;
    }

    public Lot getLote() {
        return lote;
    }

    public void setLote(Lot lote) {
        this.lote = lote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LotDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LotDetail> details) {
        this.details = details;
    }

   

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public List<InterlocutorOrder> getIo() {
        return io;
    }

    public void setIo(List<InterlocutorOrder> io) {
        this.io = io;
    }
     
     
}
