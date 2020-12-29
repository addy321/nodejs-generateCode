
package entity;
// 系统日志表
public class Baseuserlog  extends BaseDomain{
    public Baseuserlog() {

    }
    
    //系统日志表
    private String Id;
        
    //系统日志表
    private Date CreateTime;
        
    //系统日志表
    private String CreatorId;
        
    //系统日志表
    private String CreatorRealName;
        
    //系统日志表
    private String LogType;
        
    //系统日志表
    private longtext LogContent;
        
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
            
    public String getCreatorrealname() {
        return Creatorrealname;
    }
    public void setCreatorrealname(String Creatorrealname) {
        this.Creatorrealname = Creatorrealname;
    }
            
    public String getLogtype() {
        return Logtype;
    }
    public void setLogtype(String Logtype) {
        this.Logtype = Logtype;
    }
            
    public longtext getLogcontent() {
        return Logcontent;
    }
    public void setLogcontent(longtext Logcontent) {
        this.Logcontent = Logcontent;
    }
             
    @Override
    public String toString() {
        return "Base_UserLog[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",CreatorRealName=" + CreatorRealName + ",LogType=" + LogType + ",LogContent=" + LogContent + "]";
    }
        
    
}
        