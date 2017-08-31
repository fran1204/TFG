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
import modelo.LotDetail;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class GalleryDAO {

    private Session sesion = null;

    public Gallery get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Channel WHERE id = '" + id + "'");
        Gallery gallery = (Gallery) q.uniqueResult();
        tx.commit();
        return gallery;
    }

    public List<Gallery> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Gallery");
        List<Gallery> gallery = (List<Gallery>) q.list();
        tx.commit();
        return gallery;
    }

    public void add(Gallery u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(Gallery id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Gallery u = (Gallery) sesion.load(Gallery.class, id);
        sesion.delete(u);
        tx.commit();
    }

    public Gallery update(Integer id, LotDetail lot, String url) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Gallery WHERE id='" + id + "'");
        Gallery u = (Gallery) q.uniqueResult();
        // Usuario u = (Usuario) sesion.load(Usuario.class, email);
        u.setLotDetail(lot);
        u.setUrl(url);
        sesion.update(u);
        tx.commit();
        return u;
    }

    public List<Gallery> getAllDetail(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Gallery where id_lotDetail ="+id);
        List<Gallery> gallery = (List<Gallery>) q.list();
        tx.commit();
        return gallery;
    }
}
