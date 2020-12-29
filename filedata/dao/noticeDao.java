
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Notice;

public class NoticeDao extends daoTemplate implements pojoDao<Notice>{
    
    public NoticeDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Notice data) throws Exception {
        String sql="insert into notice(Id,CompanyStyle,NoticeType,NoticeTypeDetail,NoticeJumpUrl,Status,Orders) values(?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(7);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getNoticetype());
        values.add(object.getNoticetypedetail());
        values.add(object.getNoticejumpurl());
        values.add(object.getStatus());
        values.add(object.getOrders());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(int(255) unsigned Id) throws Exception {
        String sql="delete from notice where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Notice data) throws Exception {
        StringBuffer sql=new StringBuffer("update notice set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getNoticetype()!=null && !"".equals(data.getName())){
            sql.append("NoticeType=?,");
            values.add(data.getNoticetype());
        }
                
        if(data.getNoticetypedetail()!=null && !"".equals(data.getName())){
            sql.append("NoticeTypeDetail=?,");
            values.add(data.getNoticetypedetail());
        }
                
        if(data.getNoticejumpurl()!=null && !"".equals(data.getName())){
            sql.append("NoticeJumpUrl=?,");
            values.add(data.getNoticejumpurl());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getOrders()!=null && !"".equals(data.getName())){
            sql.append("Orders=?,");
            values.add(data.getOrders());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Notice> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,NoticeType,NoticeTypeDetail,NoticeJumpUrl,Status,Orders from notice";
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
        List<Notice> datas=new ArrayList<Notice>();
        while(rs.next()){
            Notice data=new Notice();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setNoticeType(rs.getNoticetype("NoticeType"));
            data.setNoticeTypeDetail(rs.getNoticetypedetail("NoticeTypeDetail"));
            data.setNoticeJumpUrl(rs.getNoticejumpurl("NoticeJumpUrl"));
            data.setStatus(rs.getStatus("Status"));
            data.setOrders(rs.getOrders("Orders"));	
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
        String sql="select count(1) from notice";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            