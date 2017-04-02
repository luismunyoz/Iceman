package com.luismunyoz.iceman.ui.presenters;

import android.content.Intent;
import android.os.Build;

import com.luismunyoz.iceman.BuildConfig;
import com.luismunyoz.iceman.interactors.CharacterInteractor;
import com.luismunyoz.iceman.interactors.CharacterInteractorImpl;
import com.luismunyoz.iceman.interactors.ComicsInteractor;
import com.luismunyoz.iceman.interactors.ComicsInteractorImpl;
import com.luismunyoz.iceman.model.Character;
import com.luismunyoz.iceman.model.Comic;
import com.luismunyoz.iceman.ui.model.ListItem;
import com.luismunyoz.iceman.ui.views.MainView;

import java.util.List;

/**
 * Created by Luism on 02/04/2017.
 */

public class MainPresenterImpl implements MainPresenter, CharacterInteractor.CharacterInteractorCallback, ComicsInteractor.ComicsInteractorCallback {

    private MainView mainView;
    private Character character;
    private List<Comic> comics;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        downloadCharacter();
    }

    @Override
    public void onDestroy() {
        this.mainView = null;
    }

    @Override
    public void downloadCharacter() {
        CharacterInteractorImpl characterInteractor = new CharacterInteractorImpl();
        characterInteractor.execute(BuildConfig.CHARACTER_ID, this);
        if (mainView != null) {
            mainView.showProgressDialog();
        }
    }

    @Override
    public void downloadComics() {
        ComicsInteractorImpl comicsInteractor = new ComicsInteractorImpl();
        comicsInteractor.execute(BuildConfig.CHARACTER_ID, this);
    }

    @Override
    public void onCharacterDownloaded(Character character) {
        if (mainView != null) {
            mainView.hideProgressDialog();
            mainView.populateCharacter(character);
        }
        downloadComics();
    }

    @Override
    public void onCharacterDownloadError(Integer status, String error) {
        if (mainView != null) {
            mainView.hideProgressDialog();
            mainView.showErrorMessage(error);
        }
    }

    @Override
    public void onComicsDownloaded(List<Comic> comics) {
        this.comics = comics;
        if (mainView != null) {
            mainView.populateComics(comics);
        }
    }

    @Override
    public void onComicsDownloadError(Integer status, String error) {
        if (mainView != null) {
            mainView.showErrorMessage(error);
        }
    }

    @Override
    public void onClickItem(ListItem item) {
        if (mainView != null) {
            for (Comic comic : comics) {
                if (comic.getId().equals(item.getId())) {
                    mainView.goToComicDetail(comic);
                    break;
                }
            }
        }
    }
}
