package familyshopshare.com.familyshopshare.Activities;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import familyshopshare.com.familyshopshare.Model.ShoppingList;
import familyshopshare.com.familyshopshare.R;
import familyshopshare.com.familyshopshare.Utils.Constants;

/**
 * Created by Dan on 06/06/2016.
 */
public class MainItemShoppingListActivity extends AppCompatActivity {

    List<ShoppingList> list = new ArrayList<>();
    EditText mItemName;
    String mItemNameFromIntent;
    String mListID;
    public static final String ITEM_NAME = "ITEM_NAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_shoppinglist_view);
        mItemNameFromIntent = getIntent().getStringExtra(ITEM_NAME);
        getSupportActionBar().setTitle(mItemNameFromIntent);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        floatAddItemButton();


        Firebase mActiveListRef = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);

        mActiveListRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    /**
     * This method is called inside the float action bar to create a dialog box when the floating action button is pressed.
     */
    public void createDialogBox() {

        // Alert Dialog Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Using Layout Inflater class and assigned to a variable and using getLayout
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout.
        // Using the view class to inflate the layout.
        View rootView = inflater.inflate(R.layout.item_custom_alert_dialog, null);
        mItemName = (EditText) rootView.findViewById(R.id.ItemShoppinglistName);

        // Using the AlertDialog Builder created above as "builder" to set the view.
        builder.setView(rootView)
                .setPositiveButton("Add item", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Positive
                        //TODO: Here is where input mListName is then added to the item of items to the list
                    }
                }).setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // Cancel Button
                    }
                })
                // Show the dialog
                .show();
    }

    /**
     * This method is called to the float add button to item to the list
     */
    public void floatAddItemButton() {
        // Floating action bar initiated, background color is set and then onClickListener to act when the
        // button is pressed to which the createDialogBox(); method is called
        FloatingActionButton addFloat = (FloatingActionButton) findViewById(R.id.item_fab);
        addFloat.setBackgroundTintList(ColorStateList.valueOf(Color
                .parseColor("#3F51B5")));
        addFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                createDialogBox();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
