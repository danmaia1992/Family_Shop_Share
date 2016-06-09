package familyshopshare.com.familyshopshare.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.widget.LoginButton;

import familyshopshare.com.familyshopshare.R;

/**
 * Created by: Dan Maia
 * Date: 02/06/2016.
 * Version: 0.1
 * Purpose: This Activity will be used as a login section using the following sign in methods, Facebook, Google or username
 */

public class MainActivity extends Activity {

    // Used as a Login button at the moment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_main);

        LoginButton lgButton = (LoginButton) findViewById(R.id.fb_login);
        //lgButton.setBackgroundResource(R.drawable.icon);
        lgButton.setText("Login");
        lgButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);

        Button loginBt = (Button) findViewById(R.id.login_button);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainShoppingListViewActivity.class);
                startActivity(intent);

                //TODO: When the users signs in for the first time to send an email to that person.

            }
        });

    }

}
