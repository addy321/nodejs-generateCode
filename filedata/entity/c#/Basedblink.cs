
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 数据库连接表
    /// </summary>
    [Table("Base_DbLink")]
    public class Basedblink
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
        /// 连接名
        /// </summary>
        [Column("LinkName")]
        public string LinkName { get; set; }
    
    
        /// <summary>
        /// 连接字符串
        /// </summary>
        [Column("ConnectionStr")]
        public text ConnectionStr { get; set; }
    
    
        /// <summary>
        /// 数据库类型
        /// </summary>
        [Column("DbType")]
        public string DbType { get; set; }
    
    
    }
}
