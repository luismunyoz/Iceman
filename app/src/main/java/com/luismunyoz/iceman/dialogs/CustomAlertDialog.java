package com.luismunyoz.iceman.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.luismunyoz.iceman.R;

/**
 * Created by Luis on 02/04/17.
 */
public class CustomAlertDialog extends Dialog implements View.OnClickListener {

    private Button cancelButton, confirmButton;
    private TextView titleTextView, messageTextView;
    private View header;
    private ImageView icon;

    private Integer drawable;
    private String title, message, cancel, confirm;
    private ConfirmAlertDialogListener listener;

    public CustomAlertDialog(Context context, String title, String message, String confirm, String cancel, Integer drawable, ConfirmAlertDialogListener listener) {
        super(context);
        this.title = title;
        this.message = message;
        this.listener = listener;
        this.drawable = drawable;
        this.confirm = confirm;
        this.cancel = cancel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_custom_alert_dialog);

        titleTextView = (TextView) findViewById(R.id.confirm_dialog_title);
        messageTextView = (TextView) findViewById(R.id.confirm_dialog_message);
        cancelButton = (Button) findViewById(R.id.confirm_dialog_btn_cancel);
        confirmButton = (Button) findViewById(R.id.confirm_dialog_btn_confirm);
        header = findViewById(R.id.confirm_dialog_header);
        icon = (ImageView) findViewById(R.id.confirm_dialog_icon);

        if(cancel != null) {
            cancelButton.setText(cancel);
            cancelButton.setOnClickListener(this);
        } else {
            cancelButton.setVisibility(View.GONE);
        }
        if(confirm != null) {
            confirmButton.setText(confirm);
            confirmButton.setOnClickListener(this);
        } else {
            confirmButton.setVisibility(View.GONE);
        }

        if (title != null) {
            titleTextView.setText(title);
        } else {
            titleTextView.setVisibility(View.GONE);
        }

        if (message != null){
            messageTextView.setText(Html.fromHtml(message));
        } else {
            messageTextView.setVisibility(View.GONE);
        }

        if(drawable != null) {
            header.setVisibility(View.VISIBLE);
            icon.setImageResource(drawable);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm_dialog_btn_cancel:
                if (listener != null) {
                    listener.onDismissPressed();
                }
                dismiss();
                break;
            case R.id.confirm_dialog_btn_confirm:
                if(listener != null){
                    listener.onConfirmPressed();
                }
                dismiss();
                break;
            default:
                break;
        }
    }

    public interface ConfirmAlertDialogListener {
        void onConfirmPressed();
        void onDismissPressed();
    }
}
