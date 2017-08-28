/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import org.jsoup.nodes.Element;

/**
 *
 * @author S
 */
public class MerkandiCrawler extends AbstratcCrawlerJob {

    public MerkandiCrawler() {
        mainUrl = "https://merkandi.com/products";
        list = ".featured-item";
        title = "title";
    }

    @Override
    String[] getPages() {
        String[] pages = new String[pagesNumber];
        pages[0] = mainUrl + "?page=1&hl=es";
        for (int i = 1; i < pagesNumber; i++) {
            pages[i] = mainUrl + "?page=" + i + "&hl=es";
        }
        return pages;
    }

    @Override
    Object getAdvice(Element advice) {
        String[] obj = null;
        try {
            Element img = advice.child(1).child(0).child(0);
            String urlImg = img.attr("data-src");
            if (!alreadyVisited(urlImg)) {
                String sTitle = advice.attr(title);
                Element contentDiv = advice.child(2).child(0);
                String pri = contentDiv.child(0).text();
                String price = "";
                String[] prize = null;
                boolean eu = false;
                if (pri.indexOf("EUR") != -1) {
                    prize = pri.split("EUR");
                    price = prize[0];
                    price = price.replace(",", ".");
                    eu = true;

                } else if (pri.indexOf("€") != -1) {
                    prize = pri.split("€");
                    price = prize[0];
                    price = price.replace(",", ".");
                    eu = true;
                }

                if (eu) {

                    String detail = contentDiv.child(1).child(0).text();
                    String urlAd = advice.child(1).child(0).attr("href");
                    obj = new String[]{urlImg, sTitle, price, detail, urlAd};
                    System.out.println(obj[0] + ": " + obj[1] + " - " + obj[2] + " - " + obj[3]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
