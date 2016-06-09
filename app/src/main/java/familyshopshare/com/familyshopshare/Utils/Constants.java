package familyshopshare.com.familyshopshare.Utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.firebase.client.Firebase;

/**
 * Created by Dan on 04/06/2016.
 */
public class Constants extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

    /*
     *  Firebase URL using the URL
    */
    public final static String FIREBASE_URL = "https://shoppinglistshare.firebaseio.com/";
    public final static String FIREBASE_URL_ACTIVE_LIST = "https://shoppinglistshare.firebaseio.com/activelist/";

    /*
    * List Shared Pref Name and Key saved to the phone
    */
    public final static String SHOPPINGLIST_PREF_NAME = "SHOPPINGLIST_PREF_NAME";
    public static final String SHOPPINGLIST_PREF_KEY = "AOP_PREFS_String";

    public final static String SHOPPINGLIST_PUSH_KEY_ID_PREF_NAME = "SHOPPINGLIST_PREF_NAME_PUSH_KEY_ID_";


}
