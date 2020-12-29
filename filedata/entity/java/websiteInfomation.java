
package entity;
// 
public class Websiteinfomation  extends BaseDomain{
    public Websiteinfomation() {

    }
    
    //
    private String CompanyStyle;
        
    //
    private double DayCardPrice;
        
    //
    private double WeekCardPrice;
        
    //
    private double MonthCardPrice;
        
    //
    private double QuarterlyCardPrice;
        
    //
    private double YearCardPrice;
        
    //
    private Date CreateTime;
        
    public String getCompanystyle() {
        return Companystyle;
    }
    public void setCompanystyle(String Companystyle) {
        this.Companystyle = Companystyle;
    }
            
    public double getDaycardprice() {
        return Daycardprice;
    }
    public void setDaycardprice(double Daycardprice) {
        this.Daycardprice = Daycardprice;
    }
            
    public double getWeekcardprice() {
        return Weekcardprice;
    }
    public void setWeekcardprice(double Weekcardprice) {
        this.Weekcardprice = Weekcardprice;
    }
            
    public double getMonthcardprice() {
        return Monthcardprice;
    }
    public void setMonthcardprice(double Monthcardprice) {
        this.Monthcardprice = Monthcardprice;
    }
            
    public double getQuarterlycardprice() {
        return Quarterlycardprice;
    }
    public void setQuarterlycardprice(double Quarterlycardprice) {
        this.Quarterlycardprice = Quarterlycardprice;
    }
            
    public double getYearcardprice() {
        return Yearcardprice;
    }
    public void setYearcardprice(double Yearcardprice) {
        this.Yearcardprice = Yearcardprice;
    }
            
    public Date getCreatetime() {
        return Createtime;
    }
    public void setCreatetime(Date Createtime) {
        this.Createtime = Createtime;
    }
             
    @Override
    public String toString() {
        return "website_infomation[CompanyStyle=" + CompanyStyle + ",DayCardPrice=" + DayCardPrice + ",WeekCardPrice=" + WeekCardPrice + ",MonthCardPrice=" + MonthCardPrice + ",QuarterlyCardPrice=" + QuarterlyCardPrice + ",YearCardPrice=" + YearCardPrice + ",CreateTime=" + CreateTime + "]";
    }
        
    
}
        