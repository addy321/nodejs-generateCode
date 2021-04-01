var mysql = require('mysql')
var mssql = require('mssql')
var jsonutil = require('../utils/jsontool/index')

function querySql(sql, params, callback) {
    jsonutil.getSqlJSON(function (sqlJson) {
        if (sqlJson.type == 1) {
            mysqlQuery(sql, params, sqlJson,x=>{
                callback(x)
            })
        }
        if (sqlJson.type == 2) {
            SqlServiceQuery(sql, params, sqlJson, (error,x)=>{
                callback(x[0])
            })
        }
    })
}
/**
 * 
 * @param {String} sql 
 * @param {[]} params 
 * @param {{}} sqlJson 
 * @param {Function} callback 
 */
function mysqlQuery(sql, params, sqlJson, callback) {
    var mysqlConfig = {
        host: sqlJson.host,
        user: sqlJson.user,
        password: sqlJson.password,
        port: sqlJson.port,
        database: sqlJson.database
    }
    //每次使用的时候需要创建链接，数据操作完成之后要关闭连接
    var connection = mysql.createConnection(mysqlConfig);
    connection.connect(function (err) {
        if (err) {
            throw new Error("数据库链接失败!");
        }
        //开始数据操作
        //传入三个参数，第一个参数sql语句，第二个参数sql语句中需要的数据，第三个参数回调函数
        connection.query(sql, params, function (err, results, fields) {
            if (err) {
                throw new Error("数据操作失败!");
            }
            //将查询出来的数据返回给回调函数
            callback && callback(results, fields);
            //results作为数据操作后的结果，fields作为数据库连接的一些字段
            //停止链接数据库，必须再查询语句后，要不然一调用这个方法，就直接停止链接，数据操作就会失败
            connection.end(function (err) {
                if (err) {
                    throw new Error("关闭数据库连接失败！!");
                }
            });
        });
    });
}
/**
 * 
 * @param {String} sql 
 * @param {[]} params 
 * @param {{}} sqlJson 
 * @param {Function} callback 
 */
function SqlServiceQuery(sql, params, sqlJson, callback) {
    var config = {
        user: sqlJson.user,
        password: sqlJson.password,
        server: sqlJson.host,
        database: sqlJson.database,
        port: sqlJson.port,
        pool: {
            min: 0,
            max: 100,
            idleTimeoutMillis: 3000
        }
    };
    var connection = new mssql.ConnectionPool(config);
    connection.on('error', function (err) {
        console.error(err);
    });
    connection.connect(function (err) {
        if (err) {
            console.error(err);
        }else{
            var ps = new mssql.PreparedStatement(connection);
            if (params != "") {
                for (var index in params) {
                    if (typeof params[index] == "number") {
                        ps.input(index, mssql.BigInt);
                    } else if (typeof params[index] == "string") {
                        ps.input(index, mssql.NVarChar);
                    }
                }
            }
            console.log("sql:" + sql);
            ps.prepare(sql, function (err) {
                if (err)
                    console.log(err);
                ps.execute(params, function (err, recordset) {
                    callback && callback(err, recordset.recordsets);
                    ps.unprepare(function (err) {
                        if (err)
                            console.log(err);
                    });
                });
            });
        }
    })
};

module.exports = {
    querySql,
}