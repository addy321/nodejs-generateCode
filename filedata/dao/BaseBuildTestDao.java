
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Basebuildtest;

public class BasebuildtestDao extends daoTemplate implements pojoDao<Basebuildtest>{
    
    public BasebuildtestDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Basebuildtest data) throws Exception {
        String sql="insert into Base_BuildTest(Id,CreateTime,CreatorId,Deleted,Column1,Column2,Column3,Column4,Column5) values(?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(9);
        
        values.add(object.getId());
        values.add(object.getCreatetime());
        values.add(object.getCreatorid());
        values.add(object.getDeleted());
        values.add(object.getColumn1());
        values.add(object.getColumn2());
        values.add(object.getColumn3());
        values.add(object.getColumn4());
        values.add(object.getColumn5());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from Base_BuildTest where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Basebuildtest data) throws Exception {
        StringBuffer sql=new StringBuffer("update Base_BuildTest set ");
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
                
        if(data.getColumn1()!=null && !"".equals(data.getName())){
            sql.append("Column1=?,");
            values.add(data.getColumn1());
        }
                
        if(data.getColumn2()!=null && !"".equals(data.getName())){
            sql.append("Column2=?,");
            values.add(data.getColumn2());
        }
                
        if(data.getColumn3()!=null && !"".equals(data.getName())){
            sql.append("Column3=?,");
            values.add(data.getColumn3());
        }
                
        if(data.getColumn4()!=null && !"".equals(data.getName())){
            sql.append("Column4=?,");
            values.add(data.getColumn4());
        }
                
        if(data.getColumn5()!=null && !"".equals(data.getName())){
            sql.append("Column5=?,");
            values.add(data.getColumn5());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Basebuildtest> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CreateTime,CreatorId,Deleted,Column1,Column2,Column3,Column4,Column5 from Base_BuildTest";
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
        List<Basebuildtest> datas=new ArrayList<Basebuildtest>();
        while(rs.next()){
            Basebuildtest data=new Basebuildtest();
            
            data.setId(rs.getId("Id"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));
            data.setCreatorId(rs.getCreatorid("CreatorId"));
            data.setDeleted(rs.getDeleted("Deleted"));
            data.setColumn1(rs.getColumn1("Column1"));
            data.setColumn2(rs.getColumn2("Column2"));
            data.setColumn3(rs.getColumn3("Column3"));
            data.setColumn4(rs.getColumn4("Column4"));
            data.setColumn5(rs.getColumn5("Column5"));	
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
        String sql="select count(1) from Base_BuildTest";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            