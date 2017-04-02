package com.luismunyoz.iceman.global;

import android.os.Build;

/**
 * Created by luis on 02/04/17.
 */

public class GlobalFunctions {

    public static boolean isAboveLollipop(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

}
