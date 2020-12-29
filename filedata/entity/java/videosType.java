
package entity;
// 
public class Videostype  extends BaseDomain{
    public Videostype() {

    }
    
    //
    private String Id;
        
    //
    private String CompanyStyle;
        
    //
    private String TypeName;
        
    //
    private String TypeImg;
        
    //
    private int(10) Orders;
        
    //
    private bit(10) Status;
        
    //
    private String TypeTitle;
        
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
            
    public String getTypename() {
        return Typename;
    }
    public void setTypename(String Typename) {
        this.Typename = Typename;
    }
            
    public String getTypeimg() {
        return Typeimg;
    }
    public void setTypeimg(String Typeimg) {
        this.Typeimg = Typeimg;
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
            
    public String getTypetitle() {
        return Typetitle;
    }
    public void setTypetitle(String Typetitle) {
        this.Typetitle = Typetitle;
    }
            
    public Date getCreattime() {
        return Creattime;
    }
    public void setCreattime(Date Creattime) {
        this.Creattime = Creattime;
    }
             
    @Override
    public String toString() {
        return "videos_type[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",TypeName=" + TypeName + ",TypeImg=" + TypeImg + ",Orders=" + Orders + ",Status=" + Status + ",TypeTitle=" + TypeTitle + ",CreatTime=" + CreatTime + "]";
    }
        
    
}
        