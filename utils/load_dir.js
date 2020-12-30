/**
 * 读取指定目录下的js文件，并将js文件通过node.js的require方法进行导入，并存放在patcher变量下，
 * 利用__defineGetter__方法重新定义了了patcher的getter方法，当我们patcher.xx的时候，就会调用require的方法，动态读取对应目录下的模块。
 */

var load = function (path, name) {
    if (name) {
        return require(path + name);
    }
    return require(path)
};

module.exports = function (dir,type) {
    patcher = {}

    var _load = load.bind(process.cwd() + '\\templatefiles\\' + dir + '.js',null);
    // console.log(_load)
    // patcher.__defineGetter__(type, _load);
    return _load;
}