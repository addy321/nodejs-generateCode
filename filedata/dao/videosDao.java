
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Videos;

public class VideosDao extends daoTemplate implements pojoDao<Videos>{
    
    public VideosDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Videos data) throws Exception {
        String sql="insert into videos(Id,VideoName,VideoType,VideoCover,VideoPlayConnection,VideoPreviewConnection,VideoDownloadLink,VideoLikes,VideoWatchCount,VideoTag,VideoCompanyStyle,IsCharge,ChargeAmount,VideoTime,CreatTime,UpdateTime,Modifier,VideoTypeId,VideoTitle) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(19);
        
        values.add(object.getId());
        values.add(object.getVideoname());
        values.add(object.getVideotype());
        values.add(object.getVideocover());
        values.add(object.getVideoplayconnection());
        values.add(object.getVideopreviewconnection());
        values.add(object.getVideodownloadlink());
        values.add(object.getVideolikes());
        values.add(object.getVideowatchcount());
        values.add(object.getVideotag());
        values.add(object.getVideocompanystyle());
        values.add(object.getIscharge());
        values.add(object.getChargeamount());
        values.add(object.getVideotime());
        values.add(object.getCreattime());
        values.add(object.getUpdatetime());
        values.add(object.getModifier());
        values.add(object.getVideotypeid());
        values.add(object.getVideotitle());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(bigint(20) unsigned Id) throws Exception {
        String sql="delete from videos where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Videos data) throws Exception {
        StringBuffer sql=new StringBuffer("update videos set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getVideoname()!=null && !"".equals(data.getName())){
            sql.append("VideoName=?,");
            values.add(data.getVideoname());
        }
                
        if(data.getVideotype()!=null && !"".equals(data.getName())){
            sql.append("VideoType=?,");
            values.add(data.getVideotype());
        }
                
        if(data.getVideocover()!=null && !"".equals(data.getName())){
            sql.append("VideoCover=?,");
            values.add(data.getVideocover());
        }
                
        if(data.getVideoplayconnection()!=null && !"".equals(data.getName())){
            sql.append("VideoPlayConnection=?,");
            values.add(data.getVideoplayconnection());
        }
                
        if(data.getVideopreviewconnection()!=null && !"".equals(data.getName())){
            sql.append("VideoPreviewConnection=?,");
            values.add(data.getVideopreviewconnection());
        }
                
        if(data.getVideodownloadlink()!=null && !"".equals(data.getName())){
            sql.append("VideoDownloadLink=?,");
            values.add(data.getVideodownloadlink());
        }
                
        if(data.getVideolikes()!=null && !"".equals(data.getName())){
            sql.append("VideoLikes=?,");
            values.add(data.getVideolikes());
        }
                
        if(data.getVideowatchcount()!=null && !"".equals(data.getName())){
            sql.append("VideoWatchCount=?,");
            values.add(data.getVideowatchcount());
        }
                
        if(data.getVideotag()!=null && !"".equals(data.getName())){
            sql.append("VideoTag=?,");
            values.add(data.getVideotag());
        }
                
        if(data.getVideocompanystyle()!=null && !"".equals(data.getName())){
            sql.append("VideoCompanyStyle=?,");
            values.add(data.getVideocompanystyle());
        }
                
        if(data.getIscharge()!=null && !"".equals(data.getName())){
            sql.append("IsCharge=?,");
            values.add(data.getIscharge());
        }
                
        if(data.getChargeamount()!=null && !"".equals(data.getName())){
            sql.append("ChargeAmount=?,");
            values.add(data.getChargeamount());
        }
                
        if(data.getVideotime()!=null && !"".equals(data.getName())){
            sql.append("VideoTime=?,");
            values.add(data.getVideotime());
        }
                
        if(data.getCreattime()!=null && !"".equals(data.getName())){
            sql.append("CreatTime=?,");
            values.add(data.getCreattime());
        }
                
        if(data.getUpdatetime()!=null && !"".equals(data.getName())){
            sql.append("UpdateTime=?,");
            values.add(data.getUpdatetime());
        }
                
        if(data.getModifier()!=null && !"".equals(data.getName())){
            sql.append("Modifier=?,");
            values.add(data.getModifier());
        }
                
        if(data.getVideotypeid()!=null && !"".equals(data.getName())){
            sql.append("VideoTypeId=?,");
            values.add(data.getVideotypeid());
        }
                
        if(data.getVideotitle()!=null && !"".equals(data.getName())){
            sql.append("VideoTitle=?,");
            values.add(data.getVideotitle());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Videos> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,VideoName,VideoType,VideoCover,VideoPlayConnection,VideoPreviewConnection,VideoDownloadLink,VideoLikes,VideoWatchCount,VideoTag,VideoCompanyStyle,IsCharge,ChargeAmount,VideoTime,CreatTime,UpdateTime,Modifier,VideoTypeId,VideoTitle from videos";
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
        List<Videos> datas=new ArrayList<Videos>();
        while(rs.next()){
            Videos data=new Videos();
            
            data.setId(rs.getId("Id"));
            data.setVideoName(rs.getVideoname("VideoName"));
            data.setVideoType(rs.getVideotype("VideoType"));
            data.setVideoCover(rs.getVideocover("VideoCover"));
            data.setVideoPlayConnection(rs.getVideoplayconnection("VideoPlayConnection"));
            data.setVideoPreviewConnection(rs.getVideopreviewconnection("VideoPreviewConnection"));
            data.setVideoDownloadLink(rs.getVideodownloadlink("VideoDownloadLink"));
            data.setVideoLikes(rs.getVideolikes("VideoLikes"));
            data.setVideoWatchCount(rs.getVideowatchcount("VideoWatchCount"));
            data.setVideoTag(rs.getVideotag("VideoTag"));
            data.setVideoCompanyStyle(rs.getVideocompanystyle("VideoCompanyStyle"));
            data.setIsCharge(rs.getIscharge("IsCharge"));
            data.setChargeAmount(rs.getChargeamount("ChargeAmount"));
            data.setVideoTime(rs.getVideotime("VideoTime"));
            data.setCreatTime(rs.getCreattime("CreatTime"));
            data.setUpdateTime(rs.getUpdatetime("UpdateTime"));
            data.setModifier(rs.getModifier("Modifier"));
            data.setVideoTypeId(rs.getVideotypeid("VideoTypeId"));
            data.setVideoTitle(rs.getVideotitle("VideoTitle"));	
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
        String sql="select count(1) from videos";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            