
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 系统角色表
    /// </summary>
    [Table("Base_Role")]
    public class Baserole
    {
        
        /// <summary>
        /// 主键
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
        /// 角色名
        /// </summary>
        [Column("RoleName")]
        public string RoleName { get; set; }
    
    
    }
}
