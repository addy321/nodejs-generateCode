
package entity;
// 生成测试表
public class Basebuildtest  extends BaseDomain{
    public Basebuildtest() {

    }
    
    //生成测试表
    private String Id;
        
    //生成测试表
    private Date CreateTime;
        
    //生成测试表
    private String CreatorId;
        
    //生成测试表
    private tinyint(4) Deleted;
        
    //生成测试表
    private String Column1;
        
    //生成测试表
    private String Column2;
        
    //生成测试表
    private String Column3;
        
    //生成测试表
    private String Column4;
        
    //生成测试表
    private String Column5;
        
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
            
    public String getColumn1() {
        return Column1;
    }
    public void setColumn1(String Column1) {
        this.Column1 = Column1;
    }
            
    public String getColumn2() {
        return Column2;
    }
    public void setColumn2(String Column2) {
        this.Column2 = Column2;
    }
            
    public String getColumn3() {
        return Column3;
    }
    public void setColumn3(String Column3) {
        this.Column3 = Column3;
    }
            
    public String getColumn4() {
        return Column4;
    }
    public void setColumn4(String Column4) {
        this.Column4 = Column4;
    }
            
    public String getColumn5() {
        return Column5;
    }
    public void setColumn5(String Column5) {
        this.Column5 = Column5;
    }
             
    @Override
    public String toString() {
        return "Base_BuildTest[Id=" + Id + ",CreateTime=" + CreateTime + ",CreatorId=" + CreatorId + ",Deleted=" + Deleted + ",Column1=" + Column1 + ",Column2=" + Column2 + ",Column3=" + Column3 + ",Column4=" + Column4 + ",Column5=" + Column5 + "]";
    }
        
    
}
        