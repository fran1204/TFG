/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

abstract class AbstratcCrawlerJob extends TimerTask implements AdviceStorage {

    protected String mainUrl;
    protected String list;
    protected String title;
    protected int pagesNumber = 4;

    abstract String[] getPages();

    abstract Object getAdvice(Element advice);

    @Override
    public boolean alreadyVisited(String imgUrl) {
        //comprobar en bd si la url ya está
        return false;
    }

    @Override
    public boolean storeAdvice(String[] o) {
        try {
            // Se registra el Driver de MySQL

            if (o[3].length() <= 155) {

                Connection conexion = db.connection.getConnection();
                // Se crea un Statement, para realizar la consulta
                PreparedStatement s = conexion.prepareStatement("INSERT INTO lot (title,description,price,expiry_date,photo,url_external) VALUES(?,?,?,?,?,?)");

//            java.util.Date ahora = new java.util.Date();
//            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
//            formateador.format(ahora);
                java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
                java.sql.Date tomorrow = new java.sql.Date(now.getTime() + 24 * 60 * 60 * 1000);

                s.setString(1, o[1]);
                s.setString(2, o[3]);
                System.out.println("FRAN: " + o[2]);
                s.setFloat(3, Float.parseFloat(o[2]));
                s.setDate(4, tomorrow);
                s.setString(5, o[0]);
                s.setString(6, o[4]);

                s.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void run() {
        retrieveAdvices();
    }

    public List<Object> retrieveAdvices() {

        List<Object> listO = new ArrayList<Object>();
        try {
            for (String page : getPages()) {
                if (page != null) {
                    Document document = Jsoup.connect(page).get();
                    Elements advicesList = document.select(list);
                    for (Element advice : advicesList) {

                        // listO.add(getAdvice(advice));
                        if (getAdvice(advice) != null) {
                            storeAdvice((String[]) getAdvice(advice));
                        }
                    }
                }

            }

        } catch (IOException e) {
            System.err.println("For '" + mainUrl + "': " + e.getMessage());
        }

        return listO;
    }

}
