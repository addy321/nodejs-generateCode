
package entity;
// 
public class Videoplayconfig  extends BaseDomain{
    public Videoplayconfig() {

    }
    
    //
    private String Id;
        
    //
    private String ShortPlayUrl;
        
    //
    private String LongPlayUrl;
        
    //
    private String AlbumPlayUrl;
        
    //
    private bit(10) Status;
        
    //
    private bit(10) IsPrivate;
        
    //
    private String CompanyStyle;
        
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
            
    public String getShortplayurl() {
        return Shortplayurl;
    }
    public void setShortplayurl(String Shortplayurl) {
        this.Shortplayurl = Shortplayurl;
    }
            
    public String getLongplayurl() {
        return Longplayurl;
    }
    public void setLongplayurl(String Longplayurl) {
        this.Longplayurl = Longplayurl;
    }
            
    public String getAlbumplayurl() {
        return Albumplayurl;
    }
    public void setAlbumplayurl(String Albumplayurl) {
        this.Albumplayurl = Albumplayurl;
    }
            
    public bit(10) getStatus() {
        return Status;
    }
    public void setStatus(bit(10) Status) {
        this.Status = Status;
    }
            
    public bit(10) getIsprivate() {
        return Isprivate;
    }
    public void setIsprivate(bit(10) Isprivate) {
        this.Isprivate = Isprivate;
    }
            
    public String getCompanystyle() {
        return Companystyle;
    }
    public void setCompanystyle(String Companystyle) {
        this.Companystyle = Companystyle;
    }
             
    @Override
    public String toString() {
        return "videoplay_config[Id=" + Id + ",ShortPlayUrl=" + ShortPlayUrl + ",LongPlayUrl=" + LongPlayUrl + ",AlbumPlayUrl=" + AlbumPlayUrl + ",Status=" + Status + ",IsPrivate=" + IsPrivate + ",CompanyStyle=" + CompanyStyle + "]";
    }
        
    
}
        