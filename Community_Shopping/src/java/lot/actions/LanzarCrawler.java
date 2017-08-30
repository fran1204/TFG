/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lot.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.mycompany.mavenproject2.*;
import java.util.Timer;

/**
 *
 * @author fran
 */
public class LanzarCrawler extends ActionSupport {

    public LanzarCrawler() {

    }

    public String execute() throws Exception {
        SoloStockCrawler s = new SoloStockCrawler();
        s.retrieveAdvices();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        MerkandiCrawler m = new MerkandiCrawler();
        m.retrieveAdvices();
        
        return SUCCESS;
    }
}
