/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.PayOrder;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class PayOrderDAO {

    private Session sesion = null;

    public PayOrder get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from PayOrder WHERE id = '" + id + "'");
        PayOrder payOrder = (PayOrder) q.uniqueResult();
        tx.commit();
        return payOrder;
    }

    public List<PayOrder> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from PayOrder");
        List<PayOrder> payOrder = (List<PayOrder>) q.list();
        tx.commit();
        return payOrder;
    }

    public void add(PayOrder u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public PayOrder getByAnuncion(int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from PayOrder WHERE id_advertising = '" + id + "'");
        PayOrder payOrder = (PayOrder) q.uniqueResult();
        tx.commit();
        return payOrder;
    }
}
