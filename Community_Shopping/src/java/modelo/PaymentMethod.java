package modelo;
// Generated 04-ago-2017 0:17:22 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * PaymentMethod generated by hbm2java
 */
public class PaymentMethod  implements java.io.Serializable {


     private Integer id;
     private String type;
     private Set purchases = new HashSet(0);

    public PaymentMethod() {
    }

	
    public PaymentMethod(String type) {
        this.type = type;
    }
    public PaymentMethod(String type, Set purchases) {
       this.type = type;
       this.purchases = purchases;
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
    public Set getPurchases() {
        return this.purchases;
    }
    
    public void setPurchases(Set purchases) {
        this.purchases = purchases;
    }




}


