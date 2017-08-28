package modelo;
// Generated 28-ago-2017 10:14:22 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sector generated by hbm2java
 */
public class Sector  implements java.io.Serializable {


     private Integer id;
     private String sector;
     private Set users = new HashSet(0);

    public Sector() {
    }

	
    public Sector(String sector) {
        this.sector = sector;
    }
    public Sector(String sector, Set users) {
       this.sector = sector;
       this.users = users;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSector() {
        return this.sector;
    }
    
    public void setSector(String sector) {
        this.sector = sector;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }




}


