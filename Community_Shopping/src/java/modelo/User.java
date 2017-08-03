package modelo;
// Generated 04-ago-2017 0:17:22 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer id;
     private Sector sector;
     private String name;
     private String email;
     private String password;
     private String photo;
     private Integer bank;
     private String companyName;
     private boolean provider;
     private Date createDate;
     private Date deleteDate;
     private Set interlocutorOrders = new HashSet(0);
     private Set orders = new HashSet(0);
     private Set shares = new HashSet(0);
     private Set lots = new HashSet(0);
     private Set purchases = new HashSet(0);
     private Set advertisings = new HashSet(0);

    public User() {
    }

	
    public User(String email, String password, boolean provider, Date createDate) {
        this.email = email;
        this.password = password;
        this.provider = provider;
        this.createDate = createDate;
    }
    public User(Sector sector, String name, String email, String password, String photo, Integer bank, String companyName, boolean provider, Date createDate, Date deleteDate, Set interlocutorOrders, Set orders, Set shares, Set lots, Set purchases, Set advertisings) {
       this.sector = sector;
       this.name = name;
       this.email = email;
       this.password = password;
       this.photo = photo;
       this.bank = bank;
       this.companyName = companyName;
       this.provider = provider;
       this.createDate = createDate;
       this.deleteDate = deleteDate;
       this.interlocutorOrders = interlocutorOrders;
       this.orders = orders;
       this.shares = shares;
       this.lots = lots;
       this.purchases = purchases;
       this.advertisings = advertisings;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Sector getSector() {
        return this.sector;
    }
    
    public void setSector(Sector sector) {
        this.sector = sector;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Integer getBank() {
        return this.bank;
    }
    
    public void setBank(Integer bank) {
        this.bank = bank;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public boolean isProvider() {
        return this.provider;
    }
    
    public void setProvider(boolean provider) {
        this.provider = provider;
    }
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getDeleteDate() {
        return this.deleteDate;
    }
    
    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }
    public Set getInterlocutorOrders() {
        return this.interlocutorOrders;
    }
    
    public void setInterlocutorOrders(Set interlocutorOrders) {
        this.interlocutorOrders = interlocutorOrders;
    }
    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
    }
    public Set getShares() {
        return this.shares;
    }
    
    public void setShares(Set shares) {
        this.shares = shares;
    }
    public Set getLots() {
        return this.lots;
    }
    
    public void setLots(Set lots) {
        this.lots = lots;
    }
    public Set getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set purchases) {
        this.purchases = purchases;
    }
    public Set getAdvertisings() {
        return this.advertisings;
    }
    
    public void setAdvertisings(Set advertisings) {
        this.advertisings = advertisings;
    }




}


