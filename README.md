# cordova-plugin-broadcast-retriever

This is a Cordova plugin to retrieve broadcast data in Android.

Example usage for calling the plugin:

      console.log('Calling broadcast retriever plugin... @ ' + Date());

      (<any>window).CordovaPluginBroadcastRetriever.retrieve("com.example.REQUEST_IDENTIFIER", 
           (data) => { 
             console.log("retrieved data: "+data + " @ "+Date());
           });


Notes:

 * Test this on a device (Cordova plugins aren't installed by default when run on a desktop).
 * Retrieved data can be "null" if the no broadcast with the specific identifier has been found.
 * Use chrome://inspect/ to see the device's console logs (example code includes timing stats on the retrieval).


References:

 * https://medium.com/ionic-and-the-mobile-web/how-to-write-cordova-plugins-864e40025f2
 * https://github.com/ionic-team/cordova-plugin-template/
 * https://github.com/bitstadium/HockeySDK-Cordova/
