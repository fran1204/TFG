/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Advertising;
import modelo.HibernateUtil;
import modelo.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class AdvertisingDAO {
    private Session sesion = null;
    
    public Advertising get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising WHERE id = '"+id+"'");
        Advertising advertising = (Advertising)q.uniqueResult();
        tx.commit();
        return advertising;
    }
    
    public List<Advertising> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising");
        List<Advertising> advertising = (List<Advertising>) q.list();
        tx.commit();
        return advertising;
    }

    public void add(Advertising u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Advertising u = (Advertising) sesion.load(Advertising.class, id);
        sesion.delete(u);
        tx.commit();
    }

    public Advertising update(Integer id, User user, String image, String url) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising WHERE id='"+id+"'");
        Advertising u = (Advertising) q.uniqueResult();
       // Usuario u = (Usuario) sesion.load(Usuario.class, email);
        u.setUser(user);
        u.setImage(image);
        u.setUrl(url);
        sesion.update(u);
        tx.commit();
        return u;
    }
    
}
