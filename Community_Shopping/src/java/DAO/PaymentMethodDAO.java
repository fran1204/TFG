/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.PaymentMethod;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class PaymentMethodDAO {
    private Session sesion = null;
    
    public PaymentMethod get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from PaymentMethod WHERE id = '"+id+"'");
        PaymentMethod paymentMethod = (PaymentMethod)q.uniqueResult();
        tx.commit();
        return paymentMethod;
    }
    
    public List<PaymentMethod> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from PaymentMethod");
        List<PaymentMethod> paymentMethod = (List<PaymentMethod>) q.list();
        tx.commit();
        return paymentMethod;
    }
}
