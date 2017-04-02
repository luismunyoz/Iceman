package com.luismunyoz.iceman;

import android.app.Application;

import com.luismunyoz.iceman.webservices.IcemanService;
import com.luismunyoz.iceman.webservices.WebServices;

/**
 * Created by luis on 02/04/17.
 */

public class IcemanApplication extends Application {

    private static IcemanApplication instance;
    private static IcemanService service;

    @Override
    public void onCreate() {
        super.onCreate();

        if (instance == null) {
            instance = this;
        }

        if (service == null) {
            WebServices webServices = new WebServices(this);
            service = webServices.getService();
        }
    }

    public static IcemanApplication getInstance() {
        return instance;
    }

    public static IcemanService getService() {
        return service;
    }
}
