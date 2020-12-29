
package entity;
// 
public class Videos  extends BaseDomain{
    public Videos() {

    }
    
    //
    private bigint(20) unsigned Id;
        
    //
    private String VideoName;
        
    //
    private int(255) unsigned VideoType;
        
    //
    private String VideoCover;
        
    //
    private String VideoPlayConnection;
        
    //
    private String VideoPreviewConnection;
        
    //
    private String VideoDownloadLink;
        
    //
    private int(255) VideoLikes;
        
    //
    private int(255) VideoWatchCount;
        
    //
    private String VideoTag;
        
    //
    private String VideoCompanyStyle;
        
    //
    private bit(1) IsCharge;
        
    //
    private double ChargeAmount;
        
    //
    private int(255) unsigned VideoTime;
        
    //
    private Date CreatTime;
        
    //
    private Date UpdateTime;
        
    //
    private String Modifier;
        
    //
    private String VideoTypeId;
        
    //
    private String VideoTitle;
        
    public bigint(20) unsigned getId() {
        return Id;
    }
    public void setId(bigint(20) unsigned Id) {
        this.Id = Id;
    }
            
    public String getVideoname() {
        return Videoname;
    }
    public void setVideoname(String Videoname) {
        this.Videoname = Videoname;
    }
            
    public int(255) unsigned getVideotype() {
        return Videotype;
    }
    public void setVideotype(int(255) unsigned Videotype) {
        this.Videotype = Videotype;
    }
            
    public String getVideocover() {
        return Videocover;
    }
    public void setVideocover(String Videocover) {
        this.Videocover = Videocover;
    }
            
    public String getVideoplayconnection() {
        return Videoplayconnection;
    }
    public void setVideoplayconnection(String Videoplayconnection) {
        this.Videoplayconnection = Videoplayconnection;
    }
            
    public String getVideopreviewconnection() {
        return Videopreviewconnection;
    }
    public void setVideopreviewconnection(String Videopreviewconnection) {
        this.Videopreviewconnection = Videopreviewconnection;
    }
            
    public String getVideodownloadlink() {
        return Videodownloadlink;
    }
    public void setVideodownloadlink(String Videodownloadlink) {
        this.Videodownloadlink = Videodownloadlink;
    }
            
    public int(255) getVideolikes() {
        return Videolikes;
    }
    public void setVideolikes(int(255) Videolikes) {
        this.Videolikes = Videolikes;
    }
            
    public int(255) getVideowatchcount() {
        return Videowatchcount;
    }
    public void setVideowatchcount(int(255) Videowatchcount) {
        this.Videowatchcount = Videowatchcount;
    }
            
    public String getVideotag() {
        return Videotag;
    }
    public void setVideotag(String Videotag) {
        this.Videotag = Videotag;
    }
            
    public String getVideocompanystyle() {
        return Videocompanystyle;
    }
    public void setVideocompanystyle(String Videocompanystyle) {
        this.Videocompanystyle = Videocompanystyle;
    }
            
    public bit(1) getIscharge() {
        return Ischarge;
    }
    public void setIscharge(bit(1) Ischarge) {
        this.Ischarge = Ischarge;
    }
            
    public double getChargeamount() {
        return Chargeamount;
    }
    public void setChargeamount(double Chargeamount) {
        this.Chargeamount = Chargeamount;
    }
            
    public int(255) unsigned getVideotime() {
        return Videotime;
    }
    public void setVideotime(int(255) unsigned Videotime) {
        this.Videotime = Videotime;
    }
            
    public Date getCreattime() {
        return Creattime;
    }
    public void setCreattime(Date Creattime) {
        this.Creattime = Creattime;
    }
            
    public Date getUpdatetime() {
        return Updatetime;
    }
    public void setUpdatetime(Date Updatetime) {
        this.Updatetime = Updatetime;
    }
            
    public String getModifier() {
        return Modifier;
    }
    public void setModifier(String Modifier) {
        this.Modifier = Modifier;
    }
            
    public String getVideotypeid() {
        return Videotypeid;
    }
    public void setVideotypeid(String Videotypeid) {
        this.Videotypeid = Videotypeid;
    }
            
    public String getVideotitle() {
        return Videotitle;
    }
    public void setVideotitle(String Videotitle) {
        this.Videotitle = Videotitle;
    }
             
    @Override
    public String toString() {
        return "videos[Id=" + Id + ",VideoName=" + VideoName + ",VideoType=" + VideoType + ",VideoCover=" + VideoCover + ",VideoPlayConnection=" + VideoPlayConnection + ",VideoPreviewConnection=" + VideoPreviewConnection + ",VideoDownloadLink=" + VideoDownloadLink + ",VideoLikes=" + VideoLikes + ",VideoWatchCount=" + VideoWatchCount + ",VideoTag=" + VideoTag + ",VideoCompanyStyle=" + VideoCompanyStyle + ",IsCharge=" + IsCharge + ",ChargeAmount=" + ChargeAmount + ",VideoTime=" + VideoTime + ",CreatTime=" + CreatTime + ",UpdateTime=" + UpdateTime + ",Modifier=" + Modifier + ",VideoTypeId=" + VideoTypeId + ",VideoTitle=" + VideoTitle + "]";
    }
        
    
}
        