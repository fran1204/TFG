/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.actions;

import DAO.OrderDAO;
import DAO.PurchaseDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import PDF.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import modelo.Purchase;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author fran
 */
public class PagoRealizado extends ActionSupport {

    private int id; //idOrder

    public PagoRealizado() {

    }

    public String execute() throws Exception {
        OrderDAO odao = new OrderDAO();
        Date hoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(hoy);
        odao.updateState(id, "Pagado", hoy);
        try {
            PDF pdf = new PDF();
            Document document = new Document();
            String url = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
            String name = System.currentTimeMillis() + odao.get(id).getLot().getTitle();
            url = url.split("build")[0] + "web/pdf/" + name + ".pdf";
            File file = new File(url);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            pdf.addMetaData(document);
            String cuerpo = "Lote: " + odao.get(id).getLot().getTitle() + "\n";
            cuerpo += "Cantidad: " + odao.get(id).getLot().getNumSet() + "\n";
            cuerpo += "Total: " + odao.get(id).getLot().getNumSet() * odao.get(id).getLot().getPrice() + "\n";
            cuerpo += "Datos Cliente Lider: " + odao.get(id).getUser().getName() + " / " + odao.get(id).getUser().getEmail();
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String convertido = fechaHora.format(hoy);
            pdf.addTitlePage(document, "Resguardo Pago de Pedido", convertido, cuerpo);
            //pdf.addContent(document);
            document.close();

            PurchaseDAO pdao = new PurchaseDAO();
            Purchase p = new Purchase();
            p.setDatePurchase(hoy);
            p.setOrder(odao.get(id));
            p.setPdf(name + ".pdf");
            p.setUser(odao.get(id).getUser());
            float Total = odao.get(id).getLot().getNumSet() * odao.get(id).getLot().getPrice();
            p.setTotal(Total);
            pdao.add(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
