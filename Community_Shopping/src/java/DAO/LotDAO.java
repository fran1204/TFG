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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
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
        Query q = sesion.createQuery("from Lot where expiry_date > now() order by expiry_date ASC");
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

    public Lot update(int id, Category category, String title, String description, int numSet, float price, Date expiryDate) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot WHERE id=" + id + "");
        Lot l = (Lot) q.uniqueResult();
        l.setCategory(category);
        l.setDescription(description);
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
        Query q = sesion.createQuery("from Lot WHERE id = " + id);
        Lot lote = (Lot) q.uniqueResult();
        tx.commit();
        return lote;
    }

    public List<Lot> getLotProviver(User u) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot Where id_provider=" + u.getId() + " order by create_date ASC");
        List<Lot> lotes = (List<Lot>) q.list();
        tx.commit();
        return lotes;
    }

    public float getPrecioLot(int idLot) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("select price from Lot WHERE id = " + idLot);
        float price = (float) q.uniqueResult();
        tx.commit();
        return price;
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

    public void updateFoto(String fileUploadFileName, int idLote) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot WHERE id=" + idLote);
        Lot l = (Lot) q.uniqueResult();
        l.setPhoto(fileUploadFileName);
        sesion.update(l);
        tx.commit();
    }

     public List<Lot> getAllFiltro(Integer id) {
        sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = sesion.beginTransaction();
        Query q = sesion.createQuery("from Lot WHERE id_category = "+id+" AND expiry_date > now() order by expiry_date ASC");
        List<Lot> lotes = (List<Lot>) q.list();
        tx.commit();
        return lotes;
    }
}
