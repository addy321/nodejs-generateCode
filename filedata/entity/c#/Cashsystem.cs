
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("cash_system")]
    public class Cashsystem
    {
        
        /// <summary>
        /// 主键ID
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 订单号
        /// </summary>
        [Column("Oid")]
        public string Oid { get; set; }
    
    
        /// <summary>
        /// 用户站点
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 用户账号
        /// </summary>
        [Column("UserName")]
        public string UserName { get; set; }
    
    
        /// <summary>
        /// 入库时间
        /// </summary>
        [Column("EnrolmentTime")]
        public DateTime EnrolmentTime { get; set; }
    
    
        /// <summary>
        /// 处理时间
        /// </summary>
        [Column("ProcessingTime")]
        public DateTime ProcessingTime { get; set; }
    
    
        /// <summary>
        /// 操作金额
        /// </summary>
        [Column("ActionMoney")]
        public decimal ActionMoney { get; set; }
    
    
        /// <summary>
        /// 赠送金额
        /// </summary>
        [Column("SpMoney")]
        public decimal SpMoney { get; set; }
    
    
        /// <summary>
        /// 操作后余额
        /// </summary>
        [Column("NewBalance")]
        public decimal NewBalance { get; set; }
    
    
        /// <summary>
        /// 操作类型
        /// </summary>
        [Column("ActionType")]
        public int ActionType { get; set; }
    
    
        /// <summary>
        /// 操作类型备注
        /// </summary>
        [Column("ActionRemark")]
        public string ActionRemark { get; set; }
    
    
        /// <summary>
        /// 订单备注
        /// </summary>
        [Column("Description")]
        public string Description { get; set; }
    
    
    }
}
