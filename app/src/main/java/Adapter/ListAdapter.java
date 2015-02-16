package Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Maii on 1/29/15.
 */
public class ListAdapter extends ArrayAdapter<String> {

        Context context;
        int layoutResourceId;
        ArrayList<String> data = null;
        Typeface tf;

        public ListAdapter(Context context, int layoutResourceId, ArrayList<String> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
            tf = Typeface.createFromAsset(context.getAssets(), "fonts/thaisanslite_r1.ttf");

        }
    }