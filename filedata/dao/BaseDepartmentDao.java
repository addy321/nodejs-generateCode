
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Basedepartment;

public class BasedepartmentDao extends daoTemplate implements pojoDao<Basedepartment>{
    
    public BasedepartmentDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Basedepartment data) throws Exception {
        String sql="insert into Base_Department(Id,CreateTime,CreatorId,Deleted,Name,ParentId) values(?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(6);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getDeleted());
        values.add(object.getName());
        values.add(object.getParentid());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_Department where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Basedepartment data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_Department set ");
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
                
        if(data.getName()!=null && !"".equals(data.getName())){
            sql.append("Name=?,");
            values.add(data.getName());
        }
                
        if(data.getParentid()!=null && !"".equals(data.getName())){
            sql.append("ParentId=?,");
            values.add(data.getParentid());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Basedepartment> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,Deleted,Name,ParentId from Base_Department";
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
        List<Basedepartment> datas=new ArrayList<Basedepartment>();
        while(rs.next()){
            Basedepartment data=new Basedepartment();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setDeleted(rs.getDeleted("Deleted"));
            data.setName(rs.getName("Name"));
            data.setParentId(rs.getParentid("ParentId"));	
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
        String sql="select count(1) from Base_Department";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            