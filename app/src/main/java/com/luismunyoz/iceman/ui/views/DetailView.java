package com.luismunyoz.iceman.ui.views;

import com.luismunyoz.iceman.model.Comic;

/**
 * Created by Luism on 02/04/2017.
 */

public interface DetailView {
    void showProgressDialog();
    void hideProgressDialog();
    void showErrorMessage(String error);
    void populateComic(Comic comic);
    void finish();
}
