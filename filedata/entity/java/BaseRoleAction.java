
package entity;
// 角色权限表
public class Baseroleaction  extends BaseDomain{
    public Baseroleaction() {

    }
    
    //角色权限表
    private String Id;
        
    //角色权限表
    private Date CreateTime;
        
    //角色权限表
    private String CreatorId;
        
    //角色权限表
    private tinyint(4) Deleted;
        
    //角色权限表
    private String RoleId;
        
    //角色权限表
    private String ActionId;
        
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
            
    public String getRoleid() {
        return Roleid;
    }
    public void setRoleid(String Roleid) {
        this.Roleid = Roleid;
    }
            
    public String getActionid() {
        return Actionid;
    }
    public void setActionid(String Actionid) {
        this.Actionid = Actionid;
    }
             
    @Override
    public String toString() {
        return "Base_RoleAction[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",RoleId=" + RoleId + ",ActionId=" + ActionId + "]";
    }
        
    
}
        