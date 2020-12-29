
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Videostype;

public class VideostypeDao extends daoTemplate implements pojoDao<Videostype>{
    
    public VideostypeDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Videostype data) throws Exception {
        String sql="insert into videos_type(Id,CompanyStyle,TypeName,TypeImg,Orders,Status,TypeTitle,CreatTime) values(?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(8);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getTypename());
        values.add(object.getTypeimg());
        values.add(object.getOrders());
        values.add(object.getStatus());
        values.add(object.getTypetitle());
        values.add(object.getCreattime());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from videos_type where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Videostype data) throws Exception {
        StringBuffer sql=new StringBuffer("update videos_type set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getTypename()!=null && !"".equals(data.getName())){
            sql.append("TypeName=?,");
            values.add(data.getTypename());
        }
                
        if(data.getTypeimg()!=null && !"".equals(data.getName())){
            sql.append("TypeImg=?,");
            values.add(data.getTypeimg());
        }
                
        if(data.getOrders()!=null && !"".equals(data.getName())){
            sql.append("Orders=?,");
            values.add(data.getOrders());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getTypetitle()!=null && !"".equals(data.getName())){
            sql.append("TypeTitle=?,");
            values.add(data.getTypetitle());
        }
                
        if(data.getCreattime()!=null && !"".equals(data.getName())){
            sql.append("CreatTime=?,");
            values.add(data.getCreattime());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Videostype> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,TypeName,TypeImg,Orders,Status,TypeTitle,CreatTime from videos_type";
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
        List<Videostype> datas=new ArrayList<Videostype>();
        while(rs.next()){
            Videostype data=new Videostype();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setTypeName(rs.getTypename("TypeName"));
            data.setTypeImg(rs.getTypeimg("TypeImg"));
            data.setOrders(rs.getOrders("Orders"));
            data.setStatus(rs.getStatus("Status"));
            data.setTypeTitle(rs.getTypetitle("TypeTitle"));
            data.setCreatTime(rs.getCreattime("CreatTime"));	
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
        String sql="select count(1) from videos_type";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            