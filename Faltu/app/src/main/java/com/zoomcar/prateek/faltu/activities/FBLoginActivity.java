package com.zoomcar.prateek.faltu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 22/09/15.
 */
public class FBLoginActivity extends AppCompatActivity {

    private LoginButton mLoginButton;
    private CallbackManager callbackManager;
    private Toolbar mToolbar;
    private View mProgressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_fb_login);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mProgressLayout = findViewById(R.id.progress_layout);
        mProgressLayout.setVisibility(View.GONE);

        mLoginButton = (LoginButton) findViewById(R.id.login_button);
        mLoginButton.setReadPermissions("user_friends");
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressLayout.setVisibility(View.VISIBLE);
            }
        });
        mLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (mProgressLayout != null) {
                    mProgressLayout.setVisibility(View.GONE);
                }
                AccessToken token = loginResult.getAccessToken();
                Toast.makeText(FBLoginActivity.this, token.getToken(), Toast.LENGTH_LONG).show();
                for (String permission : token.getPermissions()) {
                    Log.d("saini", "Permission :[" + permission + "]");
                }
                Log.d("saini", "Access token last refresh time :" + token.getLastRefresh());
                startActivity(new Intent(FBLoginActivity.this, CalendarActivity.class));
                finish();
            }

            @Override
            public void onCancel() {
                if (mProgressLayout != null) {
                    mProgressLayout.setVisibility(View.GONE);
                }
                Log.d("saini", "Login cancelled");
            }

            @Override
            public void onError(FacebookException e) {
                if (mProgressLayout != null) {
                    mProgressLayout.setVisibility(View.GONE);
                }
                Log.d("saini", "Exception while login : " + e);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
