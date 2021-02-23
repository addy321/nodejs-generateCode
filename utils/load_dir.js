/**
 * 读取指定目录下的js文件，并将js文件通过node.js的require方法进行导入，并存放在patcher变量下，
 * 利用__defineGetter__方法重新定义了了patcher的getter方法，当我们patcher.xx的时候，就会调用require的方法，动态读取对应目录下的模块。
 */
var fs = require('fs');

var load = function (path, name) {
    if (name) {
        return require(path + name);
    }
    return require(path)
};

module.exports = function (dir) {
    var url = process.cwd() +"\\"+ dir + '.js'
    return new Promise(
        (complete, fail) =>
            fs.access(url, fs.R_OK | fs.W_OK, (err) =>
                err ? fail(err) : complete(load(url, null))))
    // return new Promise((resolve, reject) => {
    //     // 检查文件是否可读。
    //     fs.exists(url, (exists) => {
    //         //console.log(`${url} ${exists ? '存在' : '不存在'}`);
    //         if (exists) {
    //             var _load = load(url, null);
    //             resolve(result)
    //             return _load;
    //         } else {
    //             reject(err)
    //             return null;
    //         }
    //     });
    // });



}