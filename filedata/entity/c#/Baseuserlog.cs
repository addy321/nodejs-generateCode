
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 系统日志表
    /// </summary>
    [Table("Base_UserLog")]
    public class Baseuserlog
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
        /// 创建人姓名
        /// </summary>
        [Column("CreatorRealName")]
        public string CreatorRealName { get; set; }
    
    
        /// <summary>
        /// 日志类型
        /// </summary>
        [Column("LogType")]
        public string LogType { get; set; }
    
    
        /// <summary>
        /// 日志内容
        /// </summary>
        [Column("LogContent")]
        public longtext LogContent { get; set; }
    
    
    }
}
