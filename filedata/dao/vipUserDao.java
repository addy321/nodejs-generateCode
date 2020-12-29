
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Vipuser;

public class VipuserDao extends daoTemplate implements pojoDao<Vipuser>{
    
    public VipuserDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Vipuser data) throws Exception {
        String sql="insert into vip_user(Id,CompanyStyle,UserName,OtherName,HeadImg,UserPass,Balance,Status,IsBindPhone,TelePhone,ParentId,InviteCode,AddIP,AddIPStr,AddTime,LoginIp,LoginIPStr,LoginTime,LoginCount,BankName,BankAccount,BandPass,IsVip,VipType,LoginKey) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(25);
        
        values.add(object.getId());
        values.add(object.getCompanystyle());
        values.add(object.getUsername());
        values.add(object.getOthername());
        values.add(object.getHeadimg());
        values.add(object.getUserpass());
        values.add(object.getBalance());
        values.add(object.getStatus());
        values.add(object.getIsbindphone());
        values.add(object.getTelephone());
        values.add(object.getParentid());
        values.add(object.getInvitecode());
        values.add(object.getAddip());
        values.add(object.getAddipstr());
        values.add(object.getAddtime());
        values.add(object.getLoginip());
        values.add(object.getLoginipstr());
        values.add(object.getLogintime());
        values.add(object.getLogincount());
        values.add(object.getBankname());
        values.add(object.getBankaccount());
        values.add(object.getBandpass());
        values.add(object.getIsvip());
        values.add(object.getViptype());
        values.add(object.getLoginkey());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String Id) throws Exception {
        String sql="delete from vip_user where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Vipuser data) throws Exception {
        StringBuffer sql=new StringBuffer("update vip_user set ");
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
                
        if(data.getOthername()!=null && !"".equals(data.getName())){
            sql.append("OtherName=?,");
            values.add(data.getOthername());
        }
                
        if(data.getHeadimg()!=null && !"".equals(data.getName())){
            sql.append("HeadImg=?,");
            values.add(data.getHeadimg());
        }
                
        if(data.getUserpass()!=null && !"".equals(data.getName())){
            sql.append("UserPass=?,");
            values.add(data.getUserpass());
        }
                
        if(data.getBalance()!=null && !"".equals(data.getName())){
            sql.append("Balance=?,");
            values.add(data.getBalance());
        }
                
        if(data.getStatus()!=null && !"".equals(data.getName())){
            sql.append("Status=?,");
            values.add(data.getStatus());
        }
                
        if(data.getIsbindphone()!=null && !"".equals(data.getName())){
            sql.append("IsBindPhone=?,");
            values.add(data.getIsbindphone());
        }
                
        if(data.getTelephone()!=null && !"".equals(data.getName())){
            sql.append("TelePhone=?,");
            values.add(data.getTelephone());
        }
                
        if(data.getParentid()!=null && !"".equals(data.getName())){
            sql.append("ParentId=?,");
            values.add(data.getParentid());
        }
                
        if(data.getInvitecode()!=null && !"".equals(data.getName())){
            sql.append("InviteCode=?,");
            values.add(data.getInvitecode());
        }
                
        if(data.getAddip()!=null && !"".equals(data.getName())){
            sql.append("AddIP=?,");
            values.add(data.getAddip());
        }
                
        if(data.getAddipstr()!=null && !"".equals(data.getName())){
            sql.append("AddIPStr=?,");
            values.add(data.getAddipstr());
        }
                
        if(data.getAddtime()!=null && !"".equals(data.getName())){
            sql.append("AddTime=?,");
            values.add(data.getAddtime());
        }
                
        if(data.getLoginip()!=null && !"".equals(data.getName())){
            sql.append("LoginIp=?,");
            values.add(data.getLoginip());
        }
                
        if(data.getLoginipstr()!=null && !"".equals(data.getName())){
            sql.append("LoginIPStr=?,");
            values.add(data.getLoginipstr());
        }
                
        if(data.getLogintime()!=null && !"".equals(data.getName())){
            sql.append("LoginTime=?,");
            values.add(data.getLogintime());
        }
                
        if(data.getLogincount()!=null && !"".equals(data.getName())){
            sql.append("LoginCount=?,");
            values.add(data.getLogincount());
        }
                
        if(data.getBankname()!=null && !"".equals(data.getName())){
            sql.append("BankName=?,");
            values.add(data.getBankname());
        }
                
        if(data.getBankaccount()!=null && !"".equals(data.getName())){
            sql.append("BankAccount=?,");
            values.add(data.getBankaccount());
        }
                
        if(data.getBandpass()!=null && !"".equals(data.getName())){
            sql.append("BandPass=?,");
            values.add(data.getBandpass());
        }
                
        if(data.getIsvip()!=null && !"".equals(data.getName())){
            sql.append("IsVip=?,");
            values.add(data.getIsvip());
        }
                
        if(data.getViptype()!=null && !"".equals(data.getName())){
            sql.append("VipType=?,");
            values.add(data.getViptype());
        }
                
        if(data.getLoginkey()!=null && !"".equals(data.getName())){
            sql.append("LoginKey=?,");
            values.add(data.getLoginkey());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(stu.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Vipuser> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select Id,CompanyStyle,UserName,OtherName,HeadImg,UserPass,Balance,Status,IsBindPhone,TelePhone,ParentId,InviteCode,AddIP,AddIPStr,AddTime,LoginIp,LoginIPStr,LoginTime,LoginCount,BankName,BankAccount,BandPass,IsVip,VipType,LoginKey from vip_user";
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
        List<Vipuser> datas=new ArrayList<Vipuser>();
        while(rs.next()){
            Vipuser data=new Vipuser();
            
            data.setId(rs.getId("Id"));
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setUserName(rs.getUsername("UserName"));
            data.setOtherName(rs.getOthername("OtherName"));
            data.setHeadImg(rs.getHeadimg("HeadImg"));
            data.setUserPass(rs.getUserpass("UserPass"));
            data.setBalance(rs.getBalance("Balance"));
            data.setStatus(rs.getStatus("Status"));
            data.setIsBindPhone(rs.getIsbindphone("IsBindPhone"));
            data.setTelePhone(rs.getTelephone("TelePhone"));
            data.setParentId(rs.getParentid("ParentId"));
            data.setInviteCode(rs.getInvitecode("InviteCode"));
            data.setAddIP(rs.getAddip("AddIP"));
            data.setAddIPStr(rs.getAddipstr("AddIPStr"));
            data.setAddTime(rs.getAddtime("AddTime"));
            data.setLoginIp(rs.getLoginip("LoginIp"));
            data.setLoginIPStr(rs.getLoginipstr("LoginIPStr"));
            data.setLoginTime(rs.getLogintime("LoginTime"));
            data.setLoginCount(rs.getLogincount("LoginCount"));
            data.setBankName(rs.getBankname("BankName"));
            data.setBankAccount(rs.getBankaccount("BankAccount"));
            data.setBandPass(rs.getBandpass("BandPass"));
            data.setIsVip(rs.getIsvip("IsVip"));
            data.setVipType(rs.getViptype("VipType"));
            data.setLoginKey(rs.getLoginkey("LoginKey"));	
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
        String sql="select count(1) from vip_user";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            