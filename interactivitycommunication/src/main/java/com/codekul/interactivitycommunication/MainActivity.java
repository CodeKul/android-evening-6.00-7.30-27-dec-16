package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAmt = (EditText) findViewById(R.id.edtAmt);

        findViewById(R.id.btnNext).setOnClickListener(v -> goNext());
    }

    private void goNext() {

        Bundle bundle = new Bundle();
        bundle.putString(Const.KEY_AMT,edtAmt.getText().toString());

        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtras(bundle);

        //startActivity(intent);
        startActivityForResult(intent,Const.REQ_NEXT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Const.REQ_NEXT) {
            if(resultCode == RESULT_OK) {
                Bundle nextData = data.getExtras();

                String amt = nextData.getString(Const.KEY_RESULT);
                ((EditText)findViewById(R.id.edtAmt)).setText(amt);
            }
        }
    }
}
