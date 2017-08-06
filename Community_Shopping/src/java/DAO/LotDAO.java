/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Lot;
import modelo.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class LotDAO {

    private Session sesion = null;

    public List<Lot> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot");
        List<Lot> lotes = (List<Lot>) q.list();
        tx.commit();
        return lotes;
    }
    public List<Lot> getAllUSer(User u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot Where id_provider="+u.getId());
        List<Lot> lotes = (List<Lot>) q.list();
        tx.commit();
        return lotes;
    }

    public void add(Lot lote) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(lote);
        tx.commit();
    }
    
    public void delete(int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot WHERE id="+id+"");
        Lot l = (Lot) q.uniqueResult();
        sesion.delete(l);
        tx.commit();
    }

}
