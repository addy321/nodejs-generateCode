
var db = require('../db/dbConfig')

/*
mysql 查询数据库中所有的表
wareroomName = 数据库
*/
function MysqlallTable(callback){
    var sql = `SELECT a.table_name tableName, a.table_comment tableDirections FROM information_schema. TABLES a WHERE a.table_schema = '${db.mysqlConfig.database}'`
    db.querySql(sql).then(tableData =>{ 
        callback(tableData)
    })
}
/*
mysql 查询表中所有字段信息
wareroomName = 数据库
tableName = 表名
 */
function MysqlallField(tableName,callback){
    var sql =`select  *  from information_schema.columns where table_schema ='${db.mysqlConfig.database}'  and table_name = '${tableName}' ;`;
    db.querySql(sql).then(Fieids =>{
        callback(Fieids)
    })
}

module.exports = {
    MysqlallTable,MysqlallField
}