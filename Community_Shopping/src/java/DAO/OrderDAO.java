/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.HibernateUtil;
import modelo.InterlocutorOrder;
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

    public Order get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id = '" + id + "'");
        Order order = (Order) q.uniqueResult();
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

    public Order update(Integer id, Lot lot, User inter, String state) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id='" + id + "'");
        Order u = (Order) q.uniqueResult();
        // Usuario u = (Usuario) sesion.load(Usuario.class, email);
        u.setLot(lot);
        u.setUser(inter);
        u.setStateOrder(state);
        sesion.update(u);
        tx.commit();
        return u;
    }

    public List<Order> getOrderClienteLider(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id_leader = '" + id + "'");
        List<Order> order = (List<Order>) q.list();
        tx.commit();
        return order;
    }

    public Order getOrderByLot(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id_lot = '" + id + "'");
        Order order = (Order) q.uniqueResult();
        tx.commit();
        return order;
    }

    public boolean IsLeader(Integer idUser, Integer idLot) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id_lot = '" + idLot + "'");
        Order order = (Order) q.uniqueResult();
        tx.commit();
        boolean leader = false;
        if (order.getUser().getId() == idUser) {
            leader = true;
        }
        return leader;
    }

    public void updateClienteLider(Integer id, User user) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id='" + id + "'");
        Order o = (Order) q.uniqueResult();
        o.setUser(user);
        sesion.update(o);
        tx.commit();
    }

    public void setState(Order order, String estado) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id='" + order.getId() + "'");
        Order o = (Order) q.uniqueResult();
        o.setStateOrder(estado);
        sesion.update(o);
        tx.commit();
    }

    public void setDateDelete(Order order, Date hoy) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id='" + order.getId() + "'");
        Order o = (Order) q.uniqueResult();
        o.setDeletionDate(hoy);
        sesion.update(o);
        tx.commit();
    }

    public void updateState(int id, String state, Date hoy) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Order WHERE id='" + id + "'");
        Order o = (Order) q.uniqueResult();
        o.setDatePurchase(hoy);
        o.setStateOrder(state);
        sesion.update(o);
        tx.commit();
    }

}
