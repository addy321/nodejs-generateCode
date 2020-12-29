
package entity;
// 系统权限表
public class Baseaction  extends BaseDomain{
    public Baseaction() {

    }
    
    //系统权限表
    private String Id;
        
    //系统权限表
    private Date CreateTime;
        
    //系统权限表
    private String CreatorId;
        
    //系统权限表
    private tinyint(4) Deleted;
        
    //系统权限表
    private String ParentId;
        
    //系统权限表
    private int(11) Type;
        
    //系统权限表
    private String Name;
        
    //系统权限表
    private text Url;
        
    //系统权限表
    private String Value;
        
    //系统权限表
    private tinyint(4) NeedAction;
        
    //系统权限表
    private String Icon;
        
    //系统权限表
    private int(11) Sort;
        
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
            
    public String getParentid() {
        return Parentid;
    }
    public void setParentid(String Parentid) {
        this.Parentid = Parentid;
    }
            
    public int(11) getType() {
        return Type;
    }
    public void setType(int(11) Type) {
        this.Type = Type;
    }
            
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
            
    public text getUrl() {
        return Url;
    }
    public void setUrl(text Url) {
        this.Url = Url;
    }
            
    public String getValue() {
        return Value;
    }
    public void setValue(String Value) {
        this.Value = Value;
    }
            
    public tinyint(4) getNeedaction() {
        return Needaction;
    }
    public void setNeedaction(tinyint(4) Needaction) {
        this.Needaction = Needaction;
    }
            
    public String getIcon() {
        return Icon;
    }
    public void setIcon(String Icon) {
        this.Icon = Icon;
    }
            
    public int(11) getSort() {
        return Sort;
    }
    public void setSort(int(11) Sort) {
        this.Sort = Sort;
    }
             
    @Override
    public String toString() {
        return "Base_Action[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",ParentId=" + ParentId + ",Type=" + Type + ",Name=" + Name + ",Url=" + Url + ",Value=" + Value + ",NeedAction=" + NeedAction + ",Icon=" + Icon + ",Sort=" + Sort + "]";
    }
        
    
}
        