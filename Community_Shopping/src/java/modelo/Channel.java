package modelo;
// Generated 04-ago-2017 17:52:38 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Channel generated by hbm2java
 */
public class Channel  implements java.io.Serializable {


     private Integer id;
     private String socialNetwork;
     private Set shares = new HashSet(0);

    public Channel() {
    }

	
    public Channel(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
    public Channel(String socialNetwork, Set shares) {
       this.socialNetwork = socialNetwork;
       this.shares = shares;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSocialNetwork() {
        return this.socialNetwork;
    }
    
    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }
    public Set getShares() {
        return this.shares;
    }
    
    public void setShares(Set shares) {
        this.shares = shares;
    }




}


