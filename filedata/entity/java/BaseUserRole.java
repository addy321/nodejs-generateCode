
package entity;
// 用户角色表
public class Baseuserrole  extends BaseDomain{
    public Baseuserrole() {

    }
    
    //用户角色表
    private String Id;
        
    //用户角色表
    private Date CreateTime;
        
    //用户角色表
    private String CreatorId;
        
    //用户角色表
    private tinyint(4) Deleted;
        
    //用户角色表
    private String UserId;
        
    //用户角色表
    private String RoleId;
        
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
            
    public String getUserid() {
        return Userid;
    }
    public void setUserid(String Userid) {
        this.Userid = Userid;
    }
            
    public String getRoleid() {
        return Roleid;
    }
    public void setRoleid(String Roleid) {
        this.Roleid = Roleid;
    }
             
    @Override
    public String toString() {
        return "Base_UserRole[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",UserId=" + UserId + ",RoleId=" + RoleId + "]";
    }
        
    
}
        