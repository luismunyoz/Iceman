package com.luismunyoz.iceman.interactors;

import com.luismunyoz.iceman.model.Character;

/**
 * Created by Luism on 02/04/2017.
 */

public interface CharacterInteractor {

    interface CharacterInteractorCallback {
        void onCharacterDownloaded(Character character);
        void onCharacterDownloadError(Integer status, String error);
    }

    public void execute(String characterID, CharacterInteractorCallback callback);
}
