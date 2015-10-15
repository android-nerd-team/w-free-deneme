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

    private Drawable[] backgrounds = new Drawable[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris_ekrani_layout);

        //todo Add new drawables lens blured pictures of us.
        backgrounds[0] = ContextCompat.getDrawable(getApplicationContext(), R.drawable.splashscreen);
        backgrounds[1] = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_launcher);

        Random random = new Random();
        int randomNumber = random.nextInt(2);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.girisEkrani_relativeLayout);

        Log.i("number ", "" + randomNumber);
        Resources resources = getResources();
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            relativeLayout.setBackgroundDrawable(backgrounds[randomNumber]);
        } else {
            relativeLayout.setBackground(backgrounds[randomNumber]);
        }

        seysSwitch = (Switch) findViewById(R.id.seys_switch);
        loginButton = (Button) findViewById(R.id.login_button);
        passwordEdit = (EditText) findViewById(R.id.password_editText);
        wrongPassTextView = (TextView) findViewById(R.id.wrongPass_textView);
        wrongPassTextView.setText("");

        if (savedInstanceState != null) {
            wrongPassText = savedInstanceState.getString(SAVE_WRONG);
            wrongPassTextView.setText(wrongPassText);
        } else {

            wrongPassText = resources.getString(R.string.wrong_pass);

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
}