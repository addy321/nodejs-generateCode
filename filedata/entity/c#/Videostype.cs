
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("videos_type")]
    public class Videostype
    {
        
        /// <summary>
        /// 主键ID 
可关联Videos表中VideoTypeId字段
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 专属站点 不为null则为专属
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 视频从属类型名称
如:国产自拍,激情欧美,成人动漫 等
        /// </summary>
        [Column("TypeName")]
        public string TypeName { get; set; }
    
    
        /// <summary>
        /// 视频类型封面图 可为null
        /// </summary>
        [Column("TypeImg")]
        public string TypeImg { get; set; }
    
    
        /// <summary>
        /// 排序
        /// </summary>
        [Column("Orders")]
        public int Orders { get; set; }
    
    
        /// <summary>
        /// 状态 0=停用 1=启用
        /// </summary>
        [Column("Status")]
        public bool Status { get; set; }
    
    
        /// <summary>
        /// 视频类型详情说明
        /// </summary>
        [Column("TypeTitle")]
        public string TypeTitle { get; set; }
    
    
        /// <summary>
        /// 创建时间
        /// </summary>
        [Column("CreatTime")]
        public DateTime CreatTime { get; set; }
    
    
    }
}
