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
public class SoloStockCrawler extends AbstratcCrawlerJob {

    public SoloStockCrawler() {
        mainUrl = "http://www.solostocks.com/venta-productos";
        list = ".listados__contetent-list a";
        title = "title";
    }

    @Override
    String[] getPages() {
        String[] pages = new String[pagesNumber];
        pages[0] = mainUrl + ":1";
        for (int i = 1; i < pagesNumber; i++) {
            pages[i] = mainUrl + ":" + i;
        }
        return pages;
    }

    @Override
    Object getAdvice(Element advice) {
        String[] obj = null;
        Element img = advice.child(0).child(0);

        String urlImg = img.attr("src");

        if (!alreadyVisited(urlImg)) {
            String sTitle = advice.attr(title);
            Element contentDiv = advice.child(1);
            String pri = contentDiv.child(1).child(0).text();

            String price = "";
            if (pri.indexOf("desde") != -1) {
                String[] prize = pri.split("€");
                price = prize[0];
                price = price.replace(",", ".");
                String[] p = price.split(" ");
                price = p[1];

            } else {
                String[] prize = pri.split("€");
                price = prize[0];
                price = price.replace(",", ".");
            }

            String detail = contentDiv.child(3).text();
            String urlAd = advice.attr("href");
            obj = new String[]{urlImg, sTitle, price, detail, urlAd};
            System.out.println(obj[0] + ": " + obj[1] + " - " + obj[2] + " - " + obj[3]);
        }

        return obj;
    }

}
