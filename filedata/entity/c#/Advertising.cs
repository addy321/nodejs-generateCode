
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("advertising")]
    public class Advertising
    {
        
        /// <summary>
        /// 广告ID
        /// </summary>
        [Column("Id")]
        public int Id { get; set; }
    
    
        /// <summary>
        /// 公司后缀
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 广告类型
        /// </summary>
        [Column("AdvertisingType")]
        public int AdvertisingType { get; set; }
    
    
        /// <summary>
        /// 广告标题
        /// </summary>
        [Column("AdvertisingTitle")]
        public string AdvertisingTitle { get; set; }
    
    
        /// <summary>
        /// 广告内容
        /// </summary>
        [Column("AdvertisingDetail")]
        public string AdvertisingDetail { get; set; }
    
    
        /// <summary>
        /// 广告图链接
        /// </summary>
        [Column("AdvertisingImg")]
        public string AdvertisingImg { get; set; }
    
    
        /// <summary>
        /// 跳转方式 1=网络URL路径   2=本地H5
        /// </summary>
        [Column("JumpType")]
        public int JumpType { get; set; }
    
    
        /// <summary>
        /// 广告跳转地址
        /// </summary>
        [Column("AdvertisingJumpUrl")]
        public string AdvertisingJumpUrl { get; set; }
    
    
        /// <summary>
        /// 最后更新时间
        /// </summary>
        [Column("UpdateTime")]
        public DateTime UpdateTime { get; set; }
    
    
        /// <summary>
        /// 状态  0=停用 1=启用
        /// </summary>
        [Column("Status")]
        public int Status { get; set; }
    
    
        /// <summary>
        /// 排序
        /// </summary>
        [Column("Orders")]
        public int Orders { get; set; }
    
    
    }
}
