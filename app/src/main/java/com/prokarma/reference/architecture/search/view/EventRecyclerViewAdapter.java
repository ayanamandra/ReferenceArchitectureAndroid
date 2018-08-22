package com.prokarma.reference.architecture.search.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * WIP
 */
public class EventRecyclerViewAdapter
        extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // TODO: WIP
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //TODO: WIP
    }

    @Override
    public int getItemCount() {
        // TODO: WIP
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTitleView;
        TextView mLocationView;
        TextView mDateView;
        ImageView mThumbnailView;


        ViewHolder(View view) {
            super(view);
            //TODO: WIP

        }
    }
}
