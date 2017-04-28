var exec = require('cordova/exec');
var toastplugin = {
    showShort: function(success, fail, content) {
        exec(success, fail, "toastplugin", "showShort", [content]);
    },
    showLong: function(success, fail, content) {
        exec(success, fail, "toastplugin", "showLong", [content]);
    }
};
module.exports = toastplugin;