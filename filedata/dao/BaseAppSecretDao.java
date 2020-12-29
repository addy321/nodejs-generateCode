
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Baseappsecret;

public class BaseappsecretDao extends daoTemplate implements pojoDao<Baseappsecret>{
    
    public BaseappsecretDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Baseappsecret data) throws Exception {
        String sql="insert into Base_AppSecret(Id,CreateTime,CreatorId,Deleted,AppId,AppSecret,AppName) values(?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(7);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getDeleted());
        values.add(object.getAppid());
        values.add(object.getAppsecret());
        values.add(object.getAppname());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_AppSecret where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Baseappsecret data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_AppSecret set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCreatetime()!=null && !"".equals(data.getName())){
            sql.append("CreateTime=?,");
            values.add(data.getCreatetime());
        }
                
        if(data.getCreatorid()!=null && !"".equals(data.getName())){
            sql.append("CreatorId=?,");
            values.add(data.getCreatorid());
        }
                
        if(data.getDeleted()!=null && !"".equals(data.getName())){
            sql.append("Deleted=?,");
            values.add(data.getDeleted());
        }
                
        if(data.getAppid()!=null && !"".equals(data.getName())){
            sql.append("AppId=?,");
            values.add(data.getAppid());
        }
                
        if(data.getAppsecret()!=null && !"".equals(data.getName())){
            sql.append("AppSecret=?,");
            values.add(data.getAppsecret());
        }
                
        if(data.getAppname()!=null && !"".equals(data.getName())){
            sql.append("AppName=?,");
            values.add(data.getAppname());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Baseappsecret> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,Deleted,AppId,AppSecret,AppName from Base_AppSecret";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        if(page==null||page<0)
            page=0;
        if(pageSize!=null&&pageSize!=0){
            if(values==null)
                values=new ArrayList<Object>(2);
            sql=sql+" limit ?,?";
            values.add(page);
            values.add(pageSize);
        }
        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<Baseappsecret> datas=new ArrayList<Baseappsecret>();
        while(rs.next()){
            Baseappsecret data=new Baseappsecret();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setDeleted(rs.getDeleted("Deleted"));
            data.setAppId(rs.getAppid("AppId"));
            data.setAppSecret(rs.getAppsecret("AppSecret"));
            data.setAppName(rs.getAppname("AppName"));	
            datas.add(data);
        }
        return datas;
        }catch(Exception e){throw e;}
        finally{
            super.close(null, pre, rs);
        }
        
    }

    @Override
    public long count(String condition, List<Object> values) throws Exception {
        String sql="select count(1) from Base_AppSecret";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            