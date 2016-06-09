package familyshopshare.com.familyshopshare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import familyshopshare.com.familyshopshare.Activities.MainItemShoppingListActivity;
import familyshopshare.com.familyshopshare.Adapters.ShoppingListViewAdapter;
import familyshopshare.com.familyshopshare.Model.ShoppingList;
import familyshopshare.com.familyshopshare.Utils.Constants;

/**
 * Created by: Dan Maia
 * Date: 02/06/2016.
 * Version: 0.1
 */

public class ShoppingListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public CardView cv;
    public TextView name;
    public TextView description;
    private int lastPosition = -1;
    public static final String ITEM_NAME = "ITEM_NAME";
    ShoppingListViewAdapter mAdapter;

    public ShoppingListViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        name = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.mOwner);
        itemView.setOnClickListener(this);
    }

    /**
     * This controls on the onClick for the each item its selected
     */
    @Override
    public void onClick(View v) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new ShoppingList object and gets the mListName and mOwner of the item
                Context context = itemView.getContext();
                ShoppingList selectedItem = new ShoppingList(name.getText().toString(), description.getText().toString());

//                Toast.makeText(v.getContext(), "onClick " +  test, Toast.LENGTH_SHORT).show();

                Intent itemIntent = new Intent(context, MainItemShoppingListActivity.class);
                itemIntent.putExtra(ITEM_NAME,selectedItem.getmListName());
                context.startActivity(itemIntent);
            }
        });
    }


}
