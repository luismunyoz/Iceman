package com.luismunyoz.iceman.ui.presenters;

import com.luismunyoz.iceman.ui.model.ListItem;

/**
 * Created by Luism on 02/04/2017.
 */

public interface MainPresenter {
    void onDestroy();
    void downloadCharacter();
    void downloadComics();
    void onClickItem(ListItem item);
}
