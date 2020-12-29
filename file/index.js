var fs = require('fs');


function createFile(tableName, text, suffix, type) {
    var itemUrl = process.cwd() + "\\filedata\\" + type + "\\" + tableName + suffix;
    //1. fs.stat  检测是文件还是目录  fs.statSync()同步获取stats对象,通过返回值接收。

    //3. fs.writeFile  写入文件（会覆盖之前的内容）（文件不存在就创建）  utf8参数可以省略  
    // text = 写入的内容
    fs.writeFile(itemUrl, text, 'utf8', function (error) {
        if (error) {
            console.log(error);
            return false;
        }
        console.log('生成文件————>' + tableName + suffix);
    })
}

module.exports = {
    createFile
}