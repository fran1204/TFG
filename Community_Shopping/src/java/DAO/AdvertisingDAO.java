/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import modelo.Advertising;
import modelo.Category;
import modelo.HibernateUtil;
import modelo.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author fmrodriguez
 */
public class AdvertisingDAO {

    private Session sesion = null;

    public Advertising get(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising WHERE id = '" + id + "'");
        Advertising advertising = (Advertising) q.uniqueResult();
        tx.commit();
        return advertising;
    }

    public List<Advertising> getAll() {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising");
        List<Advertising> advertising = (List<Advertising>) q.list();
        tx.commit();
        return advertising;
    }

    public List<Advertising> getAllUser(User u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising Where id_provider=" + u.getId());
        List<Advertising> advertising = (List<Advertising>) q.list();
        tx.commit();
        return advertising;
    }

    public void add(Advertising u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        sesion.save(u);
        tx.commit();
    }

    public void delete(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Advertising u = (Advertising) sesion.load(Advertising.class, id);
        sesion.delete(u);
        tx.commit();
    }

    public Advertising update(Integer id, String url, Category category) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising WHERE id='" + id + "'");
        Advertising u = (Advertising) q.uniqueResult();
        u.setUrl(url);
        u.setCategory(category);
        sesion.update(u);
        tx.commit();
        return u;
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

    public void updateFoto(String fileUploadFileName, int id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising WHERE id=" + id);
        Advertising a = (Advertising) q.uniqueResult();
        a.setImage(fileUploadFileName);
        sesion.update(a);
        tx.commit();
    }

    public List<Advertising> getAllFiltro(Integer idCategory) {
         sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Advertising WHERE id_category = " + idCategory );
        List<Advertising> ad = (List<Advertising>) q.list();
        tx.commit();
        return ad;
    }
}
