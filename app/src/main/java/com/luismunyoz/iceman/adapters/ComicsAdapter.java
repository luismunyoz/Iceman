package com.luismunyoz.iceman.adapters;

import com.luismunyoz.iceman.model.Comic;
import com.luismunyoz.iceman.ui.model.ListItem;
import com.luismunyoz.iceman.ui.presenters.MainPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luism on 02/04/2017.
 */

public class ComicsAdapter extends BaseAdapter {

    private List<ListItem> items;
    private final int layout;
    private MainPresenter presenter;

    public ComicsAdapter(int layout, MainPresenter presenter) {
        this.layout = layout;
        this.presenter = presenter;
        this.items = new ArrayList<>();
    }

    @Override
    protected Object getItemForPosition(int position) {
        if (items.size() > position) {
            return items.get(position);
        }
        return null;
    }

    @Override
    protected Object getPresenter() {
        return presenter;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layout;
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setComics(List<Comic> comics){
        this.items.clear();
        for (Comic comic : comics) {
            ListItem localItem = new ListItem(comic.getId(), comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension(), comic.getTitle());
            this.items.add(localItem);
        }
        notifyDataSetChanged();
    }
}
