package com.luismunyoz.iceman.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.luismunyoz.iceman.R;
import com.luismunyoz.iceman.dialogs.CustomAlertDialog;
import com.luismunyoz.iceman.global.GlobalFunctions;

/**
 * Created by luis on 02/04/17.
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    public void showInfoDialog(String message, String title, String confirm, Integer drawable) {
        CustomAlertDialog customAlertDialog = new CustomAlertDialog(this, title, message, confirm, null, drawable, null);
        customAlertDialog.show();
    }

    public void showErrorMessage(String message){
        showInfoDialog(message, getString(R.string.error), getString(R.string.ok), null);
    }

    public void showDialog(String message, String title, String confirm, String cancel, Integer drawable, CustomAlertDialog.ConfirmAlertDialogListener listener) {
        CustomAlertDialog customAlertDialog = new CustomAlertDialog(this, title, message, confirm, cancel, drawable, listener);
        customAlertDialog.show();
    }

    public void openActivity(Intent i, Bundle b){
        if(GlobalFunctions.isAboveLollipop()){
            startActivity(i, b);
        } else {
            startActivity(i);
        }
    }

    public void openActivityForResult(Intent i, int requestCode, Bundle b){
        if(GlobalFunctions.isAboveLollipop()){
            startActivityForResult(i, requestCode, b);
        } else {
            startActivityForResult(i,requestCode);
        }
    }

    public void showProgressDialog(){
        showProgressDialog(getString(R.string.loading));
    }

    public void showProgressDialog(String message){
        if(progressDialog != null){
            progressDialog.setMessage(message);
            if(!progressDialog.isShowing()){
                progressDialog.show();
            }
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
    }

    public void hideProgressDialog(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
