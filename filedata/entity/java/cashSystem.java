
package entity;
// 
public class Cashsystem  extends BaseDomain{
    public Cashsystem() {

    }
    
    //
    private String Id;
        
    //
    private String Oid;
        
    //
    private String CompanyStyle;
        
    //
    private String UserName;
        
    //
    private Date EnrolmentTime;
        
    //
    private Date ProcessingTime;
        
    //
    private double ActionMoney;
        
    //
    private double SpMoney;
        
    //
    private double NewBalance;
        
    //
    private int(255) ActionType;
        
    //
    private String ActionRemark;
        
    //
    private String Description;
        
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
            
    public String getOid() {
        return Oid;
    }
    public void setOid(String Oid) {
        this.Oid = Oid;
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
            
    public Date getEnrolmenttime() {
        return Enrolmenttime;
    }
    public void setEnrolmenttime(Date Enrolmenttime) {
        this.Enrolmenttime = Enrolmenttime;
    }
            
    public Date getProcessingtime() {
        return Processingtime;
    }
    public void setProcessingtime(Date Processingtime) {
        this.Processingtime = Processingtime;
    }
            
    public double getActionmoney() {
        return Actionmoney;
    }
    public void setActionmoney(double Actionmoney) {
        this.Actionmoney = Actionmoney;
    }
            
    public double getSpmoney() {
        return Spmoney;
    }
    public void setSpmoney(double Spmoney) {
        this.Spmoney = Spmoney;
    }
            
    public double getNewbalance() {
        return Newbalance;
    }
    public void setNewbalance(double Newbalance) {
        this.Newbalance = Newbalance;
    }
            
    public int(255) getActiontype() {
        return Actiontype;
    }
    public void setActiontype(int(255) Actiontype) {
        this.Actiontype = Actiontype;
    }
            
    public String getActionremark() {
        return Actionremark;
    }
    public void setActionremark(String Actionremark) {
        this.Actionremark = Actionremark;
    }
            
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
             
    @Override
    public String toString() {
        return "cash_system[Id=" + Id + ",Oid=" + Oid + ",CompanyStyle=" + CompanyStyle + ",UserName=" + UserName + ",EnrolmentTime=" + EnrolmentTime + ",ProcessingTime=" + ProcessingTime + ",ActionMoney=" + ActionMoney + ",SpMoney=" + SpMoney + ",NewBalance=" + NewBalance + ",ActionType=" + ActionType + ",ActionRemark=" + ActionRemark + ",Description=" + Description + "]";
    }
        
    
}
        