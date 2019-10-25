package com.example.td_;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    public TextView t1;
    public String resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1 = findViewById(R.id.result_textview);
        resultText = getIntent().getStringExtra(LCOTextRecognization.RESULT_TEXT);
        DatabaseHelper db = new DatabaseHelper(this);
        t1.setText(resultText);
        Cursor cursor = db.getData(resultText);
        if(cursor != null && cursor.moveToFirst()) {
            String resultText1="";
            resultText1.concat("Vh number :"+ cursor.getString(0))



                    .concat("Name : "+cursor.getString(1));
            showMessage("Info","Vh number :"+ cursor.getString(0 )+"Name : "+cursor.getString(1));
        }
        else {
            Toast.makeText(this, "No match", Toast.LENGTH_SHORT).show();
        }
    }
    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
