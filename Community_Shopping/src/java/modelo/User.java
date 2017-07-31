package modelo;
// Generated 31-jul-2017 12:27:36 by Hibernate Tools 4.3.1


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
     private Date birthdate;
     private String email;
     private String password;
     private String photo;
     private int bank;
     private String companyName;
     private boolean provider;
     private Date createDate;
     private Date deleteDate;
     private Set interlocutorOrders = new HashSet(0);
     private Set lots = new HashSet(0);
     private Set orders = new HashSet(0);
     private Set purchases = new HashSet(0);
     private Set advertisings = new HashSet(0);
     private Set shares = new HashSet(0);

    public User() {
    }

	
    public User(String name, Date birthdate, String email, String password, String photo, int bank, Sector sector ,String companyName, boolean provider, Date createDate) {
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.bank = bank;
        this.sector = sector;
        this.companyName = companyName;
        this.provider = provider;
        this.createDate = createDate;
    }
    public User(Sector sector, String name, Date birthdate, String email, String password, String photo, int bank, String companyName, boolean provider, Date createDate, Date deleteDate, Set interlocutorOrders, Set lots, Set orders, Set purchases, Set advertisings, Set shares) {
       this.sector = sector;
       this.name = name;
       this.birthdate = birthdate;
       this.email = email;
       this.password = password;
       this.photo = photo;
       this.bank = bank;
       this.companyName = companyName;
       this.provider = provider;
       this.createDate = createDate;
       this.deleteDate = deleteDate;
       this.interlocutorOrders = interlocutorOrders;
       this.lots = lots;
       this.orders = orders;
       this.purchases = purchases;
       this.advertisings = advertisings;
       this.shares = shares;
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
    public Date getBirthdate() {
        return this.birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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
    public int getBank() {
        return this.bank;
    }
    
    public void setBank(int bank) {
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
    public Set getLots() {
        return this.lots;
    }
    
    public void setLots(Set lots) {
        this.lots = lots;
    }
    public Set getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set orders) {
        this.orders = orders;
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
    public Set getShares() {
        return this.shares;
    }
    
    public void setShares(Set shares) {
        this.shares = shares;
    }




}


