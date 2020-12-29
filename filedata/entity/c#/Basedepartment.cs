
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 部门表
    /// </summary>
    [Table("Base_Department")]
    public class Basedepartment
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
        /// 部门名
        /// </summary>
        [Column("Name")]
        public string Name { get; set; }
    
    
        /// <summary>
        /// 上级部门Id
        /// </summary>
        [Column("ParentId")]
        public string ParentId { get; set; }
    
    
    }
}
