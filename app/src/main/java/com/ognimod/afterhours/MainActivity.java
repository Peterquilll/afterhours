package com.ognimod.afterhours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button check_button;
    private Button sign_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**check_button = findViewById(R.id.checkIn);*/
        sign_button = findViewById(R.id.signUp123);

        /**check_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity3();
            }

        });*/
        sign_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity2();
            }

        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, newSignUp.class);
        startActivity(intent);
    }
    /**public void openActivity3() {
        Intent intent = new Intent(this, checkIn.class);
        startActivity(intent);
    }*/
}
