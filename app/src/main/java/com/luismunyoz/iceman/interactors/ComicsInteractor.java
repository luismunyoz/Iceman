package com.luismunyoz.iceman.interactors;

import com.luismunyoz.iceman.model.Character;
import com.luismunyoz.iceman.model.Comic;

import java.util.List;

/**
 * Created by Luism on 02/04/2017.
 */

public interface ComicsInteractor {

    interface ComicsInteractorCallback {
        void onComicsDownloaded(List<Comic> comics);
        void onComicsDownloadError(Integer status, String error);
    }

    public void execute(String characterID, ComicsInteractorCallback callback);
}
