package modelo;
// Generated 03-ago-2017 9:57:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * InterlocutorOrder generated by hbm2java
 */
public class InterlocutorOrder  implements java.io.Serializable {


     private Integer id;
     private LotDetail lotDetail;
     private Order order;
     private User user;
     private int paidTotal;
     private int amount;
     private Date datePurchase;
     private Date createdDate;
     private Date deletionDate;

    public InterlocutorOrder() {
    }

	
    public InterlocutorOrder(LotDetail lotDetail, Order order, User user, int paidTotal, int amount, Date createdDate) {
        this.lotDetail = lotDetail;
        this.order = order;
        this.user = user;
        this.paidTotal = paidTotal;
        this.amount = amount;
        this.createdDate = createdDate;
    }
    public InterlocutorOrder(LotDetail lotDetail, Order order, User user, int paidTotal, int amount, Date datePurchase, Date createdDate, Date deletionDate) {
       this.lotDetail = lotDetail;
       this.order = order;
       this.user = user;
       this.paidTotal = paidTotal;
       this.amount = amount;
       this.datePurchase = datePurchase;
       this.createdDate = createdDate;
       this.deletionDate = deletionDate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public LotDetail getLotDetail() {
        return this.lotDetail;
    }
    
    public void setLotDetail(LotDetail lotDetail) {
        this.lotDetail = lotDetail;
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
    public int getPaidTotal() {
        return this.paidTotal;
    }
    
    public void setPaidTotal(int paidTotal) {
        this.paidTotal = paidTotal;
    }
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Date getDatePurchase() {
        return this.datePurchase;
    }
    
    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getDeletionDate() {
        return this.deletionDate;
    }
    
    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }




}


