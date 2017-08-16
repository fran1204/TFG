/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advertising.actions;

import DAO.CategoryDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;
import modelo.Category;

/**
 *
 * @author fran
 */
public class GetCategory {
    
    private List<Category> category;
    
     public GetCategory() {
    }
    
    public String execute() throws Exception {
        CategoryDAO dao = new CategoryDAO();
        category = dao.getAll();
        return SUCCESS;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    
}
