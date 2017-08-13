/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotDetail.actions;

import DAO.LotDAO;
import DAO.LotDetailDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Lot;
import modelo.LotDetail;

/**
 *
 * @author fmrodriguez
 */
public class AddDetail extends ActionSupport {
//titleDetail quantity color size  capacity idLote
    private String titleDetail;
    private int quantity;
    private String color;
    private String size;
    private int capacity;
    private LotDetail ld;
    private LotDetailDAO lddao;
    private int idLote;
    
    public AddDetail() {

    }

    public String execute() throws Exception {

        lddao = new LotDetailDAO();
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(ahora);
        LotDAO ldao = new LotDAO();
        Lot lote = ldao.get(idLote);
        //Lot lot, String title, boolean publish, int quantity, String color,String size, Integer capacity,Date createdDate
        ld = new LotDetail(lote,titleDetail,true,quantity,color,size,capacity,ahora);
        
        lddao.add(ld);
        return SUCCESS;
    }

    public String getTitleDetail() {
        return titleDetail;
    }

    public void setTitleDetail(String titleDetail) {
        this.titleDetail = titleDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public LotDetail getLd() {
        return ld;
    }

    public void setLd(LotDetail ld) {
        this.ld = ld;
    }

    public LotDetailDAO getLddao() {
        return lddao;
    }

    public void setLddao(LotDetailDAO lddao) {
        this.lddao = lddao;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    

}
