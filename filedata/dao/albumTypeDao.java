
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Albumtype;

public class AlbumtypeDao extends daoTemplate implements pojoDao<Albumtype>{
    
    public AlbumtypeDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Albumtype data) throws Exception {
        String sql="insert into album_type(Id,CompanyStyle,AlbumName,AlbumImg,Orders,Status,AlbumTitle,CreatTime) values(?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(8);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getAlbumname());
        values.add(object.getAlbumimg());
        values.add(object.getOrders());
        values.add(object.getStatus());
        values.add(object.getAlbumtitle());
        values.add(object.getCreattime());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from album_type where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Albumtype data) throws Exception {
        StringBuffer sql=new StringBuffer("update album_type set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getAlbumname()!=null && !"".equals(data.getName())){
            sql.append("AlbumName=?,");
            values.add(data.getAlbumname());
        }
                
        if(data.getAlbumimg()!=null && !"".equals(data.getName())){
            sql.append("AlbumImg=?,");
            values.add(data.getAlbumimg());
        }
                
        if(data.getOrders()!=null && !"".equals(data.getName())){
            sql.append("Orders=?,");
            values.add(data.getOrders());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getAlbumtitle()!=null && !"".equals(data.getName())){
            sql.append("AlbumTitle=?,");
            values.add(data.getAlbumtitle());
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
    public List<Albumtype> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,AlbumName,AlbumImg,Orders,Status,AlbumTitle,CreatTime from album_type";
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
        List<Albumtype> datas=new ArrayList<Albumtype>();
        while(rs.next()){
            Albumtype data=new Albumtype();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setAlbumName(rs.getAlbumname("AlbumName"));
            data.setAlbumImg(rs.getAlbumimg("AlbumImg"));
            data.setOrders(rs.getOrders("Orders"));
            data.setStatus(rs.getStatus("Status"));
            data.setAlbumTitle(rs.getAlbumtitle("AlbumTitle"));
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
        String sql="select count(1) from album_type";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            