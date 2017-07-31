package DAO;

import java.util.List;
import modelo.HibernateUtil;
import modelo.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author cayetano
 */
public class UserDAO {
    
    private Session sesion = null;
    
    public boolean validarLogin(String email, String password){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email = '"+email+"' AND password='"+password+"'");
        User usuario = (User)q.uniqueResult();
        tx.commit();
        return usuario!=null;
    }
    
    public User get(String email){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email = '"+email+"'");
        User usuario = (User)q.uniqueResult();
        tx.commit();
        return usuario;
    }
    
    public List<User> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User");
        List<User> usuarios = (List<User>) q.list();
        tx.commit();
        return usuarios;
    }

    public void add(User u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(String email) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        User u = (User) sesion.load(User.class, email);
        sesion.delete(u);
        tx.commit();
    }

    public User update(String email, String password, String nombre, String ciudad, String movil) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email='"+email+"'");
        User u = (User) q.uniqueResult();
       // Usuario u = (Usuario) sesion.load(Usuario.class, email);
//        u.setPassword(password);
//        u.setNombre(nombre);
//        u.setCiudad(new Ciudad(ciudad));
//        u.setMovil(movil);
        sesion.update(u);
        tx.commit();
        return u;
    }
    
    public void updateFoto(String nombre, String email){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email='"+email+"'");
        User u = (User) q.uniqueResult();
       // u.setFoto(nombre);
        sesion.update(u);
        tx.commit();
    }
    
    public boolean existeUsuario(String email){
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email = '"+email+"'");
        User usuario = (User)q.uniqueResult();
        tx.commit();
        return usuario!=null;
    }
}
