/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import modelo.Channel;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class ChannelDAO {
    private Session sesion = null;
    
     public Channel get(Integer id){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Channel WHERE id = '"+id+"'");
        Channel channel = (Channel)q.uniqueResult();
        tx.commit();
        return channel;
    }
    
    public List<Channel> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Category");
        List<Channel> channel = (List<Channel>) q.list();
        tx.commit();
        return channel;
    }
}
