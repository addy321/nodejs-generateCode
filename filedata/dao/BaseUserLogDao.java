
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Baseuserlog;

public class BaseuserlogDao extends daoTemplate implements pojoDao<Baseuserlog>{
    
    public BaseuserlogDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Baseuserlog data) throws Exception {
        String sql="insert into Base_UserLog(Id,CreateTime,CreatorId,CreatorRealName,LogType,LogContent) values(?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(6);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getCreatorrealname());
        values.add(object.getLogtype());
        values.add(object.getLogcontent());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_UserLog where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Baseuserlog data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_UserLog set ");
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
                
        if(data.getCreatorrealname()!=null && !"".equals(data.getName())){
            sql.append("CreatorRealName=?,");
            values.add(data.getCreatorrealname());
        }
                
        if(data.getLogtype()!=null && !"".equals(data.getName())){
            sql.append("LogType=?,");
            values.add(data.getLogtype());
        }
                
        if(data.getLogcontent()!=null && !"".equals(data.getName())){
            sql.append("LogContent=?,");
            values.add(data.getLogcontent());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Baseuserlog> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,CreatorRealName,LogType,LogContent from Base_UserLog";
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
        List<Baseuserlog> datas=new ArrayList<Baseuserlog>();
        while(rs.next()){
            Baseuserlog data=new Baseuserlog();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setCreatorRealName(rs.getCreatorrealname("CreatorRealName"));
            data.setLogType(rs.getLogtype("LogType"));
            data.setLogContent(rs.getLogcontent("LogContent"));	
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
        String sql="select count(1) from Base_UserLog";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            