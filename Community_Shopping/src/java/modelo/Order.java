package modelo;
// Generated 03-ago-2017 9:57:55 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order  implements java.io.Serializable {


     private Integer id;
     private Lot lot;
     private User user;
     private String stateOrder;
     private Date createdDate;
     private Date datePurchase;
     private Date deletionDate;
     private Set interlocutorOrders = new HashSet(0);
     private Set purchases = new HashSet(0);

    public Order() {
    }

	
    public Order(Lot lot, String stateOrder, Date createdDate) {
        this.lot = lot;
        this.stateOrder = stateOrder;
        this.createdDate = createdDate;
    }
    public Order(Lot lot, User user, String stateOrder, Date createdDate, Date datePurchase, Date deletionDate, Set interlocutorOrders, Set purchases) {
       this.lot = lot;
       this.user = user;
       this.stateOrder = stateOrder;
       this.createdDate = createdDate;
       this.datePurchase = datePurchase;
       this.deletionDate = deletionDate;
       this.interlocutorOrders = interlocutorOrders;
       this.purchases = purchases;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Lot getLot() {
        return this.lot;
    }
    
    public void setLot(Lot lot) {
        this.lot = lot;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getStateOrder() {
        return this.stateOrder;
    }
    
    public void setStateOrder(String stateOrder) {
        this.stateOrder = stateOrder;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getDatePurchase() {
        return this.datePurchase;
    }
    
    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }
    public Date getDeletionDate() {
        return this.deletionDate;
    }
    
    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }
    public Set getInterlocutorOrders() {
        return this.interlocutorOrders;
    }
    
    public void setInterlocutorOrders(Set interlocutorOrders) {
        this.interlocutorOrders = interlocutorOrders;
    }
    public Set getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set purchases) {
        this.purchases = purchases;
    }




}


