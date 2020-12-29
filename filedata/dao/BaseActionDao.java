
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Baseaction;

public class BaseactionDao extends daoTemplate implements pojoDao<Baseaction>{
    
    public BaseactionDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Baseaction data) throws Exception {
        String sql="insert into Base_Action(Id,CreateTime,CreatorId,Deleted,ParentId,Type,Name,Url,Value,NeedAction,Icon,Sort) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(12);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getDeleted());
        values.add(object.getParentid());
        values.add(object.getType());
        values.add(object.getName());
        values.add(object.getUrl());
        values.add(object.getValue());
        values.add(object.getNeedaction());
        values.add(object.getIcon());
        values.add(object.getSort());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_Action where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Baseaction data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_Action set ");
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
                
        if(data.getParentid()!=null && !"".equals(data.getName())){
            sql.append("ParentId=?,");
            values.add(data.getParentid());
        }
                
        if(data.getType()!=null && !"".equals(data.getName())){
            sql.append("Type=?,");
            values.add(data.getType());
        }
                
        if(data.getName()!=null && !"".equals(data.getName())){
            sql.append("Name=?,");
            values.add(data.getName());
        }
                
        if(data.getUrl()!=null && !"".equals(data.getName())){
            sql.append("Url=?,");
            values.add(data.getUrl());
        }
                
        if(data.getValue()!=null && !"".equals(data.getName())){
            sql.append("Value=?,");
            values.add(data.getValue());
        }
                
        if(data.getNeedaction()!=null && !"".equals(data.getName())){
            sql.append("NeedAction=?,");
            values.add(data.getNeedaction());
        }
                
        if(data.getIcon()!=null && !"".equals(data.getName())){
            sql.append("Icon=?,");
            values.add(data.getIcon());
        }
                
        if(data.getSort()!=null && !"".equals(data.getName())){
            sql.append("Sort=?,");
            values.add(data.getSort());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Baseaction> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,Deleted,ParentId,Type,Name,Url,Value,NeedAction,Icon,Sort from Base_Action";
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
        List<Baseaction> datas=new ArrayList<Baseaction>();
        while(rs.next()){
            Baseaction data=new Baseaction();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setDeleted(rs.getDeleted("Deleted"));
            data.setParentId(rs.getParentid("ParentId"));
            data.setType(rs.getType("Type"));
            data.setName(rs.getName("Name"));
            data.setUrl(rs.getUrl("Url"));
            data.setValue(rs.getValue("Value"));
            data.setNeedAction(rs.getNeedaction("NeedAction"));
            data.setIcon(rs.getIcon("Icon"));
            data.setSort(rs.getSort("Sort"));	
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
        String sql="select count(1) from Base_Action";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            