
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("vip_card")]
    public class Vipcard
    {
        
        /// <summary>
        /// 主键ID
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 充值卡站点
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 卡号
        /// </summary>
        [Column("CardNumber")]
        public string CardNumber { get; set; }
    
    
        /// <summary>
        /// 充值卡密码
        /// </summary>
        [Column("CardPass")]
        public string CardPass { get; set; }
    
    
        /// <summary>
        /// 充值卡积分面额
        /// </summary>
        [Column("Bonus")]
        public int Bonus { get; set; }
    
    
        /// <summary>
        /// 充值卡状态 0=未使用 1=已使用
        /// </summary>
        [Column("Status")]
        public bool Status { get; set; }
    
    
        /// <summary>
        /// 充值卡创建时间
        /// </summary>
        [Column("CreatTime")]
        public DateTime CreatTime { get; set; }
    
    
        /// <summary>
        /// 充值卡使用时间
        /// </summary>
        [Column("UseTime")]
        public DateTime UseTime { get; set; }
    
    
        /// <summary>
        /// 使用者站点
        /// </summary>
        [Column("UseCompanyStyle")]
        public string UseCompanyStyle { get; set; }
    
    
        /// <summary>
        /// 使用者账号
        /// </summary>
        [Column("UseUserName")]
        public string UseUserName { get; set; }
    
    
    }
}
