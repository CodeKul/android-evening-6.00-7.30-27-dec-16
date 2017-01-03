package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Dictionary;

public class NextActivity extends AppCompatActivity {

    private String amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        amt = bundle.getString(Const.KEY_AMT);

        ((TextView)findViewById(R.id.textAmt)).setText(amt);

        findViewById(R.id.btnBack).setOnClickListener(v -> goBack());

        ((RadioButton)findViewById(R.id.radioINR))
                .setOnCheckedChangeListener(this::onINR);

        ((RadioButton)findViewById(R.id.radioUSD))
                .setOnCheckedChangeListener(this::onUSD);

        ((RadioButton)findViewById(R.id.radioPOUNDS))
                .setOnCheckedChangeListener(this::onPounds);
    }

    private void onPounds(CompoundButton compoundButton, boolean b) {

        if(b) {
            ((TextView) findViewById(R.id.textAmt)).setText(convert(Integer.parseInt(amt), "POUNDS"));
        }
    }

    private void onUSD(CompoundButton compoundButton, boolean b) {
        if(b) {
            ((TextView) findViewById(R.id.textAmt)).setText(convert(Integer.parseInt(amt), "USD"));
        }
    }

    private void onINR(CompoundButton compoundButton, boolean b) {
        if(b) {
            ((TextView) findViewById(R.id.textAmt)).setText(convert(Integer.parseInt(amt), "INR"));
        }
    }

    private void goBack() {
        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        bundle.putString(Const.KEY_RESULT, ((TextView)findViewById(R.id.textAmt)).getText().toString());
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }

    private String convert(int amt , String currency) {
        if(currency.equals("INR")) return  String.valueOf(amt);
        if(currency.equals("USD")) return String.valueOf(amt * 67);
        if(currency.equals("POUNDS")) return String.valueOf(amt  * 100);

        return String.valueOf(amt);
     }
}
