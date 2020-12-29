
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Videoplayconfig;

public class VideoplayconfigDao extends daoTemplate implements pojoDao<Videoplayconfig>{
    
    public VideoplayconfigDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Videoplayconfig data) throws Exception {
        String sql="insert into videoplay_config(Id,ShortPlayUrl,LongPlayUrl,AlbumPlayUrl,Status,IsPrivate,CompanyStyle) values(?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(7);
        
        values.add(object.getId());
        values.add(object.getShortplayurl());
        values.add(object.getLongplayurl());
        values.add(object.getAlbumplayurl());
        values.add(object.getStatus());
        values.add(object.getIsprivate());
        values.add(object.getCompanystyle());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from videoplay_config where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Videoplayconfig data) throws Exception {
        StringBuffer sql=new StringBuffer("update videoplay_config set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getShortplayurl()!=null && !"".equals(data.getName())){
            sql.append("ShortPlayUrl=?,");
            values.add(data.getShortplayurl());
        }
                
        if(data.getLongplayurl()!=null && !"".equals(data.getName())){
            sql.append("LongPlayUrl=?,");
            values.add(data.getLongplayurl());
        }
                
        if(data.getAlbumplayurl()!=null && !"".equals(data.getName())){
            sql.append("AlbumPlayUrl=?,");
            values.add(data.getAlbumplayurl());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getIsprivate()!=null && !"".equals(data.getName())){
            sql.append("IsPrivate=?,");
            values.add(data.getIsprivate());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Videoplayconfig> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,ShortPlayUrl,LongPlayUrl,AlbumPlayUrl,Status,IsPrivate,CompanyStyle from videoplay_config";
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
        List<Videoplayconfig> datas=new ArrayList<Videoplayconfig>();
        while(rs.next()){
            Videoplayconfig data=new Videoplayconfig();
            
            data.setId(rs.getId("Id"));
            data.setShortPlayUrl(rs.getShortplayurl("ShortPlayUrl"));
            data.setLongPlayUrl(rs.getLongplayurl("LongPlayUrl"));
            data.setAlbumPlayUrl(rs.getAlbumplayurl("AlbumPlayUrl"));
            data.setStatus(rs.getStatus("Status"));
            data.setIsPrivate(rs.getIsprivate("IsPrivate"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));	
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
        String sql="select count(1) from videoplay_config";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            