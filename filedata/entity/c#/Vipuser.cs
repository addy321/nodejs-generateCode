
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("vip_user")]
    public class Vipuser
    {
        
        /// <summary>
        /// ID 主键
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
        /// 会员昵称
        /// </summary>
        [Column("OtherName")]
        public string OtherName { get; set; }
    
    
        /// <summary>
        /// 会员头像
        /// </summary>
        [Column("HeadImg")]
        public string HeadImg { get; set; }
    
    
        /// <summary>
        /// 会员登录密码 默认123456
        /// </summary>
        [Column("UserPass")]
        public string UserPass { get; set; }
    
    
        /// <summary>
        /// 会员余额
        /// </summary>
        [Column("Balance")]
        public decimal Balance { get; set; }
    
    
        /// <summary>
        /// 会员状态 0=停用 1=启用
        /// </summary>
        [Column("Status")]
        public bool Status { get; set; }
    
    
        /// <summary>
        /// 是否绑定手机
        /// </summary>
        [Column("IsBindPhone")]
        public bool IsBindPhone { get; set; }
    
    
        /// <summary>
        /// 会员手机号
        /// </summary>
        [Column("TelePhone")]
        public string TelePhone { get; set; }
    
    
        /// <summary>
        /// 会员上级账号
        /// </summary>
        [Column("ParentId")]
        public string ParentId { get; set; }
    
    
        /// <summary>
        /// 会员邀请码
        /// </summary>
        [Column("InviteCode")]
        public string InviteCode { get; set; }
    
    
        /// <summary>
        /// 会员注册IP
        /// </summary>
        [Column("AddIP")]
        public string AddIP { get; set; }
    
    
        /// <summary>
        /// 会员注册地址
        /// </summary>
        [Column("AddIPStr")]
        public string AddIPStr { get; set; }
    
    
        /// <summary>
        /// 会员注册时间
        /// </summary>
        [Column("AddTime")]
        public DateTime AddTime { get; set; }
    
    
        /// <summary>
        /// 会员最后登录IP
        /// </summary>
        [Column("LoginIp")]
        public string LoginIp { get; set; }
    
    
        /// <summary>
        /// 会员最后登录地址
        /// </summary>
        [Column("LoginIPStr")]
        public string LoginIPStr { get; set; }
    
    
        /// <summary>
        /// 会员最后登录时间
        /// </summary>
        [Column("LoginTime")]
        public DateTime LoginTime { get; set; }
    
    
        /// <summary>
        /// 登录次数
        /// </summary>
        [Column("LoginCount")]
        public int LoginCount { get; set; }
    
    
        /// <summary>
        /// 绑定银行名
        /// </summary>
        [Column("BankName")]
        public string BankName { get; set; }
    
    
        /// <summary>
        /// 绑定银行卡号
        /// </summary>
        [Column("BankAccount")]
        public string BankAccount { get; set; }
    
    
        /// <summary>
        /// 提款密码
        /// </summary>
        [Column("BandPass")]
        public string BandPass { get; set; }
    
    
        /// <summary>
        /// 是否VIP 0=不是
        /// </summary>
        [Column("IsVip")]
        public bool IsVip { get; set; }
    
    
        /// <summary>
        /// VIP类型 0=普通用户 1=普通VIP用户
        /// </summary>
        [Column("VipType")]
        public int VipType { get; set; }
    
    
        /// <summary>
        /// 会员loginkey
        /// </summary>
        [Column("LoginKey")]
        public string LoginKey { get; set; }
    
    
    }
}
