package com.ognimod.afterhours;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkIn extends AppCompatActivity {
    String newview;
    String SQLiteQuery;
    private Button layout, home;
    SQLiteDatabase SQLITEDATABASE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_in);

        home = findViewById(R.id.button2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();

            }


        });
    }

    public void backHome() {
        Intent intent = new Intent(this, newSignUp.class);
        startActivity(intent);
    }
}



        /**
        layout = findViewById(R.id.button);
        layout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBList();
            }
        });
    }
    public void DBList(){
        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);
        SQLiteQuery = ("SELECT * FROM demoTable;");
        SQLITEDATABASE.execSQL(SQLiteQuery);
    }**/




