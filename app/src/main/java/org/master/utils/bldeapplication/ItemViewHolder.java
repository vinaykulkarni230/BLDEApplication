package org.master.utils.bldeapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gururaj on 7/28/2018.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name ;
    TextView dob;
    public ItemViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        name = itemView.findViewById(R.id.name);
        dob = itemView.findViewById(R.id.dob);

    }
}
