
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Advertising;

public class AdvertisingDao extends daoTemplate implements pojoDao<Advertising>{
    
    public AdvertisingDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Advertising data) throws Exception {
        String sql="insert into advertising(Id,CompanyStyle,AdvertisingType,AdvertisingTitle,AdvertisingDetail,AdvertisingImg,JumpType,AdvertisingJumpUrl,UpdateTime,Status,Orders) values(?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(11);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getAdvertisingtype());
        values.add(object.getAdvertisingtitle());
        values.add(object.getAdvertisingdetail());
        values.add(object.getAdvertisingimg());
        values.add(object.getJumptype());
        values.add(object.getAdvertisingjumpurl());
        values.add(object.getUpdatetime());
        values.add(object.getStatus());
        values.add(object.getOrders());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(int(255) unsigned Id) throws Exception {
        String sql="delete from advertising where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Advertising data) throws Exception {
        StringBuffer sql=new StringBuffer("update advertising set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getAdvertisingtype()!=null && !"".equals(data.getName())){
            sql.append("AdvertisingType=?,");
            values.add(data.getAdvertisingtype());
        }
                
        if(data.getAdvertisingtitle()!=null && !"".equals(data.getName())){
            sql.append("AdvertisingTitle=?,");
            values.add(data.getAdvertisingtitle());
        }
                
        if(data.getAdvertisingdetail()!=null && !"".equals(data.getName())){
            sql.append("AdvertisingDetail=?,");
            values.add(data.getAdvertisingdetail());
        }
                
        if(data.getAdvertisingimg()!=null && !"".equals(data.getName())){
            sql.append("AdvertisingImg=?,");
            values.add(data.getAdvertisingimg());
        }
                
        if(data.getJumptype()!=null && !"".equals(data.getName())){
            sql.append("JumpType=?,");
            values.add(data.getJumptype());
        }
                
        if(data.getAdvertisingjumpurl()!=null && !"".equals(data.getName())){
            sql.append("AdvertisingJumpUrl=?,");
            values.add(data.getAdvertisingjumpurl());
        }
                
        if(data.getUpdatetime()!=null && !"".equals(data.getName())){
            sql.append("UpdateTime=?,");
            values.add(data.getUpdatetime());
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
    public List<Advertising> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,AdvertisingType,AdvertisingTitle,AdvertisingDetail,AdvertisingImg,JumpType,AdvertisingJumpUrl,UpdateTime,Status,Orders from advertising";
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
        List<Advertising> datas=new ArrayList<Advertising>();
        while(rs.next()){
            Advertising data=new Advertising();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setAdvertisingType(rs.getAdvertisingtype("AdvertisingType"));
            data.setAdvertisingTitle(rs.getAdvertisingtitle("AdvertisingTitle"));
            data.setAdvertisingDetail(rs.getAdvertisingdetail("AdvertisingDetail"));
            data.setAdvertisingImg(rs.getAdvertisingimg("AdvertisingImg"));
            data.setJumpType(rs.getJumptype("JumpType"));
            data.setAdvertisingJumpUrl(rs.getAdvertisingjumpurl("AdvertisingJumpUrl"));
            data.setUpdateTime(rs.getUpdatetime("UpdateTime"));
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
        String sql="select count(1) from advertising";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            