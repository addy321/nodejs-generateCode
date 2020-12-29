
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Videocollection;

public class VideocollectionDao extends daoTemplate implements pojoDao<Videocollection>{
    
    public VideocollectionDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Videocollection data) throws Exception {
        String sql="insert into video_collection(id,video_name,video_poster,video_preview,video_score,video_type_name,video_country,video_time,video_domain,domain_name,is_down_finsh,id,video_name,video_poster,video_preview,video_score,video_type_name,video_country,video_time,video_domain,domain_name,is_down_finsh) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(22);
        
        values.add(object.getId());
        values.add(object.getVideo_name());
        values.add(object.getVideo_poster());
        values.add(object.getVideo_preview());
        values.add(object.getVideo_score());
        values.add(object.getVideo_type_name());
        values.add(object.getVideo_country());
        values.add(object.getVideo_time());
        values.add(object.getVideo_domain());
        values.add(object.getDomain_name());
        values.add(object.getIs_down_finsh());
        values.add(object.getId());
        values.add(object.getVideo_name());
        values.add(object.getVideo_poster());
        values.add(object.getVideo_preview());
        values.add(object.getVideo_score());
        values.add(object.getVideo_type_name());
        values.add(object.getVideo_country());
        values.add(object.getVideo_time());
        values.add(object.getVideo_domain());
        values.add(object.getDomain_name());
        values.add(object.getIs_down_finsh());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(bigint(18) id) throws Exception {
        String sql="delete from video_collection where id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Videocollection data) throws Exception {
        StringBuffer sql=new StringBuffer("update video_collection set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("id=?,");
            values.add(data.getId());
        }
                
        if(data.getVideo_name()!=null && !"".equals(data.getName())){
            sql.append("video_name=?,");
            values.add(data.getVideo_name());
        }
                
        if(data.getVideo_poster()!=null && !"".equals(data.getName())){
            sql.append("video_poster=?,");
            values.add(data.getVideo_poster());
        }
                
        if(data.getVideo_preview()!=null && !"".equals(data.getName())){
            sql.append("video_preview=?,");
            values.add(data.getVideo_preview());
        }
                
        if(data.getVideo_score()!=null && !"".equals(data.getName())){
            sql.append("video_score=?,");
            values.add(data.getVideo_score());
        }
                
        if(data.getVideo_type_name()!=null && !"".equals(data.getName())){
            sql.append("video_type_name=?,");
            values.add(data.getVideo_type_name());
        }
                
        if(data.getVideo_country()!=null && !"".equals(data.getName())){
            sql.append("video_country=?,");
            values.add(data.getVideo_country());
        }
                
        if(data.getVideo_time()!=null && !"".equals(data.getName())){
            sql.append("video_time=?,");
            values.add(data.getVideo_time());
        }
                
        if(data.getVideo_domain()!=null && !"".equals(data.getName())){
            sql.append("video_domain=?,");
            values.add(data.getVideo_domain());
        }
                
        if(data.getDomain_name()!=null && !"".equals(data.getName())){
            sql.append("domain_name=?,");
            values.add(data.getDomain_name());
        }
                
        if(data.getIs_down_finsh()!=null && !"".equals(data.getName())){
            sql.append("is_down_finsh=?,");
            values.add(data.getIs_down_finsh());
        }
                
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("id=?,");
            values.add(data.getId());
        }
                
        if(data.getVideo_name()!=null && !"".equals(data.getName())){
            sql.append("video_name=?,");
            values.add(data.getVideo_name());
        }
                
        if(data.getVideo_poster()!=null && !"".equals(data.getName())){
            sql.append("video_poster=?,");
            values.add(data.getVideo_poster());
        }
                
        if(data.getVideo_preview()!=null && !"".equals(data.getName())){
            sql.append("video_preview=?,");
            values.add(data.getVideo_preview());
        }
                
        if(data.getVideo_score()!=null && !"".equals(data.getName())){
            sql.append("video_score=?,");
            values.add(data.getVideo_score());
        }
                
        if(data.getVideo_type_name()!=null && !"".equals(data.getName())){
            sql.append("video_type_name=?,");
            values.add(data.getVideo_type_name());
        }
                
        if(data.getVideo_country()!=null && !"".equals(data.getName())){
            sql.append("video_country=?,");
            values.add(data.getVideo_country());
        }
                
        if(data.getVideo_time()!=null && !"".equals(data.getName())){
            sql.append("video_time=?,");
            values.add(data.getVideo_time());
        }
                
        if(data.getVideo_domain()!=null && !"".equals(data.getName())){
            sql.append("video_domain=?,");
            values.add(data.getVideo_domain());
        }
                
        if(data.getDomain_name()!=null && !"".equals(data.getName())){
            sql.append("domain_name=?,");
            values.add(data.getDomain_name());
        }
                
        if(data.getIs_down_finsh()!=null && !"".equals(data.getName())){
            sql.append("is_down_finsh=?,");
            values.add(data.getIs_down_finsh());
        }
                
        
        
        sql.append(" where id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Videocollection> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select id,video_name,video_poster,video_preview,video_score,video_type_name,video_country,video_time,video_domain,domain_name,is_down_finsh,id,video_name,video_poster,video_preview,video_score,video_type_name,video_country,video_time,video_domain,domain_name,is_down_finsh from video_collection";
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
        List<Videocollection> datas=new ArrayList<Videocollection>();
        while(rs.next()){
            Videocollection data=new Videocollection();
            
            data.setid(rs.getId("id"));
            data.setvideo_name(rs.getVideo_name("video_name"));
            data.setvideo_poster(rs.getVideo_poster("video_poster"));
            data.setvideo_preview(rs.getVideo_preview("video_preview"));
            data.setvideo_score(rs.getVideo_score("video_score"));
            data.setvideo_type_name(rs.getVideo_type_name("video_type_name"));
            data.setvideo_country(rs.getVideo_country("video_country"));
            data.setvideo_time(rs.getVideo_time("video_time"));
            data.setvideo_domain(rs.getVideo_domain("video_domain"));
            data.setdomain_name(rs.getDomain_name("domain_name"));
            data.setis_down_finsh(rs.getIs_down_finsh("is_down_finsh"));
            data.setid(rs.getId("id"));
            data.setvideo_name(rs.getVideo_name("video_name"));
            data.setvideo_poster(rs.getVideo_poster("video_poster"));
            data.setvideo_preview(rs.getVideo_preview("video_preview"));
            data.setvideo_score(rs.getVideo_score("video_score"));
            data.setvideo_type_name(rs.getVideo_type_name("video_type_name"));
            data.setvideo_country(rs.getVideo_country("video_country"));
            data.setvideo_time(rs.getVideo_time("video_time"));
            data.setvideo_domain(rs.getVideo_domain("video_domain"));
            data.setdomain_name(rs.getDomain_name("domain_name"));
            data.setis_down_finsh(rs.getIs_down_finsh("is_down_finsh"));	
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
        String sql="select count(1) from video_collection";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            