package com.jirawat.presidentlistrecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    private static final String TAG = "Presidents App";

    Button btn_ok, btn_cancle;
    List<President> presidentList;
    EditText et_presDate, et_presName, et_presImageURL;
    TextView tv_presId;
    int id;

    MyApplication myApplication = (MyApplication) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        presidentList = myApplication.getPresidentList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancle = findViewById(R.id.btn_cancel);
        et_presDate = findViewById(R.id.et_dateElection);
        et_presName = findViewById(R.id.et_presidentName);
        et_presImageURL = findViewById(R.id.et_pictureURL);
        tv_presId = findViewById(R.id.tv_presidentIdNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;

        if ( id >= 0) {
            // edit the president
            for (President p: presidentList) {
                if (p.getId() == id) {
                    president = p;
                }
            }
            et_presName.setText(president.getName());
            et_presDate.setText(String.valueOf(president.getDataOfElection()));
            et_presImageURL.setText(president.getImageURL());
            tv_presId.setText(String.valueOf(id));
        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id >= 0) {
                    // update
                    President updatePresident = new President(id, et_presName.getText().toString(), Integer.parseInt(et_presDate.getText().toString()), et_presImageURL.getText().toString());
                    presidentList.set(id, updatePresident);

                    // go back to main activity
                    Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // add new pres
                    if (!et_presName.getText().toString().equals("")) {
                        // create President objecta
                        int nextId = myApplication.getNextId();
                        President newPresident = new President(nextId, et_presName.getText().toString(), Integer.parseInt(et_presDate.getText().toString()), et_presImageURL.getText().toString());

                        // add the object to the global list of presidents.
                        presidentList.add(newPresident);
                        myApplication.setNextId(nextId++);

                        // go back to main activity
                        Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        // go back to main activity
                        Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }
}