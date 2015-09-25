package com.zoomcar.prateek.faltu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.zoomcar.prateek.faltu.R;

import java.util.Arrays;

/**
 * Created by Prateek on 22/09/15.
 */
public class TestFBLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonLogin;
    private CallbackManager mCallbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_test_fb_login);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(TestFBLoginActivity.this, "Logged in", Toast.LENGTH_LONG).show();
                startActivity(new Intent(TestFBLoginActivity.this, CalendarActivity.class));
                finish();
            }

            @Override
            public void onCancel() {
                Toast.makeText(TestFBLoginActivity.this, "Login Cancelled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(TestFBLoginActivity.this, "Error while logggin in", Toast.LENGTH_LONG).show();
                Log.d("saini", "Exception occurred: " + error);
            }
        });
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
