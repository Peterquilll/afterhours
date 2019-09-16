package com.ognimod.afterhours;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newSignUp extends Activity {

    EditText GetFirstName, GetLastName, GetSchool, GetPhoneNumber, GetBirthday, GetGrade;
    Button Submit ;
    String firstName, lastName, school, PhoneNumber, birthday, grade ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_sign_up);
        GetFirstName = (EditText)findViewById(R.id.firstName);
        GetLastName = (EditText) findViewById(R.id.lastName);
        GetSchool = (EditText) findViewById(R.id.school);
        GetPhoneNumber = (EditText)findViewById(R.id.phone);
        GetBirthday = (EditText)findViewById(R.id.birthday);
        GetGrade = (EditText) findViewById(R.id.grade);
        Submit = (Button)findViewById(R.id.button1);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });

    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, first_name VARCHAR, last_name VARCHAR, " +
                "school VARCHAR, phone_number INT, birthday INT, grade INT);");
    }

    public void SubmitData2SQLiteDB(){

        firstName = GetFirstName.getText().toString();
        lastName = GetLastName.getText().toString();
        school = GetSchool.getText().toString();
        PhoneNumber = GetPhoneNumber.getText().toString();
        birthday = GetBirthday.getText().toString();
        grade = GetGrade.getText().toString();

        CheckEditTextIsEmptyOrNot( firstName, lastName, school);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO demoTable (first_name, last_name, school, phone_number, birthday, grade) VALUES('"+firstName+"','"+lastName+"','"+school+"', '"+PhoneNumber+"', '"+birthday+"', '"+grade+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(this,"Data Submit Successfully", Toast.LENGTH_LONG).show();
            ClearEditTextAfterDoneTask();

            Intent intent = new Intent(this, checkIn.class);
            startActivity(intent);

        }
        else {

            Toast.makeText(this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String firstName,String lastName, String school ){

        if(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(school)){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }
    public void ClearEditTextAfterDoneTask(){

        GetFirstName.getText().clear();
        GetLastName.getText().clear();
        GetSchool.getText().clear();
        GetPhoneNumber.getText().clear();
        GetBirthday.getText().clear();
        GetGrade.getText().clear();

    }
}