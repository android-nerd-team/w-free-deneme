package com.example.recepinanc.whenfreedeneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by recepinanc on 08/10/15.
 */
public class LoginActivity extends Activity {

    public static final String EXTRA_WHO_IS_SELECTED = "com.example.recepinanc.whenfreedeneme.who";
    public static final String PASSWORD = "12012015";

    public static boolean isFirstWarn = true;

    private Switch seysSwitch;
    private Button loginButton;
    private EditText passwordEdit;
    private TextView wrongPassText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris_ekrani_layout);

        seysSwitch = (Switch) findViewById(R.id.seys_switch);
        loginButton = (Button) findViewById(R.id.login_button);
        passwordEdit = (EditText) findViewById(R.id.password_editText);
        wrongPassText = (TextView) findViewById(R.id.wrongPass_textView);
        wrongPassText.setText("");

        final Animation out = new AlphaAnimation(0.0f, 1.0f);
        out.setDuration(1000);

        final Animation in = new AlphaAnimation(1.0f, 0.0f);
        in.setDuration(5000);

/*

        final AnimationSet as = new AnimationSet(true);
        as.addAnimation(out);
        in.setStartOffset(3000);
        as.addAnimation(in);
*/

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i("Animation", "startta");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i("Animation", "repeatte");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("Animation", "enddeyiz");
                wrongPassText.setAnimation(in);
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
                        wrongPassText.setText(R.string.wrong_pass);
                        wrongPassText.startAnimation(out);
                    }
                    isFirstWarn = false;
                    Log.i("Animation", "çağırılıyor");
                    wrongPassText.startAnimation(out);
                }
            }
        });
    }
}