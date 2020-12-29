
package entity;
// 
public class Notice  extends BaseDomain{
    public Notice() {

    }
    
    //
    private int(255) unsigned Id;
        
    //
    private String CompanyStyle;
        
    //
    private int(255) NoticeType;
        
    //
    private String NoticeTypeDetail;
        
    //
    private String NoticeJumpUrl;
        
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
            
    public int(255) getNoticetype() {
        return Noticetype;
    }
    public void setNoticetype(int(255) Noticetype) {
        this.Noticetype = Noticetype;
    }
            
    public String getNoticetypedetail() {
        return Noticetypedetail;
    }
    public void setNoticetypedetail(String Noticetypedetail) {
        this.Noticetypedetail = Noticetypedetail;
    }
            
    public String getNoticejumpurl() {
        return Noticejumpurl;
    }
    public void setNoticejumpurl(String Noticejumpurl) {
        this.Noticejumpurl = Noticejumpurl;
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
        return "notice[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",NoticeType=" + NoticeType + ",NoticeTypeDetail=" + NoticeTypeDetail + ",NoticeJumpUrl=" + NoticeJumpUrl + ",Status=" + Status + ",Orders=" + Orders + "]";
    }
        
    
}
        