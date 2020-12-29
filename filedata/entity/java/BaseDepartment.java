
package entity;
// 部门表
public class Basedepartment  extends BaseDomain{
    public Basedepartment() {

    }
    
    //部门表
    private String Id;
        
    //部门表
    private Date CreateTime;
        
    //部门表
    private String CreatorId;
        
    //部门表
    private tinyint(4) Deleted;
        
    //部门表
    private String Name;
        
    //部门表
    private String ParentId;
        
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
            
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
            
    public String getParentid() {
        return Parentid;
    }
    public void setParentid(String Parentid) {
        this.Parentid = Parentid;
    }
             
    @Override
    public String toString() {
        return "Base_Department[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",Name=" + Name + ",ParentId=" + ParentId + "]";
    }
        
    
}
        