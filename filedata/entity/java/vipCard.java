
package entity;
// 
public class Vipcard  extends BaseDomain{
    public Vipcard() {

    }
    
    //
    private String Id;
        
    //
    private String CompanyStyle;
        
    //
    private String CardNumber;
        
    //
    private String CardPass;
        
    //
    private int(10) Bonus;
        
    //
    private bit(1) Status;
        
    //
    private Date CreatTime;
        
    //
    private Date UseTime;
        
    //
    private String UseCompanyStyle;
        
    //
    private String UseUserName;
        
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
            
    public String getCardnumber() {
        return Cardnumber;
    }
    public void setCardnumber(String Cardnumber) {
        this.Cardnumber = Cardnumber;
    }
            
    public String getCardpass() {
        return Cardpass;
    }
    public void setCardpass(String Cardpass) {
        this.Cardpass = Cardpass;
    }
            
    public int(10) getBonus() {
        return Bonus;
    }
    public void setBonus(int(10) Bonus) {
        this.Bonus = Bonus;
    }
            
    public bit(1) getStatus() {
        return Status;
    }
    public void setStatus(bit(1) Status) {
        this.Status = Status;
    }
            
    public Date getCreattime() {
        return Creattime;
    }
    public void setCreattime(Date Creattime) {
        this.Creattime = Creattime;
    }
            
    public Date getUsetime() {
        return Usetime;
    }
    public void setUsetime(Date Usetime) {
        this.Usetime = Usetime;
    }
            
    public String getUsecompanystyle() {
        return Usecompanystyle;
    }
    public void setUsecompanystyle(String Usecompanystyle) {
        this.Usecompanystyle = Usecompanystyle;
    }
            
    public String getUseusername() {
        return Useusername;
    }
    public void setUseusername(String Useusername) {
        this.Useusername = Useusername;
    }
             
    @Override
    public String toString() {
        return "vip_card[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",CardNumber=" + CardNumber + ",CardPass=" + CardPass + ",Bonus=" + Bonus + ",Status=" + Status + ",CreatTime=" + CreatTime + ",UseTime=" + UseTime + ",UseCompanyStyle=" + UseCompanyStyle + ",UseUserName=" + UseUserName + "]";
    }
        
    
}
        