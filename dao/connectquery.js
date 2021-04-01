
var db = require('./dbConfig')
var jsonutil = require('../utils/jsontool/index')

/**
 * mysql 查询数据库中所有的表
 * @param {Function} callback 表的信息
 */
function MysqlallTable(callback) {
    jsonutil.getSqlJSON(function(sqlJson){
        if (sqlJson.type == 1) {
            var sql = `SELECT a.table_name tableName, a.table_comment tableDirections FROM information_schema. TABLES a WHERE a.table_schema = '${sqlJson.database}'`
            db.querySql(sql,null, function (results) {
                callback(results)
            })
        }
        if(sqlJson.type == 2){
            var sql = `select name tableName,name tableDirections from sysobjects where xtype='U'`
            db.querySql(sql,null, function (results) {
                callback(results)
            })
        }
    })
}

/**
 * mysql 查询表中所有字段信息
 * @param {String} tableName 表名
 * @param {Function} callback 
 */
function MysqlallField(tableName, callback) {
    jsonutil.getSqlJSON(function(sqlJson){
        if (sqlJson.type == 1) {
            var sql = `select  ORDINAL_POSITION as Fieldcolorder,COLUMN_NAME as Fieldname,COLUMN_KEY as  FieldPK,DATA_TYPE as FieldType,IS_NULLABLE as FieldISNULL,EXTRA as FieldMR,COLUMN_COMMENT as FieldSM
            from information_schema.columns where table_schema ='${sqlJson.database}'  and table_name = '${tableName}' ;`;
            db.querySql(sql, null, function (results) {
                // results.forEach(element => {
                //     var Field = {    
                //         Fieldcolorder:element.ORDINAL_POSITION, //排序列
                //         Fieldname:element.COLUMN_NAME,// 字段名称
                //         FieldPK:element.COLUMN_KEY, //主键
                //         FieldType:element.DATA_TYPE,// 字段类型
                //         FieldISNULL: element.IS_NULLABLE,// 是否可以为null
                //         FieldMR:element.EXTRA,// 默认值
                //         FieldSM: element.COLUMN_COMMENT// 字段说明
                //     }
                //     Fields.push(Field)
                // });
                callback(results)
            })
        }
        if(sqlJson.type == 2){
            var sql = `SELECT Fieldcolorder = a.colorder, Fieldname = a.name, FieldBS = case when COLUMNPROPERTY( a.id,a.name,'IsIdentity')=1 then 'true'else ''
            end, FieldPK = case when exists(SELECT 1 FROM sysobjects where xtype='PK' and parent_obj=a.id and name in( SELECT name FROM sysindexes WHERE 
            indid in( SELECT indid FROM sysindexkeys WHERE id = a.id AND colid=a.colid))) then 'true' else '' end, FieldType = b.name,
            FieldISNULL = case when a.isnullable=1 then 'true'else '' end, FieldMR = isnull(e.text,''), FieldSM = isnull(g.[value],'') 
            FROM syscolumns a left join systypes b on a.xusertype=b.xusertype inner join sysobjects d on a.id=d.id and d.xtype='U' 
            and d.name<>'dtproperties' left join syscomments e on a.cdefault=e.id left join sys.extended_properties g on 
            a.id=G.major_id and a.colid=g.minor_id left join sys.extended_properties f on d.id=f.major_id and f.minor_id=0
            where d.name='${tableName}'
            order by a.id,a.colorder`
            db.querySql(sql, null, function (results) {
            //    results.forEach(element => {
            //        var Field = {
            //            Fieldcolorder:element.ORDINAL_POSITION, //排序列
            //            Fieldname:element.COLUMN_NAME,// 字段名称
            //            FieldPK:element.COLUMN_KEY, //主键
            //            FieldType:element.DATA_TYPE,// 字段类型
            //            FieldISNULL: element.IS_NULLABLE,// 是否可以为null
            //            FieldMR:element.EXTRA,// 默认值
            //            FieldSM: element.COLUMN_COMMENT// 字段说明
            //         }
            //         Fields.push(Field)
            //     });
                callback(results)
            })
        }
    })
}

module.exports = {
    MysqlallTable, MysqlallField
}