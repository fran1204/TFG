/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.InterlocutorOrder;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class InterlocutorOrderDAO {
    private Session sesion = null;
    
    public InterlocutorOrder get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from InterlocutorOrder WHERE id_interlocutor = '"+id+"'");
        InterlocutorOrder interlocutorOrder = (InterlocutorOrder)q.uniqueResult();
        tx.commit();
        return interlocutorOrder;
    }
    
    public List<InterlocutorOrder> getAll() {//Filtro para mostrar agrupado
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from InterlocutorOrder Order by id_interlocutor");
        List<InterlocutorOrder> interlocutorOrder = (List<InterlocutorOrder>) q.list();
        tx.commit();
        return interlocutorOrder;
    }

    public void add(InterlocutorOrder u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        InterlocutorOrder u = (InterlocutorOrder) sesion.load(InterlocutorOrder.class, id);
        sesion.delete(u);
        tx.commit();
    }

}