package com.luismunyoz.iceman.ui.presenters;

import android.os.Bundle;

/**
 * Created by Luism on 02/04/2017.
 */

public interface DetailPresenter {
    void onDestroy();
    void onHomePressed();
    void getExtras(Bundle extras);
}
