
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("videoplay_config")]
    public class Videoplayconfig
    {
        
        /// <summary>
        /// ID主键 这是视频播放配置表
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 短视频播放域名
        /// </summary>
        [Column("ShortPlayUrl")]
        public string ShortPlayUrl { get; set; }
    
    
        /// <summary>
        /// 长视频播放域名
        /// </summary>
        [Column("LongPlayUrl")]
        public string LongPlayUrl { get; set; }
    
    
        /// <summary>
        /// 专辑播放域名
        /// </summary>
        [Column("AlbumPlayUrl")]
        public string AlbumPlayUrl { get; set; }
    
    
        /// <summary>
        /// 状态 0=停用 1=启用
        /// </summary>
        [Column("Status")]
        public bool Status { get; set; }
    
    
        /// <summary>
        /// 是否站点专属域名 0=不是 1=是
        /// </summary>
        [Column("IsPrivate")]
        public bool IsPrivate { get; set; }
    
    
        /// <summary>
        /// 专属站点
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
    }
}
