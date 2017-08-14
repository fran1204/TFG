package modelo;
// Generated 14-ago-2017 9:28:28 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Lot generated by hbm2java
 */
public class Lot implements java.io.Serializable {

    private Integer id;
    private Category category;
    private User user;
    private String title;
    private String description;
    private int numSet;
    private Integer quantityAvailable;
    private float price;
    private Date expiryDate;
    private Date createDate;
    private Date deletionDate;
    private String photo;
    private Set shares = new HashSet(0);
    private Set orders = new HashSet(0);
    private Set lotDetails = new HashSet(0);

    public Lot() {
    }

    public Lot(Category category, User user, String title, String description, int numSet, float price, String photo,Date expiryDate, Date createDate) {
        this.category = category;
        this.user = user;
        this.title = title;
        this.description = description;
        this.numSet = numSet;
        this.quantityAvailable = numSet;
        this.price = price;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.photo = photo;
    }

    public Lot(Category category, User user, String title, String description, int numSet, Integer quantityAvailable, float price, Date expiryDate, Date createDate, Date deletionDate, String photo, Set shares, Set orders, Set lotDetails) {
        this.category = category;
        this.user = user;
        this.title = title;
        this.description = description;
        this.numSet = numSet;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.deletionDate = deletionDate;
        this.photo = photo;
        this.shares = shares;
        this.orders = orders;
        this.lotDetails = lotDetails;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getNumSet() {
        return this.numSet;
    }

    public void setNumSet(int numSet) {
        this.numSet = numSet;
    }

    public Integer getQuantityAvailable() {
        return this.quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeletionDate() {
        return this.deletionDate;
    }

    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set getShares() {
        return this.shares;
    }

    public void setShares(Set shares) {
        this.shares = shares;
    }

    public Set getOrders() {
        return this.orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }

    public Set getLotDetails() {
        return this.lotDetails;
    }

    public void setLotDetails(Set lotDetails) {
        this.lotDetails = lotDetails;
    }

}
