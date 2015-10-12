package com.example.recepinanc.whenfreedeneme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String EXTRA_BUTTON_ID = "com.example.recepinanc.whenfreedeneme.buttonid";

    private String who;
    private Button mSchoolButton;
    private Button mSocialButton;
    private Button mTodoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        who = getString(R.string.erkek_text);
        if (getIntent().getBooleanExtra(LoginActivity.EXTRA_WHO_IS_SELECTED, false)) {
            who = getString(R.string.disi_text);
        }

        Toast toast = Toast.makeText(getApplicationContext(), "Welcome" + who, Toast.LENGTH_SHORT);
        toast.show();

        mSchoolButton = (Button) findViewById(R.id.school_button);
        mSocialButton = (Button) findViewById(R.id.social_button);
        mTodoButton = (Button) findViewById(R.id.todo_button);

    }

    public void buttonClicked(View v) {
        int buttonID;
        int button = 0;
        buttonID = v.getId();
        Intent intent = new Intent(getApplicationContext(),WorksActivity.class);
        switch (buttonID) {
            case R.id.school_button :
                button = 1;
                Log.i("MainActivity","BUTTON ID 1");
                break;
            case R.id.social_button :
                button = 2;
                Log.i("MainActivity","BUTTON ID 2");
                break;
            case R.id.todo_button :
                button = 3;
                Log.i("MainActivity","BUTTON ID 3");
                break;
            default:
                Log.e("MainActivity","INVALID BUTTON ID");
                break;
        }

        if (button == 0) {
            Log.e("MainActivity","BUTTON NOT FOUND.It's 0 NOW.");
        }
        intent.putExtra(EXTRA_BUTTON_ID,button);
        startActivity(intent);
    }

}
