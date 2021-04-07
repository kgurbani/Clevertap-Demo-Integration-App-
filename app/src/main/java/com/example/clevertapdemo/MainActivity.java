package com.example.clevertapdemo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.clevertap.android.sdk.CleverTapAPI;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    Button mButton;
    EditText t1, t2;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            t1 = (EditText)findViewById(R.id.editTextTextPersonName);
            t2 = (EditText)findViewById(R.id.editTextTextPersonName2);
            //initializing sdk
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        //Set Log level to DEBUG log warnings or other important messages
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        clevertapDefaultInstance.pushEvent("Product viewed");
            mButton = (Button)findViewById(R.id.button);
            mButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                    profileUpdate.put("Name", t1.getText());    // String
                    profileUpdate.put("Email",t2.getText()); // Email address of the user
                    CleverTapAPI.getDefaultInstance(getApplicationContext()).onUserLogin(profileUpdate);
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                }
            });

        }
}
