
package entity;
// 
public class Advertising  extends BaseDomain{
    public Advertising() {

    }
    
    //
    private int(255) unsigned Id;
        
    //
    private String CompanyStyle;
        
    //
    private int(255) AdvertisingType;
        
    //
    private String AdvertisingTitle;
        
    //
    private String AdvertisingDetail;
        
    //
    private String AdvertisingImg;
        
    //
    private int(255) unsigned JumpType;
        
    //
    private String AdvertisingJumpUrl;
        
    //
    private Date UpdateTime;
        
    //
    private int(255) unsigned Status;
        
    //
    private int(255) unsigned Orders;
        
    public int(255) unsigned getId() {
        return Id;
    }
    public void setId(int(255) unsigned Id) {
        this.Id = Id;
    }
            
    public String getCompanystyle() {
        return Companystyle;
    }
    public void setCompanystyle(String Companystyle) {
        this.Companystyle = Companystyle;
    }
            
    public int(255) getAdvertisingtype() {
        return Advertisingtype;
    }
    public void setAdvertisingtype(int(255) Advertisingtype) {
        this.Advertisingtype = Advertisingtype;
    }
            
    public String getAdvertisingtitle() {
        return Advertisingtitle;
    }
    public void setAdvertisingtitle(String Advertisingtitle) {
        this.Advertisingtitle = Advertisingtitle;
    }
            
    public String getAdvertisingdetail() {
        return Advertisingdetail;
    }
    public void setAdvertisingdetail(String Advertisingdetail) {
        this.Advertisingdetail = Advertisingdetail;
    }
            
    public String getAdvertisingimg() {
        return Advertisingimg;
    }
    public void setAdvertisingimg(String Advertisingimg) {
        this.Advertisingimg = Advertisingimg;
    }
            
    public int(255) unsigned getJumptype() {
        return Jumptype;
    }
    public void setJumptype(int(255) unsigned Jumptype) {
        this.Jumptype = Jumptype;
    }
            
    public String getAdvertisingjumpurl() {
        return Advertisingjumpurl;
    }
    public void setAdvertisingjumpurl(String Advertisingjumpurl) {
        this.Advertisingjumpurl = Advertisingjumpurl;
    }
            
    public Date getUpdatetime() {
        return Updatetime;
    }
    public void setUpdatetime(Date Updatetime) {
        this.Updatetime = Updatetime;
    }
            
    public int(255) unsigned getStatus() {
        return Status;
    }
    public void setStatus(int(255) unsigned Status) {
        this.Status = Status;
    }
            
    public int(255) unsigned getOrders() {
        return Orders;
    }
    public void setOrders(int(255) unsigned Orders) {
        this.Orders = Orders;
    }
             
    @Override
    public String toString() {
        return "advertising[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",AdvertisingType=" + AdvertisingType + ",AdvertisingTitle=" + AdvertisingTitle + ",AdvertisingDetail=" + AdvertisingDetail + ",AdvertisingImg=" + AdvertisingImg + ",JumpType=" + JumpType + ",AdvertisingJumpUrl=" + AdvertisingJumpUrl + ",UpdateTime=" + UpdateTime + ",Status=" + Status + ",Orders=" + Orders + "]";
    }
        
    
}
        