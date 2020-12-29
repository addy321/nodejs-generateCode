
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 系统用户表
    /// </summary>
    [Table("Base_User")]
    public class Baseuser
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
        /// 用户名
        /// </summary>
        [Column("UserName")]
        public string UserName { get; set; }
    
    
        /// <summary>
        /// 密码
        /// </summary>
        [Column("Password")]
        public string Password { get; set; }
    
    
        /// <summary>
        /// 姓名
        /// </summary>
        [Column("RealName")]
        public string RealName { get; set; }
    
    
        /// <summary>
        /// 性别(1为男，0为女)
        /// </summary>
        [Column("Sex")]
        public int Sex { get; set; }
    
    
        /// <summary>
        /// 出生日期
        /// </summary>
        [Column("Birthday")]
        public date Birthday { get; set; }
    
    
        /// <summary>
        /// 所属部门Id
        /// </summary>
        [Column("DepartmentId")]
        public string DepartmentId { get; set; }
    
    
    }
}
