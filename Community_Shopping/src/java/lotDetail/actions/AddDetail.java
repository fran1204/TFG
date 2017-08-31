/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotDetail.actions;

import DAO.GalleryDAO;
import DAO.LotDAO;
import DAO.LotDetailDAO;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Gallery;
import modelo.Lot;
import modelo.LotDetail;
import org.apache.struts2.ServletActionContext;

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
    private List<File> fileUpload = new ArrayList<File>();
    private List<String> fileUploadContentType = new ArrayList<String>();
    private List<String> fileUploadFileName = new ArrayList<String>();
    private String formatoErroneo;

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
        ld = new LotDetail(lote, titleDetail, true, quantity, color, size, capacity, ahora);
        lddao.add(ld);

        GalleryDAO gdao = new GalleryDAO();

        for (int i = 0; i < 3; i++) {

            if (fileUpload.get(i) != null && (fileUploadContentType.get(i).equals("image/png") || fileUploadContentType.get(i).equals("image/jpg") || fileUploadContentType.get(i).equals("image/jpeg"))) {
                String extension = (fileUploadFileName.get(i).split("\\."))[1];
                String FileName = System.currentTimeMillis() + "." + extension;
                String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
                url = url.split("build")[0] + "web/";
                ldao.resize(fileUpload.get(i).getAbsolutePath(), url + "img/" + FileName, 480, 480);
                Gallery g = new Gallery();
                g.setLotDetail(ld);
                g.setUrl(FileName);
                gdao.add(g);
            } else {
                formatoErroneo = "La imagen tiene el formato erroneo";
                return ERROR;
            }

        }

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

    public List<File> getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(List<File> fileUpload) {
        this.fileUpload = fileUpload;
    }

    public List<String> getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(List<String> fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public List<String> getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(List<String> fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public String getFormatoErroneo() {
        return formatoErroneo;
    }

    public void setFormatoErroneo(String formatoErroneo) {
        this.formatoErroneo = formatoErroneo;
    }

}
