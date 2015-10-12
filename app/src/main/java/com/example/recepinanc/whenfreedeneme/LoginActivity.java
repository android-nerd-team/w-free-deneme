package com.example.recepinanc.whenfreedeneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

/**
 * Created by recepinanc on 08/10/15.
 */
public class LoginActivity extends Activity {

    public static final String EXTRA_WHO_IS_SELECTED = "com.example.recepinanc.whenfreedeneme.who";

    private Switch seysSwitch;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris_ekrani_layout);

        seysSwitch = (Switch) findViewById(R.id.seys_switch);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra(EXTRA_WHO_IS_SELECTED,seysSwitch.isChecked());
                startActivity(intent);
            }
        });

    }
}
