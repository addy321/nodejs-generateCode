
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Vipcard;

public class VipcardDao extends daoTemplate implements pojoDao<Vipcard>{
    
    public VipcardDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Vipcard data) throws Exception {
        String sql="insert into vip_card(Id,CompanyStyle,CardNumber,CardPass,Bonus,Status,CreatTime,UseTime,UseCompanyStyle,UseUserName) values(?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(10);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getCardnumber());
        values.add(object.getCardpass());
        values.add(object.getBonus());
        values.add(object.getStatus());
        values.add(object.getCreattime());
        values.add(object.getUsetime());
        values.add(object.getUsecompanystyle());
        values.add(object.getUseusername());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from vip_card where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Vipcard data) throws Exception {
        StringBuffer sql=new StringBuffer("update vip_card set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getCardnumber()!=null && !"".equals(data.getName())){
            sql.append("CardNumber=?,");
            values.add(data.getCardnumber());
        }
                
        if(data.getCardpass()!=null && !"".equals(data.getName())){
            sql.append("CardPass=?,");
            values.add(data.getCardpass());
        }
                
        if(data.getBonus()!=null && !"".equals(data.getName())){
            sql.append("Bonus=?,");
            values.add(data.getBonus());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getCreattime()!=null && !"".equals(data.getName())){
            sql.append("CreatTime=?,");
            values.add(data.getCreattime());
        }
                
        if(data.getUsetime()!=null && !"".equals(data.getName())){
            sql.append("UseTime=?,");
            values.add(data.getUsetime());
        }
                
        if(data.getUsecompanystyle()!=null && !"".equals(data.getName())){
            sql.append("UseCompanyStyle=?,");
            values.add(data.getUsecompanystyle());
        }
                
        if(data.getUseusername()!=null && !"".equals(data.getName())){
            sql.append("UseUserName=?,");
            values.add(data.getUseusername());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Vipcard> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,CardNumber,CardPass,Bonus,Status,CreatTime,UseTime,UseCompanyStyle,UseUserName from vip_card";
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
        List<Vipcard> datas=new ArrayList<Vipcard>();
        while(rs.next()){
            Vipcard data=new Vipcard();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setCardNumber(rs.getCardnumber("CardNumber"));
            data.setCardPass(rs.getCardpass("CardPass"));
            data.setBonus(rs.getBonus("Bonus"));
            data.setStatus(rs.getStatus("Status"));
            data.setCreatTime(rs.getCreattime("CreatTime"));
            data.setUseTime(rs.getUsetime("UseTime"));
            data.setUseCompanyStyle(rs.getUsecompanystyle("UseCompanyStyle"));
            data.setUseUserName(rs.getUseusername("UseUserName"));	
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
        String sql="select count(1) from vip_card";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            