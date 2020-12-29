
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("album_type")]
    public class Albumtype
    {
        
        /// <summary>
        /// ID主键 
可关联Videos表中VideoTypeId字段
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 专属站点 不为null则是专属
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 专辑名称
        /// </summary>
        [Column("AlbumName")]
        public string AlbumName { get; set; }
    
    
        /// <summary>
        /// 专辑封面图
        /// </summary>
        [Column("AlbumImg")]
        public string AlbumImg { get; set; }
    
    
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
        /// 专辑详情
        /// </summary>
        [Column("AlbumTitle")]
        public string AlbumTitle { get; set; }
    
    
        /// <summary>
        /// 创建时间
        /// </summary>
        [Column("CreatTime")]
        public DateTime CreatTime { get; set; }
    
    
    }
}
