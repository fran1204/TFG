package DAO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import modelo.HibernateUtil;
import modelo.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class UserDAO {

    private Session sesion = null;

    public boolean validarLogin(String email, String password) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email = '" + email + "' AND password='" + password + "'");
        User usuario = (User) q.uniqueResult();
        tx.commit();
        return usuario != null;
    }

    public User get(String email) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email = '" + email + "'");
        User usuario = (User) q.uniqueResult();
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

    public void delete(int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        User u = (User) sesion.load(User.class, id);
        sesion.delete(u);
        tx.commit();
    }

    public User update(String email, String password, String nombre) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email='" + email + "'");
        User u = (User) q.uniqueResult();
        // Usuario u = (Usuario) sesion.load(Usuario.class, email);
        u.setPassword(password);
        u.setName(nombre);
//        u.setCiudad(new Ciudad(ciudad));
//        u.setMovil(movil);
        sesion.update(u);
        tx.commit();
        return u;
    }

    public void updateFoto(String nombre, String email) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email='" + email + "'");
        User u = (User) q.uniqueResult();
        u.setPhoto(nombre);
        sesion.update(u);
        tx.commit();
    }

    public boolean existeUsuario(String email) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from User WHERE email = '" + email + "'");
        User usuario = (User) q.uniqueResult();
        tx.commit();
        return usuario != null;
    }

    public void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {

        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
}
