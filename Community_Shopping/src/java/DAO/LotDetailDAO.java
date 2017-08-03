/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import static javax.xml.ws.spi.Provider.provider;
import modelo.Gallery;
import modelo.HibernateUtil;
import modelo.Lot;
import modelo.LotDetail;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class LotDetailDAO {
    private Session sesion = null;
    
    public LotDetail get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from LotDetail WHERE id = '"+id+"'");
        LotDetail lotDetail = (LotDetail)q.uniqueResult();
        tx.commit();
        return lotDetail;
    }
    
    public List<LotDetail> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from LotDetail");
        List<LotDetail> lotDetail = (List<LotDetail>) q.list();
        tx.commit();
        return lotDetail;
    }

    public void add(LotDetail u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        LotDetail u = (LotDetail) sesion.load(LotDetail.class, id);
        sesion.delete(u);
        tx.commit();
    }

    public LotDetail update(Integer id, Lot lot,String title,
             Boolean publish, Integer quantity,String size, String color, 
             Integer capacity) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from LotDetail WHERE id='"+id+"'");
        LotDetail u = (LotDetail) q.uniqueResult();
       // Usuario u = (Usuario) sesion.load(Usuario.class, email);
       u.setLot(lot);
       u.setTitle(title);
       u.setPublish(publish);
       u.setQuantity(quantity);
       u.setSize(size);
       u.setColor(color);
       u.setCapacity(capacity);
        sesion.update(u);
        tx.commit();
        return u;
    }
}
