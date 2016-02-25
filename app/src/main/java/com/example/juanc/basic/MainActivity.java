package com.example.juanc.basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.juanc.webservice.WebServiceUsage;
import com.loopj.android.http.*;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    public final  static String EXTRA_MESSAGE = "com.example.juanc.basic.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, Message.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void getDataWebService(View view) throws JSONException {

        WebServiceUsage webServiceUsage = new WebServiceUsage();
        webServiceUsage.getPosts();

    }
}
