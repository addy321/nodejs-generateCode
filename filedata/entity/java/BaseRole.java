
package entity;
// 系统角色表
public class Baserole  extends BaseDomain{
    public Baserole() {

    }
    
    //系统角色表
    private String Id;
        
    //系统角色表
    private Date CreateTime;
        
    //系统角色表
    private String CreatorId;
        
    //系统角色表
    private tinyint(4) Deleted;
        
    //系统角色表
    private String RoleName;
        
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
            
    public String getRolename() {
        return Rolename;
    }
    public void setRolename(String Rolename) {
        this.Rolename = Rolename;
    }
             
    @Override
    public String toString() {
        return "Base_Role[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",RoleName=" + RoleName + "]";
    }
        
    
}
        