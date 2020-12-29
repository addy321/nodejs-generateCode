
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Cashsystem;

public class CashsystemDao extends daoTemplate implements pojoDao<Cashsystem>{
    
    public CashsystemDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Cashsystem data) throws Exception {
        String sql="insert into cash_system(Id,Oid,CompanyStyle,UserName,EnrolmentTime,ProcessingTime,ActionMoney,SpMoney,NewBalance,ActionType,ActionRemark,Description) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(12);
        
        values.add(object.getId());
        values.add(object.getOid());
        values.add(object.getCompanystyle());
        values.add(object.getUsername());
        values.add(object.getEnrolmenttime());
        values.add(object.getProcessingtime());
        values.add(object.getActionmoney());
        values.add(object.getSpmoney());
        values.add(object.getNewbalance());
        values.add(object.getActiontype());
        values.add(object.getActionremark());
        values.add(object.getDescription());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from cash_system where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Cashsystem data) throws Exception {
        StringBuffer sql=new StringBuffer("update cash_system set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null && !"".equals(data.getName())){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getOid()!=null && !"".equals(data.getName())){
            sql.append("Oid=?,");
            values.add(data.getOid());
        }
                
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getUsername()!=null && !"".equals(data.getName())){
            sql.append("UserName=?,");
            values.add(data.getUsername());
        }
                
        if(data.getEnrolmenttime()!=null && !"".equals(data.getName())){
            sql.append("EnrolmentTime=?,");
            values.add(data.getEnrolmenttime());
        }
                
        if(data.getProcessingtime()!=null && !"".equals(data.getName())){
            sql.append("ProcessingTime=?,");
            values.add(data.getProcessingtime());
        }
                
        if(data.getActionmoney()!=null && !"".equals(data.getName())){
            sql.append("ActionMoney=?,");
            values.add(data.getActionmoney());
        }
                
        if(data.getSpmoney()!=null && !"".equals(data.getName())){
            sql.append("SpMoney=?,");
            values.add(data.getSpmoney());
        }
                
        if(data.getNewbalance()!=null && !"".equals(data.getName())){
            sql.append("NewBalance=?,");
            values.add(data.getNewbalance());
        }
                
        if(data.getActiontype()!=null && !"".equals(data.getName())){
            sql.append("ActionType=?,");
            values.add(data.getActiontype());
        }
                
        if(data.getActionremark()!=null && !"".equals(data.getName())){
            sql.append("ActionRemark=?,");
            values.add(data.getActionremark());
        }
                
        if(data.getDescription()!=null && !"".equals(data.getName())){
            sql.append("Description=?,");
            values.add(data.getDescription());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Cashsystem> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,Oid,CompanyStyle,UserName,EnrolmentTime,ProcessingTime,ActionMoney,SpMoney,NewBalance,ActionType,ActionRemark,Description from cash_system";
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
        List<Cashsystem> datas=new ArrayList<Cashsystem>();
        while(rs.next()){
            Cashsystem data=new Cashsystem();
            
            data.setId(rs.getId("Id"));
            data.setOid(rs.getOid("Oid"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setUserName(rs.getUsername("UserName"));
            data.setEnrolmentTime(rs.getEnrolmenttime("EnrolmentTime"));
            data.setProcessingTime(rs.getProcessingtime("ProcessingTime"));
            data.setActionMoney(rs.getActionmoney("ActionMoney"));
            data.setSpMoney(rs.getSpmoney("SpMoney"));
            data.setNewBalance(rs.getNewbalance("NewBalance"));
            data.setActionType(rs.getActiontype("ActionType"));
            data.setActionRemark(rs.getActionremark("ActionRemark"));
            data.setDescription(rs.getDescription("Description"));	
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
        String sql="select count(1) from cash_system";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            