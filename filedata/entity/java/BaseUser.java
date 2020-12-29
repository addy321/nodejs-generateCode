
package entity;
// 系统用户表
public class Baseuser  extends BaseDomain{
    public Baseuser() {

    }
    
    //系统用户表
    private String Id;
        
    //系统用户表
    private Date CreateTime;
        
    //系统用户表
    private String CreatorId;
        
    //系统用户表
    private tinyint(4) Deleted;
        
    //系统用户表
    private String UserName;
        
    //系统用户表
    private String Password;
        
    //系统用户表
    private String RealName;
        
    //系统用户表
    private int(11) Sex;
        
    //系统用户表
    private date Birthday;
        
    //系统用户表
    private String DepartmentId;
        
    public String getId() {
        return Id;
    }
    public void setId(String Id) {
        this.Id = Id;
    }
            
    public Date getCreatetime() {
        return Createtime;
    }
    public void setCreatetime(Date Createtime) {
        this.Createtime = Createtime;
    }
            
    public String getCreatorid() {
        return Creatorid;
    }
    public void setCreatorid(String Creatorid) {
        this.Creatorid = Creatorid;
    }
            
    public tinyint(4) getDeleted() {
        return Deleted;
    }
    public void setDeleted(tinyint(4) Deleted) {
        this.Deleted = Deleted;
    }
            
    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
            
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
            
    public String getRealname() {
        return Realname;
    }
    public void setRealname(String Realname) {
        this.Realname = Realname;
    }
            
    public int(11) getSex() {
        return Sex;
    }
    public void setSex(int(11) Sex) {
        this.Sex = Sex;
    }
            
    public date getBirthday() {
        return Birthday;
    }
    public void setBirthday(date Birthday) {
        this.Birthday = Birthday;
    }
            
    public String getDepartmentid() {
        return Departmentid;
    }
    public void setDepartmentid(String Departmentid) {
        this.Departmentid = Departmentid;
    }
             
    @Override
    public String toString() {
        return "Base_User[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",UserName=" + UserName + ",Password=" + Password + ",RealName=" + RealName + ",Sex=" + Sex + ",Birthday=" + Birthday + ",DepartmentId=" + DepartmentId + "]";
    }
        
    
}
        