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
            callback(err1,null)
        var JSONData = JSON.parse(JSONText)
        callback(null,JSONData)
    })
}
/**
 *  写入JSON文件配置
 * @param {String} path 路径
 * @param {Object} data JSON字符
 */
function setJSONFile(path,data){
    var text = JSON.stringify(data)
    if(text == null || text == ''){
        throw err("内容不能为空")
    }
    fs.writeFile(itempath + path, text, 'utf8', (err) => {
        if (err) console.log(err);
    });
}

/**
 * 查询mysql 可用的连接配置
 * @param {Function} callback 
 */
function getSqlJSON(callback){
    getJSONFile('/jsonConfig/sqlConn.json',function(err,JSONData){
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
    getSqlJSON,getJSONFile,setJSONFile
}