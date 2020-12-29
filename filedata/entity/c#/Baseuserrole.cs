
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 用户角色表
    /// </summary>
    [Table("Base_UserRole")]
    public class Baseuserrole
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
        /// 用户Id
        /// </summary>
        [Column("UserId")]
        public string UserId { get; set; }
    
    
        /// <summary>
        /// 角色Id
        /// </summary>
        [Column("RoleId")]
        public string RoleId { get; set; }
    
    
    }
}
