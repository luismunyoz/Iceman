package com.luismunyoz.iceman.adapters;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luismunyoz.iceman.BR;


public class MyViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public MyViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object item, Object presenter) {
        binding.setVariable(BR.item, item);
        binding.setVariable(BR.presenter, presenter);
        binding.executePendingBindings();
    }

    @BindingAdapter("app:srcCompat")
    public static void setImage(ImageView imageView, int resourceId) {
        Drawable drawable = VectorDrawableCompat.create(imageView.getResources(), resourceId, imageView.getContext().getTheme());
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter("app:srcCompat")
    public static void setImage(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }
}