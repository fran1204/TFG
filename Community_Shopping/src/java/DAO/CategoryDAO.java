/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Category;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class CategoryDAO {
    private Session sesion = null;
    
     public Category get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Category WHERE id = '"+id+"'");
        Category category = (Category)q.uniqueResult();
        tx.commit();
        return category;
    }
    
    public List<Category> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Category");
        List<Category> category = (List<Category>) q.list();
        tx.commit();
        return category;
    }
}
