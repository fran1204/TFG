/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Purchase;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class PurchaseDAO {

    private Session sesion = null;

    public Purchase get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Purchase WHERE id = '" + id + "'");
        Purchase purchase = (Purchase) q.uniqueResult();
        tx.commit();
        return purchase;
    }

    public List<Purchase> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Purchase");
        List<Purchase> purchase = (List<Purchase>) q.list();
        tx.commit();
        return purchase;
    }

    public void add(Purchase u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public Purchase getByOrder(int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Purchase WHERE id_order = '" + id + "'");
        Purchase purchase = (Purchase) q.uniqueResult();
        tx.commit();
        return purchase;
    }
}
