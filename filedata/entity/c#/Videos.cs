
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("videos")]
    public class Videos
    {
        
        /// <summary>
        /// 视频ID
        /// </summary>
        [Column("Id")]
        public int Id { get; set; }
    
    
        /// <summary>
        /// 视频名称
        /// </summary>
        [Column("VideoName")]
        public string VideoName { get; set; }
    
    
        /// <summary>
        /// 视频类型 1=长视频 2=专辑视频
        /// </summary>
        [Column("VideoType")]
        public int VideoType { get; set; }
    
    
        /// <summary>
        /// 视频封面
        /// </summary>
        [Column("VideoCover")]
        public string VideoCover { get; set; }
    
    
        /// <summary>
        /// 视频播放链接
        /// </summary>
        [Column("VideoPlayConnection")]
        public string VideoPlayConnection { get; set; }
    
    
        /// <summary>
        /// 视频预览链接
        /// </summary>
        [Column("VideoPreviewConnection")]
        public string VideoPreviewConnection { get; set; }
    
    
        /// <summary>
        /// 视频下载链接
        /// </summary>
        [Column("VideoDownloadLink")]
        public string VideoDownloadLink { get; set; }
    
    
        /// <summary>
        /// 视频点赞次数
        /// </summary>
        [Column("VideoLikes")]
        public int VideoLikes { get; set; }
    
    
        /// <summary>
        /// 视频观看次数
        /// </summary>
        [Column("VideoWatchCount")]
        public int VideoWatchCount { get; set; }
    
    
        /// <summary>
        /// 视频内容标签 
 如: 偷拍,SM,后入,人妻 等 
使用#号分割
        /// </summary>
        [Column("VideoTag")]
        public string VideoTag { get; set; }
    
    
        /// <summary>
        /// 视频专属公司 不为null则是专属视频
        /// </summary>
        [Column("VideoCompanyStyle")]
        public string VideoCompanyStyle { get; set; }
    
    
        /// <summary>
        /// 是否收费视频 0=免费 1=收费
        /// </summary>
        [Column("IsCharge")]
        public bool IsCharge { get; set; }
    
    
        /// <summary>
        /// 收费价格
        /// </summary>
        [Column("ChargeAmount")]
        public decimal ChargeAmount { get; set; }
    
    
        /// <summary>
        /// 视频总时间  /  分钟
        /// </summary>
        [Column("VideoTime")]
        public int VideoTime { get; set; }
    
    
        /// <summary>
        /// 视频创建时间
        /// </summary>
        [Column("CreatTime")]
        public DateTime CreatTime { get; set; }
    
    
        /// <summary>
        /// 视频最后修改时间
        /// </summary>
        [Column("UpdateTime")]
        public DateTime UpdateTime { get; set; }
    
    
        /// <summary>
        /// 最后修改人
        /// </summary>
        [Column("Modifier")]
        public string Modifier { get; set; }
    
    
        /// <summary>
        /// 视频从属ID
VideoType=1则从属于VideosType(视频类型)表  VideoType=2则从属于AlbumType(专辑类型)表
        /// </summary>
        [Column("VideoTypeId")]
        public string VideoTypeId { get; set; }
    
    
        /// <summary>
        /// 视频详情描述
        /// </summary>
        [Column("VideoTitle")]
        public string VideoTitle { get; set; }
    
    
    }
}
