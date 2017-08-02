package modelo;
// Generated 02-ago-2017 17:17:28 by Hibernate Tools 4.3.1


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
     private String description;
     private boolean publish;
     private Date createdDate;
     private Integer quantity;
     private Integer price;
     private String size;
     private String color;
     private Integer capacity;
     private Date deletionDate;
     private Set interlocutorOrders = new HashSet(0);
     private Set galleries = new HashSet(0);

    public LotDetail() {
    }

	
    public LotDetail(Lot lot, String title, String description, boolean publish, Date createdDate) {
        this.lot = lot;
        this.title = title;
        this.description = description;
        this.publish = publish;
        this.createdDate = createdDate;
    }
    public LotDetail(Lot lot, String title, String description, boolean publish, Date createdDate, Integer quantity, Integer price, String size, String color, Integer capacity, Date deletionDate, Set interlocutorOrders, Set galleries) {
       this.lot = lot;
       this.title = title;
       this.description = description;
       this.publish = publish;
       this.createdDate = createdDate;
       this.quantity = quantity;
       this.price = price;
       this.size = size;
       this.color = color;
       this.capacity = capacity;
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
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isPublish() {
        return this.publish;
    }
    
    public void setPublish(boolean publish) {
        this.publish = publish;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getSize() {
        return this.size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public Integer getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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


