package familyshopshare.com.familyshopshare.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import familyshopshare.com.familyshopshare.Model.ShoppingList;
import familyshopshare.com.familyshopshare.Model.User;
import familyshopshare.com.familyshopshare.R;
import familyshopshare.com.familyshopshare.Adapters.ShoppingListViewAdapter;
import familyshopshare.com.familyshopshare.Utils.Constants;


/**
 * Created by Dan on 02/06/2016.
 */
public class MainShoppingListViewActivity extends AppCompatActivity {

    List<ShoppingList> list = new ArrayList<>();
    RecyclerView recyclerView;
    ShoppingListViewAdapter adapter;
    EditText listName;
    String mListID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_shoppinglist_view);
        Firebase.setAndroidContext(this);
        floatingActionButton();

        // Getting the recycler view, using the Recycler View
        recyclerView = (RecyclerView) findViewById(R.id.shopping_list_recycler_view);
        // The setLayoutManager which contains the main container where the Recycler View is contained
        recyclerView.setLayoutManager(new LinearLayoutManager(MainShoppingListViewActivity.this));

    }

    /**
    * This method is used to add a new item to the Recycler View
    */
    public void addNewShoppingListItem() {

        ShoppingList shoppingListObject = new ShoppingList();

        HashMap<String, Object> updatedListToAddMap = new HashMap<>();

        Firebase rootRef = new Firebase("https://shoppinglistshare.firebaseio.com/");
        Firebase ref = new Firebase("https://shoppinglistshare.firebaseio.com/").child("activelist");

        // From activelist it pushes a uniqe key the code below, as the key is the new child
        ref = ref.push();
        // get the key and assign it to listID string to use later.
        mListID = ref.getKey();

//        ref.child("Test").setValue("test");

        updatedListToAddMap.put("ListName", listName.getText().toString());
        updatedListToAddMap.put("Owner", "test");
//
        ref.updateChildren(updatedListToAddMap);


        adapter = new ShoppingListViewAdapter(list, MainShoppingListViewActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.addItem(new ShoppingList("test", "Created by: Me"));

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
        View rootView = inflater.inflate(R.layout.custom_alert_dialog, null);
        listName = (EditText) rootView.findViewById(R.id.ShoppinglistName);

        // Using the AlertDialog Builder created above as "builder" to set the view.
        builder.setView(rootView)
                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        String val = listName.getText().toString();

                        if (!val.isEmpty()) {
                            if(!list.contains(val)) {
                                addNewShoppingListItem();
                                Bundle bundle = new Bundle();

                            }

                        } else {
                            Toast.makeText(MainShoppingListViewActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                // Show the dialog
                .show();
    }

    /**
     * This method is used to get the current date and time stamp
     */
    public String currentDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("Europe/London"));

        return df.format(date);
    }

    public void floatingActionButton() {
        // Floating action bar initiated, background color is set and then onClickListener to act when the
        // button is pressed to which the createDialogBox(); method is called
        FloatingActionButton addFloat = (FloatingActionButton) findViewById(R.id.fab);
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


}


