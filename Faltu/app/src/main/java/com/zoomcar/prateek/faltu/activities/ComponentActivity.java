package com.zoomcar.prateek.faltu.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zoomcar.prateek.faltu.R;

public class ComponentActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    private Toolbar mToolbar;
    private Button mSubmitButton;
    private EditText mFirstName;
    private EditText mLastName;
    private TextInputLayout mTextInputLayoutFirstName;
    private TextInputLayout mTextInputLayoutLastName;
    private boolean mIsAllFieldCorrect = true;
    private SpannableStringBuilder mSpannableStringBuilder;
    private String mWarning;
    private ForegroundColorSpan mFgcspan;
    private int mErrorColor;
    private View mViewFirstName;
    private View mViewLastName;
    private final String EMPTY_STRING = "";
    private boolean mIsFirstNameCorrect = true;
    private boolean mIsLastNameCorrect = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mFirstName = (EditText) findViewById(R.id.edit_first_name);
        mLastName = (EditText) findViewById(R.id.edit_last_name);
        mTextInputLayoutFirstName = (TextInputLayout) findViewById(R.id.text_input_layout);
        mTextInputLayoutLastName = (TextInputLayout) findViewById(R.id.text_input_layout2);
        mSubmitButton = (Button) findViewById(R.id.button_submit);
        mSubmitButton.setOnClickListener(this);
        mErrorColor = Color.GRAY;
        mFirstName.setOnFocusChangeListener(this);
        mLastName.setOnFocusChangeListener(this);
        mSubmitButton.setOnFocusChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_component, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_submit:
                if (mFirstName.getText().length() == 0) {
                    mViewFirstName = findViewById(R.id.edit_first_name);
                    final Drawable originalDrawable = mViewFirstName.getBackground();
                    final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                    DrawableCompat.setTint(wrappedDrawable, Color.RED);
                    mFgcspan = new ForegroundColorSpan(mErrorColor);
                    mWarning = getResources().getString(R.string.empty_first_name);
                    mSpannableStringBuilder = new SpannableStringBuilder(mWarning);
                    mSpannableStringBuilder.setSpan(mFgcspan, 0, mWarning.length(), 0);
                    mTextInputLayoutFirstName.setError(mSpannableStringBuilder);
                    mFirstName.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_action_username_red), null, null, null);
                    mIsFirstNameCorrect = false;
                } else {
                    if (!mFirstName.getText().toString().equalsIgnoreCase("shubham")) {
                        mFirstName.setTextColor(ContextCompat.getColor(this, R.color.error_color));
                        mViewFirstName = findViewById(R.id.edit_first_name);
                        final Drawable originalDrawable = mViewFirstName.getBackground();
                        final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                        DrawableCompat.setTint(wrappedDrawable, Color.RED);
                        mFgcspan = new ForegroundColorSpan(mErrorColor);
                        mWarning = getResources().getString(R.string.wrong_first_name);
                        mSpannableStringBuilder = new SpannableStringBuilder(mWarning);
                        mSpannableStringBuilder.setSpan(mFgcspan, 0, mWarning.length(), 0);
                        mTextInputLayoutFirstName.setError(mSpannableStringBuilder);
                        mFirstName.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_action_username_red), null, null, null);
                        mIsFirstNameCorrect = false;
                    } else {
                        mTextInputLayoutFirstName.setError(EMPTY_STRING);
                        mFirstName.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_action_username_normal), null, null, null);
                        mViewFirstName = findViewById(R.id.edit_first_name);
                        final Drawable originalDrawable = mViewFirstName.getBackground();
                        final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                        DrawableCompat.setTint(wrappedDrawable, Color.GREEN);
                        mFirstName.setTextColor(ContextCompat.getColor(this, R.color.default_text_color));
                        mIsFirstNameCorrect = true;
                    }
                }


                if (mLastName.getText().length() == 0) {
                    mViewLastName = findViewById(R.id.edit_last_name);
                    final Drawable originalDrawable = mViewLastName.getBackground();
                    final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                    DrawableCompat.setTint(wrappedDrawable, Color.RED);
                    mFgcspan = new ForegroundColorSpan(mErrorColor);
                    mWarning = getResources().getString(R.string.empty_last_name);
                    mSpannableStringBuilder = new SpannableStringBuilder(mWarning);
                    mSpannableStringBuilder.setSpan(mFgcspan, 0, mWarning.length(), 0);
                    mTextInputLayoutLastName.setError(mSpannableStringBuilder);
                    mLastName.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_action_username_red), null, null, null);

                } else {
                    if (!mLastName.getText().toString().equalsIgnoreCase("verma")) {
                        mLastName.setTextColor(getResources().getColor(R.color.error_color));
                        mFgcspan = new ForegroundColorSpan(mErrorColor);
                        mWarning = getResources().getString(R.string.wrong_last_name);
                        mSpannableStringBuilder = new SpannableStringBuilder(mWarning);
                        mSpannableStringBuilder.setSpan(mFgcspan, 0, mWarning.length(), 0);
                        mTextInputLayoutLastName.setError(mSpannableStringBuilder);
                        mLastName.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_action_username_red), null, null, null);
                        mViewLastName = findViewById(R.id.edit_last_name);
                        final Drawable originalDrawable = mViewLastName.getBackground();
                        final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                        DrawableCompat.setTint(wrappedDrawable, Color.RED);
                        mIsLastNameCorrect = false;
                    } else {
                        mTextInputLayoutLastName.setError(EMPTY_STRING);
                        mLastName.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_action_username_normal), null, null, null);
                        mViewLastName = findViewById(R.id.edit_last_name);
                        final Drawable originalDrawable = mViewLastName.getBackground();
                        final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                        DrawableCompat.setTint(wrappedDrawable, Color.GREEN);
                        mLastName.setTextColor(ContextCompat.getColor(this, R.color.default_text_color));
                        mIsLastNameCorrect = true;

                    }

                    if (mIsFirstNameCorrect && mIsLastNameCorrect) {
                        mViewLastName = findViewById(R.id.edit_last_name);
                        Drawable originalDrawable = mViewLastName.getBackground();
                        Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                        DrawableCompat.setTint(wrappedDrawable, Color.BLACK);
                        mViewFirstName = findViewById(R.id.edit_first_name);
                        originalDrawable = mViewFirstName.getBackground();
                        wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                        DrawableCompat.setTint(wrappedDrawable, Color.BLACK);

                        startActivity(new Intent(this, CustomProgressBarActivity.class));
                    }


                }


        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        switch (v.getId()) {
            case R.id.edit_first_name:
                if (hasFocus) {
                    final Drawable originalDrawable = v.getBackground();
                    final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                    DrawableCompat.setTint(wrappedDrawable, Color.GREEN);
                } else {
                    final Drawable originalDrawable = v.getBackground();
                    final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                    DrawableCompat.setTint(wrappedDrawable, Color.BLACK);
                }

                break;
            case R.id.edit_last_name:
                if (hasFocus) {
                    final Drawable originalDrawable = v.getBackground();
                    final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                    DrawableCompat.setTint(wrappedDrawable, Color.GREEN);
                } else {
                    final Drawable originalDrawable = v.getBackground();
                    final Drawable wrappedDrawable = DrawableCompat.wrap(originalDrawable);
                    DrawableCompat.setTint(wrappedDrawable, Color.BLACK);
                }
                break;
        }

    }
}
