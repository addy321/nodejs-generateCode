
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Basedblink;

public class BasedblinkDao extends daoTemplate implements pojoDao<Basedblink>{
    
    public BasedblinkDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Basedblink data) throws Exception {
        String sql="insert into Base_DbLink(Id,CreateTime,CreatorId,Deleted,LinkName,ConnectionStr,DbType) values(?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(7);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getDeleted());
        values.add(object.getLinkname());
        values.add(object.getConnectionstr());
        values.add(object.getDbtype());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_DbLink where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Basedblink data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_DbLink set ");
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
                
        if(data.getLinkname()!=null && !"".equals(data.getName())){
            sql.append("LinkName=?,");
            values.add(data.getLinkname());
        }
                
        if(data.getConnectionstr()!=null && !"".equals(data.getName())){
            sql.append("ConnectionStr=?,");
            values.add(data.getConnectionstr());
        }
                
        if(data.getDbtype()!=null && !"".equals(data.getName())){
            sql.append("DbType=?,");
            values.add(data.getDbtype());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Basedblink> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,Deleted,LinkName,ConnectionStr,DbType from Base_DbLink";
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
        List<Basedblink> datas=new ArrayList<Basedblink>();
        while(rs.next()){
            Basedblink data=new Basedblink();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setDeleted(rs.getDeleted("Deleted"));
            data.setLinkName(rs.getLinkname("LinkName"));
            data.setConnectionStr(rs.getConnectionstr("ConnectionStr"));
            data.setDbType(rs.getDbtype("DbType"));	
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
        String sql="select count(1) from Base_DbLink";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            