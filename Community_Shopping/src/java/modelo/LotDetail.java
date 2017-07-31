package modelo;
// Generated 31-jul-2017 12:27:36 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LotDetail generated by hbm2java
 */
public class LotDetail  implements java.io.Serializable {


     private Integer id;
     private Gallery gallery;
     private Lot lot;
     private String title;
     private String description;
     private boolean publish;
     private Date createdDate;
     private int quantity;
     private int price;
     private int size;
     private int color;
     private int capacity;
     private Date deletionDate;
     private Set interlocutorOrders = new HashSet(0);
     private Set galleries = new HashSet(0);

    public LotDetail() {
    }

	
    public LotDetail(Gallery gallery, Lot lot, String title, String description, boolean publish, Date createdDate, int quantity, int price, int size, int color, int capacity, Date deletionDate) {
        this.gallery = gallery;
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
    }
    public LotDetail(Gallery gallery, Lot lot, String title, String description, boolean publish, Date createdDate, int quantity, int price, int size, int color, int capacity, Date deletionDate, Set interlocutorOrders, Set galleries) {
       this.gallery = gallery;
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
    public Gallery getGallery() {
        return this.gallery;
    }
    
    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
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
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    public int getSize() {
        return this.size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    public int getColor() {
        return this.color;
    }
    
    public void setColor(int color) {
        this.color = color;
    }
    public int getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(int capacity) {
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


