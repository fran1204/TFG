package modelo;
// Generated 03-ago-2017 9:57:55 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Gallery generated by hbm2java
 */
public class Gallery  implements java.io.Serializable {


     private Integer id;
     private LotDetail lotDetail;
     private String url;
     private Date deletionDate;

    public Gallery() {
    }

	
    public Gallery(LotDetail lotDetail, String url) {
        this.lotDetail = lotDetail;
        this.url = url;
    }
    public Gallery(LotDetail lotDetail, String url, Date deletionDate) {
       this.lotDetail = lotDetail;
       this.url = url;
       this.deletionDate = deletionDate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public LotDetail getLotDetail() {
        return this.lotDetail;
    }
    
    public void setLotDetail(LotDetail lotDetail) {
        this.lotDetail = lotDetail;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Date getDeletionDate() {
        return this.deletionDate;
    }
    
    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }




}


