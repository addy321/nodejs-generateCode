
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("website_infomation")]
    public class Websiteinfomation
    {
        
        /// <summary>
        /// 站点名称 主键
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 体验卡价格 1天
        /// </summary>
        [Column("DayCardPrice")]
        public decimal DayCardPrice { get; set; }
    
    
        /// <summary>
        /// 周卡价格 7天
        /// </summary>
        [Column("WeekCardPrice")]
        public decimal WeekCardPrice { get; set; }
    
    
        /// <summary>
        /// 月卡价格 30天
        /// </summary>
        [Column("MonthCardPrice")]
        public decimal MonthCardPrice { get; set; }
    
    
        /// <summary>
        /// 季卡价格 90天
        /// </summary>
        [Column("QuarterlyCardPrice")]
        public decimal QuarterlyCardPrice { get; set; }
    
    
        /// <summary>
        /// 年卡价格 360天
        /// </summary>
        [Column("YearCardPrice")]
        public decimal YearCardPrice { get; set; }
    
    
        /// <summary>
        /// 创建时间
        /// </summary>
        [Column("CreateTime")]
        public DateTime CreateTime { get; set; }
    
    
    }
}
