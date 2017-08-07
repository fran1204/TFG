/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Sector;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class SectorDAO {

    private Session sesion = null;

    public List<Sector> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Sector");
        List<Sector> sectores = (List<Sector>) q.list();
        tx.commit();
        return sectores;
    }

    public Sector getSectorById(String sector) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Sector WHERE id='"+sector+"'");
        Sector s = (Sector) q.uniqueResult();
        tx.commit();
        return s;
    }
}
