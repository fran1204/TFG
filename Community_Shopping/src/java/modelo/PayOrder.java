package modelo;
// Generated 16-ago-2017 13:01:14 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PayOrder generated by hbm2java
 */
public class PayOrder  implements java.io.Serializable {


     private Integer id;
     private Advertising advertising;
     private Date paymentDate;
     private int total;
     private String pdf;

    public PayOrder() {
    }

    public PayOrder(Advertising advertising, Date paymentDate, int total, String pdf) {
       this.advertising = advertising;
       this.paymentDate = paymentDate;
       this.total = total;
       this.pdf = pdf;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Advertising getAdvertising() {
        return this.advertising;
    }
    
    public void setAdvertising(Advertising advertising) {
        this.advertising = advertising;
    }
    public Date getPaymentDate() {
        return this.paymentDate;
    }
    
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    public String getPdf() {
        return this.pdf;
    }
    
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }




}


