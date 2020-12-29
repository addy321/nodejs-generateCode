
package entity;
// 应用密钥表
public class Baseappsecret  extends BaseDomain{
    public Baseappsecret() {

    }
    
    //应用密钥表
    private String Id;
        
    //应用密钥表
    private Date CreateTime;
        
    //应用密钥表
    private String CreatorId;
        
    //应用密钥表
    private tinyint(4) Deleted;
        
    //应用密钥表
    private String AppId;
        
    //应用密钥表
    private String AppSecret;
        
    //应用密钥表
    private String AppName;
        
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
            
    public String getAppid() {
        return Appid;
    }
    public void setAppid(String Appid) {
        this.Appid = Appid;
    }
            
    public String getAppsecret() {
        return Appsecret;
    }
    public void setAppsecret(String Appsecret) {
        this.Appsecret = Appsecret;
    }
            
    public String getAppname() {
        return Appname;
    }
    public void setAppname(String Appname) {
        this.Appname = Appname;
    }
             
    @Override
    public String toString() {
        return "Base_AppSecret[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",AppId=" + AppId + ",AppSecret=" + AppSecret + ",AppName=" + AppName + "]";
    }
        
    
}
        