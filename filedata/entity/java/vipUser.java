
package entity;
// 
public class Vipuser  extends BaseDomain{
    public Vipuser() {

    }
    
    //
    private String Id;
        
    //
    private String CompanyStyle;
        
    //
    private String UserName;
        
    //
    private String OtherName;
        
    //
    private String HeadImg;
        
    //
    private String UserPass;
        
    //
    private double Balance;
        
    //
    private bit(1) Status;
        
    //
    private bit(1) IsBindPhone;
        
    //
    private String TelePhone;
        
    //
    private String ParentId;
        
    //
    private String InviteCode;
        
    //
    private String AddIP;
        
    //
    private String AddIPStr;
        
    //
    private Date AddTime;
        
    //
    private String LoginIp;
        
    //
    private String LoginIPStr;
        
    //
    private Date LoginTime;
        
    //
    private bigint(64) LoginCount;
        
    //
    private String BankName;
        
    //
    private String BankAccount;
        
    //
    private String BandPass;
        
    //
    private bit(1) IsVip;
        
    //
    private int(10) VipType;
        
    //
    private String LoginKey;
        
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
            
    public String getOthername() {
        return Othername;
    }
    public void setOthername(String Othername) {
        this.Othername = Othername;
    }
            
    public String getHeadimg() {
        return Headimg;
    }
    public void setHeadimg(String Headimg) {
        this.Headimg = Headimg;
    }
            
    public String getUserpass() {
        return Userpass;
    }
    public void setUserpass(String Userpass) {
        this.Userpass = Userpass;
    }
            
    public double getBalance() {
        return Balance;
    }
    public void setBalance(double Balance) {
        this.Balance = Balance;
    }
            
    public bit(1) getStatus() {
        return Status;
    }
    public void setStatus(bit(1) Status) {
        this.Status = Status;
    }
            
    public bit(1) getIsbindphone() {
        return Isbindphone;
    }
    public void setIsbindphone(bit(1) Isbindphone) {
        this.Isbindphone = Isbindphone;
    }
            
    public String getTelephone() {
        return Telephone;
    }
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }
            
    public String getParentid() {
        return Parentid;
    }
    public void setParentid(String Parentid) {
        this.Parentid = Parentid;
    }
            
    public String getInvitecode() {
        return Invitecode;
    }
    public void setInvitecode(String Invitecode) {
        this.Invitecode = Invitecode;
    }
            
    public String getAddip() {
        return Addip;
    }
    public void setAddip(String Addip) {
        this.Addip = Addip;
    }
            
    public String getAddipstr() {
        return Addipstr;
    }
    public void setAddipstr(String Addipstr) {
        this.Addipstr = Addipstr;
    }
            
    public Date getAddtime() {
        return Addtime;
    }
    public void setAddtime(Date Addtime) {
        this.Addtime = Addtime;
    }
            
    public String getLoginip() {
        return Loginip;
    }
    public void setLoginip(String Loginip) {
        this.Loginip = Loginip;
    }
            
    public String getLoginipstr() {
        return Loginipstr;
    }
    public void setLoginipstr(String Loginipstr) {
        this.Loginipstr = Loginipstr;
    }
            
    public Date getLogintime() {
        return Logintime;
    }
    public void setLogintime(Date Logintime) {
        this.Logintime = Logintime;
    }
            
    public bigint(64) getLogincount() {
        return Logincount;
    }
    public void setLogincount(bigint(64) Logincount) {
        this.Logincount = Logincount;
    }
            
    public String getBankname() {
        return Bankname;
    }
    public void setBankname(String Bankname) {
        this.Bankname = Bankname;
    }
            
    public String getBankaccount() {
        return Bankaccount;
    }
    public void setBankaccount(String Bankaccount) {
        this.Bankaccount = Bankaccount;
    }
            
    public String getBandpass() {
        return Bandpass;
    }
    public void setBandpass(String Bandpass) {
        this.Bandpass = Bandpass;
    }
            
    public bit(1) getIsvip() {
        return Isvip;
    }
    public void setIsvip(bit(1) Isvip) {
        this.Isvip = Isvip;
    }
            
    public int(10) getViptype() {
        return Viptype;
    }
    public void setViptype(int(10) Viptype) {
        this.Viptype = Viptype;
    }
            
    public String getLoginkey() {
        return Loginkey;
    }
    public void setLoginkey(String Loginkey) {
        this.Loginkey = Loginkey;
    }
             
    @Override
    public String toString() {
        return "vip_user[Id=" + Id + ",CompanyStyle=" + CompanyStyle + ",UserName=" + UserName + ",OtherName=" + OtherName + ",HeadImg=" + HeadImg + ",UserPass=" + UserPass + ",Balance=" + Balance + ",Status=" + Status + ",IsBindPhone=" + IsBindPhone + ",TelePhone=" + TelePhone + ",ParentId=" + ParentId + ",InviteCode=" + InviteCode + ",AddIP=" + AddIP + ",AddIPStr=" + AddIPStr + ",AddTime=" + AddTime + ",LoginIp=" + LoginIp + ",LoginIPStr=" + LoginIPStr + ",LoginTime=" + LoginTime + ",LoginCount=" + LoginCount + ",BankName=" + BankName + ",BankAccount=" + BankAccount + ",BandPass=" + BandPass + ",IsVip=" + IsVip + ",VipType=" + VipType + ",LoginKey=" + LoginKey + "]";
    }
        
    
}
        