package familyshopshare.com.familyshopshare.Model;

import android.app.Activity;

/**
 * Created by Dan on 02/06/2016.
 */
public class ShoppingList extends Activity {

    public String mListName;
    public String mOwner;

    public ShoppingList() {
    }

    public ShoppingList(String name, String mOwner) {
        this.mListName = name;
        this.mOwner = mOwner;
    }

    public String getmListName() {
        return mListName;
    }

    public String getmOwner() {
        return mOwner;
    }


}