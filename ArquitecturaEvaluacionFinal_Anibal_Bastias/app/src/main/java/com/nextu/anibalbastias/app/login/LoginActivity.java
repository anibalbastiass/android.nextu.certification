package com.nextu.anibalbastias.app.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.nextu.anibalbastias.app.R;
import com.nextu.anibalbastias.app.base.BaseActivity;
import com.nextu.anibalbastias.app.gallery.GalleryActivity;
import com.nextu.anibalbastias.app.util.UiUtils;

public class LoginActivity extends BaseActivity implements UiUtils.SnackBarListener {

    private LinearLayout llContainer;
    private EditText etUser;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setView();
    }

    private void setView() {
        llContainer = findViewById(R.id.ll_activity_login_container);
        etUser = findViewById(R.id.et_activity_login_user);
        etPassword = findViewById(R.id.et_activity_login_password);
    }

    // From bt_activity_login_forgot onClick
    public void forgotPassword(View view) {
        if (checkFields()) {
            UiUtils.showSnackBar(
                    llContainer,
                    getString(R.string.activity_login_forgot_snackbar_title),
                    getString(R.string.activity_login_forgot_snackbar_button),
                    this);
        } else {
            UiUtils.showToast(this, getString(R.string.activity_login_error_form));
        }
    }

    @Override
    public void onSnackBarClick(View view) {
        UiUtils.showToast(this, getString(R.string.activity_login_forgot_password_success));
    }

    // bt_activity_login_sign_in
    public void signIn(View view) {
        if (checkFields()) {
            UiUtils.startActivity(this, GalleryActivity.class);
        } else {
            UiUtils.showToast(this, getString(R.string.activity_login_error_form));
        }
    }

    private boolean checkFields() {
        boolean isValid = false;

        if (!etUser.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
            isValid = true;
        }

        return isValid;
    }
}
