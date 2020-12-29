
package entity;
// 数据库连接表
public class Basedblink  extends BaseDomain{
    public Basedblink() {

    }
    
    //数据库连接表
    private String Id;
        
    //数据库连接表
    private Date CreateTime;
        
    //数据库连接表
    private String CreatorId;
        
    //数据库连接表
    private tinyint(4) Deleted;
        
    //数据库连接表
    private String LinkName;
        
    //数据库连接表
    private text ConnectionStr;
        
    //数据库连接表
    private String DbType;
        
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
            
    public String getLinkname() {
        return Linkname;
    }
    public void setLinkname(String Linkname) {
        this.Linkname = Linkname;
    }
            
    public text getConnectionstr() {
        return Connectionstr;
    }
    public void setConnectionstr(text Connectionstr) {
        this.Connectionstr = Connectionstr;
    }
            
    public String getDbtype() {
        return Dbtype;
    }
    public void setDbtype(String Dbtype) {
        this.Dbtype = Dbtype;
    }
             
    @Override
    public String toString() {
        return "Base_DbLink[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",LinkName=" + LinkName + ",ConnectionStr=" + ConnectionStr + ",DbType=" + DbType + "]";
    }
        
    
}
        