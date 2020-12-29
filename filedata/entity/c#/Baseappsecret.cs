
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 应用密钥表
    /// </summary>
    [Table("Base_AppSecret")]
    public class Baseappsecret
    {
        
        /// <summary>
        /// 自然主键
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 创建时间
        /// </summary>
        [Column("CreateTime")]
        public DateTime CreateTime { get; set; }
    
    
        /// <summary>
        /// 创建人Id
        /// </summary>
        [Column("CreatorId")]
        public string CreatorId { get; set; }
    
    
        /// <summary>
        /// 否已删除
        /// </summary>
        [Column("Deleted")]
        public int Deleted { get; set; }
    
    
        /// <summary>
        /// 应用Id
        /// </summary>
        [Column("AppId")]
        public string AppId { get; set; }
    
    
        /// <summary>
        /// 应用密钥
        /// </summary>
        [Column("AppSecret")]
        public string AppSecret { get; set; }
    
    
        /// <summary>
        /// 应用名
        /// </summary>
        [Column("AppName")]
        public string AppName { get; set; }
    
    
    }
}
