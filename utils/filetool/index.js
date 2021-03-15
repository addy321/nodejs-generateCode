var fs = require('fs');

/**
 * 复制文件到指定目录下面
 * @param {string} formPath formPath为源路径
 * @param {string} toPath formPath为源路径
 */
function Copyfiles(formPath, toPath) {
    fs.readFile(formPath, 'utf-8', function (err, data) {
        if (err) {
            throw err;
        }
        fs.writeFile(toPath, data, 'utf-8', function (error) {
            if (error) {
                throw error;
            }
        });
    });
}


/**
 *  生成文件
 * @param {string} text 文件内容
 * @param {string} path 文件路径
 * @param {string} fileName 文件名
 * @param {string} suffix 文件后缀
 */
function createFile(text, path, fileName, suffix) {
    var filepath = path + "\\" + fileName + suffix;

    if (fsExistsSync(path) == false) {
        fs.mkdir(path, function (error) {
            if (error) {
                console.log(error);
                return false;
            }
        })
    }

    //3. fs.writeFile  写入文件（会覆盖之前的内容）（文件不存在就创建）  utf8参数可以省略  
    fs.writeFile(filepath, text, 'utf8', function (error) {
        if (error) {
            console.log(error);
            return false;
        }
        console.log('生成文件————>' + filepath);
    })
}
// 判断文件是否存在
function fsExistsSync(path) {
    try {
        fs.accessSync(path, fs.F_OK);
    } catch (e) {
        return false;
    }
    return true;
}
/**
 * 读取文件内容
 * @param {String} path 
 * @param {Function} callback 
 */
function getFile(path,callback){
    console.log(path)
    fs.readFile(path, 'utf8', function (err, text) {
        if (err){
            callback(err,text)
        }
        callback(err,text)
    })
}

module.exports = {
    createFile,Copyfiles,getFile
}