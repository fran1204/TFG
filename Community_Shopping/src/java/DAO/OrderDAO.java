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
import modelo.Order;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class OrderDAO {
     private Session sesion = null;
    
    public Order get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id = '"+id+"'");
        Order order = (Order)q.uniqueResult();
        tx.commit();
        return order;
    }
    
    public List<Order> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order");
        List<Order> order = (List<Order>) q.list();
        tx.commit();
        return order;
    }

    public void add(Order u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Order u = (Order) sesion.load(Order.class, id);
        sesion.delete(u);
        tx.commit();
    }

    public Order update(Integer id, Lot lot,User inter, String state) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id='"+id+"'");
        Order u = (Order) q.uniqueResult();
       // Usuario u = (Usuario) sesion.load(Usuario.class, email);
       u.setLot(lot);
       u.setUser(inter);
       u.setStateOrder(state);
        sesion.update(u);
        tx.commit();
        return u;
    }
    
    public List<Order> getOrderClienteLider(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id_leader = '"+id+"'");
         List<Order> order = (List<Order>) q.list();
        tx.commit();
        return order;
    }
    
}
