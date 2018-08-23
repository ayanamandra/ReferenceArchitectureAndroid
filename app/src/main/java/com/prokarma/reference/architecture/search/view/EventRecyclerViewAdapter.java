package com.prokarma.reference.architecture.search.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prokarma.reference.architecture.databinding.ItemEventListBinding;
import com.prokarma.reference.architecture.model.Event;

/**
 * WIP
 */
public class EventRecyclerViewAdapter
        extends ListAdapter<Event, EventRecyclerViewAdapter.EventViewHolder> {

    protected EventRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<Event> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemEventListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), viewType, parent, false);

        return new EventViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        private final ItemEventListBinding mViewBinding;


        EventViewHolder(@NonNull ItemEventListBinding viewBinding) {
            super(viewBinding.getRoot());
            mViewBinding = viewBinding;
            //TODO: WIP
        }

        void bind(Event event) {
            mViewBinding.setEvent(event);
            //TODO: WIP
            mViewBinding.executePendingBindings();
        }
    }

    //TODO DiffUtil
}
