
package entity;
// 
public class Viprecord  extends BaseDomain{
    public Viprecord() {

    }
    
    //
    private String Id;
        
    //
    private String CompanyStyle;
        
    //
    private String UserName;
        
    //
    private bit(10) Status;
        
    //
    private Date CreatTime;
        
    //
    private Date StartTime;
        
    //
    private Date EndTime;
        
    //
    private int(10) OpenType;
        
    //
    private String Remark;
        
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
            
    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
            
    public bit(10) getStatus() {
        return Status;
    }
    public void setStatus(bit(10) Status) {
        this.Status = Status;
    }
            
    public Date getCreattime() {
        return Creattime;
    }
    public void setCreattime(Date Creattime) {
        this.Creattime = Creattime;
    }
            
    public Date getStarttime() {
        return Starttime;
    }
    public void setStarttime(Date Starttime) {
        this.Starttime = Starttime;
    }
            
    public Date getEndtime() {
        return Endtime;
    }
    public void setEndtime(Date Endtime) {
        this.Endtime = Endtime;
    }
            
    public int(10) getOpentype() {
        return Opentype;
    }
    public void setOpentype(int(10) Opentype) {
        this.Opentype = Opentype;
    }
            
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String Remark) {
        this.Remark = Remark;
    }
             
    @Override
    public String toString() {
        return "vip_record[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",UserName=" + UserName + ",Status=" + Status + ",CreatTime=" + CreatTime + ",StartTime=" + StartTime + ",EndTime=" + EndTime + ",OpenType=" + OpenType + ",Remark=" + Remark + "]";
    }
        
    
}
        