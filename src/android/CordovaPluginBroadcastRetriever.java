import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.app.Activity;

import java.util.Date;


public class CordovaPluginBroadcastRetriever extends CordovaPlugin {

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    if(action.equals("retrieve")) {
      String identifier = args.getString(0);

      Intent userIdRetrievalIntent = new Intent();
      userIdRetrievalIntent.setAction(identifier);

      BroadcastReceiver userIdResultReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

          final PluginResult result = new PluginResult(PluginResult.Status.OK, this.getResultData());
          callbackContext.sendPluginResult(result);

        }
      };
      
      this.cordova.getActivity().getApplicationContext().sendOrderedBroadcast(userIdRetrievalIntent, null,
        userIdResultReceiver, null, Activity.RESULT_OK, null, null);

    } 

    return true;
  }

}
