
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("video_collection")]
    public class Videocollection
    {
        
        /// <summary>
        /// 主键Id
        /// </summary>
        [Column("id")]
        public int id { get; set; }
    
    
        /// <summary>
        /// 视频名称
        /// </summary>
        [Column("video_name")]
        public string videoName { get; set; }
    
    
        /// <summary>
        /// 视频封面
        /// </summary>
        [Column("video_poster")]
        public string videoPoster { get; set; }
    
    
        /// <summary>
        /// 视频预览地址
        /// </summary>
        [Column("video_preview")]
        public string videoPreview { get; set; }
    
    
        /// <summary>
        /// 视频评分
        /// </summary>
        [Column("video_score")]
        public string videoScore { get; set; }
    
    
        /// <summary>
        /// 视频类型
        /// </summary>
        [Column("video_type_name")]
        public string videoTypeName { get; set; }
    
    
        /// <summary>
        /// 视频地区
        /// </summary>
        [Column("video_country")]
        public string videoCountry { get; set; }
    
    
        /// <summary>
        /// 视频时长
        /// </summary>
        [Column("video_time")]
        public string videoTime { get; set; }
    
    
        /// <summary>
        /// 视频源站点
        /// </summary>
        [Column("video_domain")]
        public string videoDomain { get; set; }
    
    
        /// <summary>
        /// 源站名称
        /// </summary>
        [Column("domain_name")]
        public string domainName { get; set; }
    
    
        /// <summary>
        /// 是否下载完成
        /// </summary>
        [Column("is_down_finsh")]
        public bool isDownFinsh { get; set; }
    
    
        /// <summary>
        /// 主键Id
        /// </summary>
        [Column("id")]
        public int id { get; set; }
    
    
        /// <summary>
        /// 视频名称
        /// </summary>
        [Column("video_name")]
        public string videoName { get; set; }
    
    
        /// <summary>
        /// 视频封面
        /// </summary>
        [Column("video_poster")]
        public string videoPoster { get; set; }
    
    
        /// <summary>
        /// 视频预览地址
        /// </summary>
        [Column("video_preview")]
        public string videoPreview { get; set; }
    
    
        /// <summary>
        /// 视频评分
        /// </summary>
        [Column("video_score")]
        public string videoScore { get; set; }
    
    
        /// <summary>
        /// 视频类型
        /// </summary>
        [Column("video_type_name")]
        public string videoTypeName { get; set; }
    
    
        /// <summary>
        /// 视频地区
        /// </summary>
        [Column("video_country")]
        public string videoCountry { get; set; }
    
    
        /// <summary>
        /// 视频时长
        /// </summary>
        [Column("video_time")]
        public string videoTime { get; set; }
    
    
        /// <summary>
        /// 视频源站点
        /// </summary>
        [Column("video_domain")]
        public string videoDomain { get; set; }
    
    
        /// <summary>
        /// 源站名称
        /// </summary>
        [Column("domain_name")]
        public string domainName { get; set; }
    
    
        /// <summary>
        /// 是否下载完成
        /// </summary>
        [Column("is_down_finsh")]
        public bool isDownFinsh { get; set; }
    
    
    }
}
