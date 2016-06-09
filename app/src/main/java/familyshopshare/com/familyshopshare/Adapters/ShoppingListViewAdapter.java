package familyshopshare.com.familyshopshare.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import java.util.Collections;
import java.util.List;

import familyshopshare.com.familyshopshare.Model.ShoppingList;
import familyshopshare.com.familyshopshare.R;
import familyshopshare.com.familyshopshare.ShoppingListViewHolder;

/**
 * Created by Dan on 02/06/2016.
 */
public class ShoppingListViewAdapter extends RecyclerView.Adapter<ShoppingListViewHolder> {

    List<ShoppingList> list = Collections.emptyList();
    Context context;
    private final static int FADE_DURATION = 1000;

    // Constructor with the arguments with the List array containing array of ShoppingList objects.
    public ShoppingListViewAdapter(List<ShoppingList> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        ShoppingListViewHolder holder = new ShoppingListViewHolder(v);
        return holder;
    }

    // Called by RecyclerView to display the data at the specified position. This method should update the contents of the
    // itemView to reflect the item at the given position.
    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, int position) {
        holder.name.setText(list.get(position).mListName);
        holder.description.setText(list.get(position).mOwner);
        setFadeAnimation(holder.itemView);

    }

    // Returns the total number of items in the data set hold by the adapter.
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Adds items to the List ShoppingList object array
    public void addItem(ShoppingList item) {
        list.add(item);
        notifyDataSetChanged();
    }

    // Adds items to the List ShoppingList object array
    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, list.size());
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }



}
