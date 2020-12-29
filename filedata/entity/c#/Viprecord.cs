
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("vip_record")]
    public class Viprecord
    {
        
        /// <summary>
        /// ID主键
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 会员站点
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 会员账号
        /// </summary>
        [Column("UserName")]
        public string UserName { get; set; }
    
    
        /// <summary>
        /// 状态 0=停用 1=启用
        /// </summary>
        [Column("Status")]
        public bool Status { get; set; }
    
    
        /// <summary>
        /// 创建时间
        /// </summary>
        [Column("CreatTime")]
        public DateTime CreatTime { get; set; }
    
    
        /// <summary>
        /// 开始时间
        /// </summary>
        [Column("StartTime")]
        public DateTime StartTime { get; set; }
    
    
        /// <summary>
        /// 结束时间
        /// </summary>
        [Column("EndTime")]
        public DateTime EndTime { get; set; }
    
    
        /// <summary>
        /// 开通类型 0=未知 1=购买VIP开通
        /// </summary>
        [Column("OpenType")]
        public int OpenType { get; set; }
    
    
        /// <summary>
        /// 备注
        /// </summary>
        [Column("Remark")]
        public string Remark { get; set; }
    
    
    }
}
