package com.prokarma.reference.architecture.feature.search.event_list;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
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

    private EventListener mEventListener;
    private LifecycleOwner mLifecycleOwner;

    protected EventRecyclerViewAdapter(EventListener eventListener, LifecycleOwner lifecycleOwner) {
        super(DIFF_CALLBACK);
        mEventListener = eventListener;
        mLifecycleOwner = lifecycleOwner;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemEventListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), viewType, parent, false);

        return new EventViewHolder(binding, mEventListener, mLifecycleOwner);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {

        @NonNull
        private final ItemEventListBinding mViewBinding;
        private final EventListener mEventListener;
        private final LifecycleOwner mLifecycleOwner;

        EventViewHolder(@NonNull ItemEventListBinding viewBinding,
                        @NonNull EventListener eventListener,
                        @NonNull LifecycleOwner lifecycleOwner) {
            super(viewBinding.getRoot());
            mViewBinding = viewBinding;
            mLifecycleOwner = lifecycleOwner;
            mEventListener = eventListener;
        }

        void bind(Event event) {
            mViewBinding.setEvent(event);
            mViewBinding.setEventListener(mEventListener);
            mViewBinding.setLifecycleOwner(mLifecycleOwner);
            mViewBinding.executePendingBindings();
        }
    }

    private static final DiffUtil.ItemCallback<Event> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Event>() {
        @Override
        public boolean areItemsTheSame(Event oldItem, Event newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(Event oldItem, Event newItem) {
            return oldItem == newItem;
        }
    };
}
