
var exec = require('cordova/exec');

var PLUGIN_NAME = 'CordovaPluginBroadcastRetriever';

var CordovaPluginBroadcastRetriever = {
  retrieve: function(identifier, cb) {
    exec(cb, null, PLUGIN_NAME, 'retrieve', [identifier]);
  }
};

module.exports = CordovaPluginBroadcastRetriever;
