package modelo;
// Generated 31-jul-2017 12:27:36 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Purchase generated by hbm2java
 */
public class Purchase  implements java.io.Serializable {


     private Integer id;
     private Order order;
     private PaymentMethod paymentMethod;
     private User user;
     private Date datePurchase;
     private int total;
     private String pdf;

    public Purchase() {
    }

    public Purchase(Order order, PaymentMethod paymentMethod, User user, Date datePurchase, int total, String pdf) {
       this.order = order;
       this.paymentMethod = paymentMethod;
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
    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
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


