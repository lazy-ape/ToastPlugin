package cordova.plugin.custoast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ToastPlugin extends CordovaPlugin {

   @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        String content = args.getString(0);
        if (action.equals("showShort")) {
            showShort(callbackContext,content);
            return true;
        }else if(action.equals("showLong")){
            showLong(callbackContext,content);
            return true;
        }
        return false;
    }

    private void showShort(final CallbackContext callbackContext,final String content){
        cordova.getActivity().runOnUiThread(new Runnable(){
            public void run(){
                Toast.makeText(cordova.getActivity(),content,Toast.LENGTH_SHORT).show();
                callbackContext.success();
            }
        });
    }

    private void showLong( final CallbackContext callbackContext, final String content){
        cordova.getActivity().runOnUiThread(new Runnable(){
            public void run(){
                Toast.makeText(cordova.getActivity(),content,Toast.LENGTH_LONG).show();
                callbackContext.success();
            }
        });
    }
}
