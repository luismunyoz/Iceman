package com.luismunyoz.iceman.ui.presenters;

import android.os.Bundle;

import com.luismunyoz.iceman.activities.DetailActivity;
import com.luismunyoz.iceman.model.Comic;
import com.luismunyoz.iceman.ui.views.DetailView;

/**
 * Created by Luism on 02/04/2017.
 */

public class DetailPresenterImpl implements DetailPresenter {

    private DetailView detailView;
    private Comic comic;

    public DetailPresenterImpl(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void onDestroy() {
        this.detailView = null;
    }

    @Override
    public void onHomePressed() {
        if(detailView != null){
            detailView.finish();
        }
    }

    @Override
    public void getExtras(Bundle extras) {
        comic = (Comic) extras.getSerializable(DetailActivity.ARG_COMIC);
        if(detailView != null && comic != null){
            detailView.populateComic(comic);
        }
    }
}
