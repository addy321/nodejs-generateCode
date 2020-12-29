
package entity;
// 
public class Albumtype  extends BaseDomain{
    public Albumtype() {

    }
    
    //
    private String Id;
        
    //
    private String CompanyStyle;
        
    //
    private String AlbumName;
        
    //
    private String AlbumImg;
        
    //
    private int(10) Orders;
        
    //
    private bit(10) Status;
        
    //
    private String AlbumTitle;
        
    //
    private Date CreatTime;
        
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
            
    public String getCompanystyle() {
        return Companystyle;
    }
    public void setCompanystyle(String Companystyle) {
        this.Companystyle = Companystyle;
    }
            
    public String getAlbumname() {
        return Albumname;
    }
    public void setAlbumname(String Albumname) {
        this.Albumname = Albumname;
    }
            
    public String getAlbumimg() {
        return Albumimg;
    }
    public void setAlbumimg(String Albumimg) {
        this.Albumimg = Albumimg;
    }
            
    public int(10) getOrders() {
        return Orders;
    }
    public void setOrders(int(10) Orders) {
        this.Orders = Orders;
    }
            
    public bit(10) getStatus() {
        return Status;
    }
    public void setStatus(bit(10) Status) {
        this.Status = Status;
    }
            
    public String getAlbumtitle() {
        return Albumtitle;
    }
    public void setAlbumtitle(String Albumtitle) {
        this.Albumtitle = Albumtitle;
    }
            
    public Date getCreattime() {
        return Creattime;
    }
    public void setCreattime(Date Creattime) {
        this.Creattime = Creattime;
    }
             
    @Override
    public String toString() {
        return "album_type[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",AlbumName=" + AlbumName + ",AlbumImg=" + AlbumImg + ",Orders=" + Orders + ",Status=" + Status + ",AlbumTitle=" + AlbumTitle + ",CreatTime=" + CreatTime + "]";
    }
        
    
}
        