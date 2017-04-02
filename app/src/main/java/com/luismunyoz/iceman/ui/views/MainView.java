package com.luismunyoz.iceman.ui.views;

import com.luismunyoz.iceman.model.Character;
import com.luismunyoz.iceman.model.Comic;

import java.util.List;

/**
 * Created by Luism on 02/04/2017.
 */

public interface MainView {
    void showProgressDialog();
    void hideProgressDialog();
    void showErrorMessage(String error);
    void populateCharacter(Character character);
    void populateComics(List<Comic> comics);
    void goToComicDetail(Comic comic);
}
