
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.Websiteinfomation;

public class WebsiteinfomationDao extends daoTemplate implements pojoDao<Websiteinfomation>{
    
    public WebsiteinfomationDao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(Websiteinfomation data) throws Exception {
        String sql="insert into website_infomation(CompanyStyle,DayCardPrice,WeekCardPrice,MonthCardPrice,QuarterlyCardPrice,YearCardPrice,CreateTime) values(?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(7);
        
        values.add(object.getCompanystyle());
        values.add(object.getDaycardprice());
        values.add(object.getWeekcardprice());
        values.add(object.getMonthcardprice());
        values.add(object.getQuarterlycardprice());
        values.add(object.getYearcardprice());
        values.add(object.getCreatetime());
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(String CompanyStyle) throws Exception {
        String sql="delete from website_infomation where CompanyStyle=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(CompanyStyle);
        return executeUpdate(sql, values);
    }

    @Override
    public int update(Websiteinfomation data) throws Exception {
        StringBuffer sql=new StringBuffer("update website_infomation set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getCompanystyle()!=null && !"".equals(data.getName())){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanystyle());
        }
                
        if(data.getDaycardprice()!=null && !"".equals(data.getName())){
            sql.append("DayCardPrice=?,");
            values.add(data.getDaycardprice());
        }
                
        if(data.getWeekcardprice()!=null && !"".equals(data.getName())){
            sql.append("WeekCardPrice=?,");
            values.add(data.getWeekcardprice());
        }
                
        if(data.getMonthcardprice()!=null && !"".equals(data.getName())){
            sql.append("MonthCardPrice=?,");
            values.add(data.getMonthcardprice());
        }
                
        if(data.getQuarterlycardprice()!=null && !"".equals(data.getName())){
            sql.append("QuarterlyCardPrice=?,");
            values.add(data.getQuarterlycardprice());
        }
                
        if(data.getYearcardprice()!=null && !"".equals(data.getName())){
            sql.append("YearCardPrice=?,");
            values.add(data.getYearcardprice());
        }
                
        if(data.getCreatetime()!=null && !"".equals(data.getName())){
            sql.append("CreateTime=?,");
            values.add(data.getCreatetime());
        }
                
        
        
        sql.append(" where CompanyStyle=?");
        values.add(stu.getCompanystyle());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<Websiteinfomation> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select CompanyStyle,DayCardPrice,WeekCardPrice,MonthCardPrice,QuarterlyCardPrice,YearCardPrice,CreateTime from website_infomation";
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
        List<Websiteinfomation> datas=new ArrayList<Websiteinfomation>();
        while(rs.next()){
            Websiteinfomation data=new Websiteinfomation();
            
            data.setCompanyStyle(rs.getCompanystyle("CompanyStyle"));
            data.setDayCardPrice(rs.getDaycardprice("DayCardPrice"));
            data.setWeekCardPrice(rs.getWeekcardprice("WeekCardPrice"));
            data.setMonthCardPrice(rs.getMonthcardprice("MonthCardPrice"));
            data.setQuarterlyCardPrice(rs.getQuarterlycardprice("QuarterlyCardPrice"));
            data.setYearCardPrice(rs.getYearcardprice("YearCardPrice"));
            data.setCreateTime(rs.getCreatetime("CreateTime"));	
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
        String sql="select count(1) from website_infomation";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            