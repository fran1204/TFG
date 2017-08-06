/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import java.util.List;
import modelo.Category;
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
        Query q = sesion.createQuery("from Lot Where id_provider=" + u.getId());
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
        Query q = sesion.createQuery("from Lot WHERE id=" + id + "");
        Lot l = (Lot) q.uniqueResult();
        sesion.delete(l);
        tx.commit();
    }

    public Lot update(int id, Category category, String title, String desciption, int numSet, float price, Date expiryDate) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot WHERE id=" + id + "");
        Lot l = (Lot) q.uniqueResult();
        l.setCategory(category);
        l.setDesciption(desciption);
        l.setExpiryDate(expiryDate);
        l.setNumSet(numSet);
        l.setPrice(price);
        l.setTitle(title);
        sesion.update(l);
        tx.commit();
        return l;
    }

    public Lot get(int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot WHERE id = " + id + "");
        Lot lote = (Lot) q.uniqueResult();
        tx.commit();
        return lote;
    }

}
