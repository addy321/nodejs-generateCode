var fs = require('fs');
var itempath = process.cwd()
/**
 * 读取JSON文件配置
 * @param {String} path json配置文件的绝对路径
 * @param {Function} callback 
 */
function getJSONFile(path,callback){
    fs.readFile(itempath + path, 'utf8', function (err1, JSONText) {
        if (err1)
            throw new Error("读取模板配置文件失败!");
        var JSONData = JSON.parse(JSONText)
        callback(JSONData)
    })
}

/**
 * 查询mysql 可用的连接配置
 * @param {Function} callback 
 */
function getMysqlJSON(callback){
    getJSONFile('/jsonConfig/mysqlConn.json',function(JSONData){
        var data = null;
        JSONData.forEach(x => {
            if (x.status == 1) {
                data = x
            }
        })
        callback(data)
    })
}
module.exports = {
    getMysqlJSON,getJSONFile
}