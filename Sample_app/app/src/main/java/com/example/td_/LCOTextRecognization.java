package com.example.td_;


import android.app.Application;
import com.google.firebase.FirebaseApp;
public class LCOTextRecognization extends Application {
    String s1;
    public static  String RESULT_TEXT="RESULT_TEXT";
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}

