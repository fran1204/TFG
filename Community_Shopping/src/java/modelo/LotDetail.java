package modelo;
// Generated 14-ago-2017 9:28:28 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LotDetail generated by hbm2java
 */
public class LotDetail  implements java.io.Serializable {


     private Integer id;
     private Lot lot;
     private String title;
     private boolean publish;
     private int quantity;
     private String color;
     private String size;
     private Integer capacity;
     private Integer quantityAvailable;
     private Date createdDate;
     private Date deletionDate;
     private Set interlocutorOrders = new HashSet(0);
     private Set galleries = new HashSet(0);

    public LotDetail() {
    }

	
    public LotDetail(Lot lot, String title, boolean publish, int quantity, String color,String size,Integer capacity,Date createdDate) {
        this.lot = lot;
        this.title = title;
        this.publish = publish;
        this.quantity = quantity;
        this.createdDate = createdDate;
        this.quantityAvailable = quantity;
    }
    public LotDetail(Lot lot, String title, boolean publish, int quantity, String color, String size, Integer capacity, Integer quantityAvailable, Date createdDate, Date deletionDate, Set interlocutorOrders, Set galleries) {
       this.lot = lot;
       this.title = title;
       this.publish = publish;
       this.quantity = quantity;
       this.color = color;
       this.size = size;
       this.capacity = capacity;
       this.quantityAvailable = quantityAvailable;
       this.createdDate = createdDate;
       this.deletionDate = deletionDate;
       this.interlocutorOrders = interlocutorOrders;
       this.galleries = galleries;
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
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isPublish() {
        return this.publish;
    }
    
    public void setPublish(boolean publish) {
        this.publish = publish;
    }
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return this.size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    public Integer getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public Integer getQuantityAvailable() {
        return this.quantityAvailable;
    }
    
    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
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
    public Set getInterlocutorOrders() {
        return this.interlocutorOrders;
    }
    
    public void setInterlocutorOrders(Set interlocutorOrders) {
        this.interlocutorOrders = interlocutorOrders;
    }
    public Set getGalleries() {
        return this.galleries;
    }
    
    public void setGalleries(Set galleries) {
        this.galleries = galleries;
    }




}


