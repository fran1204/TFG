package modelo;
// Generated 30-ago-2017 1:10:38 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Purchase generated by hbm2java
 */
public class Purchase  implements java.io.Serializable {


     private Integer id;
     private Order order;
     private User user;
     private Date datePurchase;
     private float total;
     private String pdf;

    public Purchase() {
    }

    public Purchase(Order order, User user, Date datePurchase, float total, String pdf) {
       this.order = order;
       this.user = user;
       this.datePurchase = datePurchase;
       this.total = total;
       this.pdf = pdf;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Date getDatePurchase() {
        return this.datePurchase;
    }
    
    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }
    public float getTotal() {
        return this.total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    public String getPdf() {
        return this.pdf;
    }
    
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }




}


