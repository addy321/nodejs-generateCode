
var db = require('./dbConfig')
var jsonutil = require('../utils/jsontool/index')

/**
 * mysql 查询数据库中所有的表
 * @param {Function} callback 表的信息
 */
function MysqlallTable(callback) {
    jsonutil.getMysqlJSON(function(mysqlConfig){
        var sql = `SELECT a.table_name tableName, a.table_comment tableDirections FROM information_schema. TABLES a WHERE a.table_schema = '${mysqlConfig.database}'`
        db.querySql(sql,null, function (results,fields) {
            callback(results)
        })
    })
}

/**
 * mysql 查询表中所有字段信息
 * @param {String} tableName 表名
 * @param {Function} callback 表的信息
 */
function MysqlallField(tableName, callback) {
    jsonutil.getMysqlJSON(function(mysqlConfig){
        var sql = `select  *  from information_schema.columns where table_schema ='${mysqlConfig.database}'  and table_name = '${tableName}' ;`;
        db.querySql(sql, null, function (results,fields) {
            callback(results)
        })
    })
}

module.exports = {
    MysqlallTable, MysqlallField
}