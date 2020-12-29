
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Viprecord;

public class ViprecordDao extends daoTemplate implements pojoDao<Viprecord>{
    
    public ViprecordDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Viprecord data) throws Exception {
        String sql="insert into vip_record(Id,CompanyStyle,UserName,Status,CreatTime,StartTime,EndTime,OpenType,Remark) values(?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(9);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getUsername());
        values.add(object.getStatus());
        values.add(object.getCreattime());
        values.add(object.getStarttime());
        values.add(object.getEndtime());
        values.add(object.getOpentype());
        values.add(object.getRemark());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from vip_record where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Viprecord data) throws Exception {
        StringBuffer sql=new StringBuffer("update vip_record set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getUsername()!=null && !"".equals(data.getName())){
            sql.append("UserName=?,");
            values.add(data.getUsername());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getCreattime()!=null && !"".equals(data.getName())){
            sql.append("CreatTime=?,");
            values.add(data.getCreattime());
        }
                
        if(data.getStarttime()!=null && !"".equals(data.getName())){
            sql.append("StartTime=?,");
            values.add(data.getStarttime());
        }
                
        if(data.getEndtime()!=null && !"".equals(data.getName())){
            sql.append("EndTime=?,");
            values.add(data.getEndtime());
        }
                
        if(data.getOpentype()!=null && !"".equals(data.getName())){
            sql.append("OpenType=?,");
            values.add(data.getOpentype());
        }
                
        if(data.getRemark()!=null && !"".equals(data.getName())){
            sql.append("Remark=?,");
            values.add(data.getRemark());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Viprecord> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,UserName,Status,CreatTime,StartTime,EndTime,OpenType,Remark from vip_record";
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
        List<Viprecord> datas=new ArrayList<Viprecord>();
        while(rs.next()){
            Viprecord data=new Viprecord();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setUserName(rs.getUsername("UserName"));
            data.setStatus(rs.getStatus("Status"));
            data.setCreatTime(rs.getCreattime("CreatTime"));
            data.setStartTime(rs.getStarttime("StartTime"));
            data.setEndTime(rs.getEndtime("EndTime"));
            data.setOpenType(rs.getOpentype("OpenType"));
            data.setRemark(rs.getRemark("Remark"));	
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
        String sql="select count(1) from vip_record";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            