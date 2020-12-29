var mysql = require('mysql')

var mysqlConfig = {
    connectionLimit: 10,    // 连接数量
    host: '192.168.31.226',
    user: 'root',
    password: '0C7kaPl0R1EKaxHl',
    port: '3308',
    database: 'NewProject'
}
// 创建mysql 连接池
var pool = mysql.createPool(mysqlConfig)

function querySql(sql, param) {
    return new Promise((resolve, reject) => {
        // 从连接池里获取一个连接
        pool.getConnection((err, connection) => {
            if (err) {
                reject(err)
            } else {
                console.log(sql)
                console.log('---------------------------')
                connection.query({ sql: sql, timeout: 3000 }, param, (err, result) => {
                    if (err) {
                        reject(err)
                        return err
                    } else {
                        resolve(result)
                    }
                })
            }
            // 释放连接
            connection.release()
        })
    })
}

module.exports = {
    querySql
}