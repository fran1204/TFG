package modelo;
// Generated 16-ago-2017 13:01:14 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Integer id;
     private String type;
     private Set advertisings = new HashSet(0);
     private Set lots = new HashSet(0);

    public Category() {
    }

	
    public Category(String type) {
        this.type = type;
    }
    public Category(String type, Set advertisings, Set lots) {
       this.type = type;
       this.advertisings = advertisings;
       this.lots = lots;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Set getAdvertisings() {
        return this.advertisings;
    }
    
    public void setAdvertisings(Set advertisings) {
        this.advertisings = advertisings;
    }
    public Set getLots() {
        return this.lots;
    }
    
    public void setLots(Set lots) {
        this.lots = lots;
    }




}


