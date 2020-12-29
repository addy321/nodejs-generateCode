
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Baseuser;

public class BaseuserDao extends daoTemplate implements pojoDao<Baseuser>{
    
    public BaseuserDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Baseuser data) throws Exception {
        String sql="insert into Base_User(Id,CreateTime,CreatorId,Deleted,UserName,Password,RealName,Sex,Birthday,DepartmentId) values(?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(10);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getDeleted());
        values.add(object.getUsername());
        values.add(object.getPassword());
        values.add(object.getRealname());
        values.add(object.getSex());
        values.add(object.getBirthday());
        values.add(object.getDepartmentid());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_User where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Baseuser data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_User set ");
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
                
        if(data.getUsername()!=null && !"".equals(data.getName())){
            sql.append("UserName=?,");
            values.add(data.getUsername());
        }
                
        if(data.getPassword()!=null && !"".equals(data.getName())){
            sql.append("Password=?,");
            values.add(data.getPassword());
        }
                
        if(data.getRealname()!=null && !"".equals(data.getName())){
            sql.append("RealName=?,");
            values.add(data.getRealname());
        }
                
        if(data.getSex()!=null && !"".equals(data.getName())){
            sql.append("Sex=?,");
            values.add(data.getSex());
        }
                
        if(data.getBirthday()!=null && !"".equals(data.getName())){
            sql.append("Birthday=?,");
            values.add(data.getBirthday());
        }
                
        if(data.getDepartmentid()!=null && !"".equals(data.getName())){
            sql.append("DepartmentId=?,");
            values.add(data.getDepartmentid());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Baseuser> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,Deleted,UserName,Password,RealName,Sex,Birthday,DepartmentId from Base_User";
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
        List<Baseuser> datas=new ArrayList<Baseuser>();
        while(rs.next()){
            Baseuser data=new Baseuser();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setDeleted(rs.getDeleted("Deleted"));
            data.setUserName(rs.getUsername("UserName"));
            data.setPassword(rs.getPassword("Password"));
            data.setRealName(rs.getRealname("RealName"));
            data.setSex(rs.getSex("Sex"));
            data.setBirthday(rs.getBirthday("Birthday"));
            data.setDepartmentId(rs.getDepartmentid("DepartmentId"));	
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
        String sql="select count(1) from Base_User";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            