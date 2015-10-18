package com.example.recepinanc.whenfreedeneme;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

import static com.example.recepinanc.whenfreedeneme.R.drawable;
import static com.example.recepinanc.whenfreedeneme.R.id;
import static com.example.recepinanc.whenfreedeneme.R.layout;
import static com.example.recepinanc.whenfreedeneme.R.string;

/**
 * Created by recepinanc on 08/10/15.
 */
public class LoginActivity extends Activity {

    public static final String EXTRA_WHO_IS_SELECTED = "com.example.recepinanc.whenfreedeneme.who";
    public static final String PASSWORD = "12012015";
    private static final String SAVE_WRONG = "com.example.wrong";

    public static boolean isFirstWarn = true;
    public static String wrongPassText;

    private Switch seysSwitch;
    private Button loginButton;
    private EditText passwordEdit;
    private TextView wrongPassTextView;

    private Drawable background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.giris_ekrani_layout);

        Random random = new Random();
        int randomNumber = random.nextInt(10);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(id.girisEkrani_relativeLayout);

        switch (randomNumber) {
            case 0:
                background = changeBg(drawable.bg_1);
                break;
            case 1:
                background = changeBg(drawable.bg_2);
                break;
            case 2:
                background = changeBg(drawable.bg_3);
                break;
            case 3:
                background = changeBg(drawable.bg_4);
                break;
            case 4:
                background = changeBg(drawable.bg_5);
                break;
            case 5:
                background = changeBg(drawable.bg_6);
                break;
            case 6:
                background = changeBg(drawable.bg_7);
                break;
            case 7:
                background = changeBg(drawable.bg_8);
                break;
            case 8:
                background = changeBg(drawable.bg_9);
                break;
            case 9:
                background = changeBg(drawable.bg_10);
                break;
            default:
                background = changeBg(drawable.splashscreen);
                break;
        }

        Log.i("number ", "" + randomNumber);
        Resources resources = getResources();
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            relativeLayout.setBackgroundDrawable(background);
        } else {
            relativeLayout.setBackground(background);
        }

        seysSwitch = (Switch) findViewById(id.seys_switch);
        loginButton = (Button) findViewById(id.login_button);
        passwordEdit = (EditText) findViewById(id.password_editText);
        wrongPassTextView = (TextView) findViewById(id.wrongPass_textView);
        wrongPassTextView.setText("");

        if (savedInstanceState != null) {
            wrongPassText = savedInstanceState.getString(SAVE_WRONG);
            wrongPassTextView.setText(wrongPassText);
        } else {
            wrongPassText = resources.getString(string.wrong_pass);
        }


        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(500);

        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(500);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //Found the problem !!
                //Before you start in, you should set it as animation of the TextView !!
                wrongPassTextView.setAnimation(in);
                wrongPassTextView.startAnimation(in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordEdit.getText().toString().equals(PASSWORD)) {
                    Log.i("LoginActivity", "passed the condition " + passwordEdit.getText().toString() + ".." + PASSWORD);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra(EXTRA_WHO_IS_SELECTED, seysSwitch.isChecked());
                    startActivity(intent);
                } else {
                    if (isFirstWarn) {
                        wrongPassTextView.setText(wrongPassText);
                    }
                    wrongPassTextView.startAnimation(out);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(SAVE_WRONG, wrongPassText);

    }

    public Drawable changeBg(int drawableID) {
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), drawableID);
        return drawable;
    }
}