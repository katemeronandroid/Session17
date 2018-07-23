package com.emarkova.session17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ActivityCreate extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    public void onSave(View view) {
        String result = ((EditText)findViewById(R.id.editText)).getText().toString();
        result = result + " " + ((EditText)findViewById(R.id.editText2)).getText().toString();
        result = result + " " + ((EditText)findViewById(R.id.editText3)).getText().toString();
        DataManager manager = new DataManager(ActivityCreate.this);
        manager.setUser(result);
        Intent intent = new Intent(ActivityCreate.this, MainActivity.class);
        startActivity(intent);
    }
}
