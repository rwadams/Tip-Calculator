package com.example.rwadams.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends ActionBarActivity {
    double amtEntered;
    double tip;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText amount = (EditText) findViewById(R.id.txtEnterAmt);
        final RadioButton tenPercent = (RadioButton) findViewById(R.id.rad10);
        final RadioButton fifteenPercent = (RadioButton) findViewById(R.id.rad15);
        final RadioButton twentyPercent = (RadioButton) findViewById(R.id.rad20);
        final TextView tipResult = (TextView) findViewById(R.id.tipResult);
        final TextView totalResult = (TextView) findViewById(R.id.totalResult);
        Button calculate = (Button) findViewById(R.id.btnCalc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                amtEntered = Double.parseDouble(amount.getText().toString());
                DecimalFormat hundredth = new DecimalFormat("#.##");
                if(tenPercent.isChecked()){
                    tip = amtEntered*.10;
                    tipResult.setText("$" + hundredth.format(tip));
                }else if(fifteenPercent.isChecked()){
                    tip = amtEntered*.15;
                    tipResult.setText("$" + hundredth.format(tip));
                }else if(twentyPercent.isChecked()){
                    tip = amtEntered*.20;
                    tipResult.setText("$" + hundredth.format(tip));
                }else{
                    Toast.makeText(MainActivity.this,"Select tip percentage", Toast.LENGTH_LONG).show();
                }
                total = amtEntered + tip;
                totalResult.setText("$" + hundredth.format(total));
            }
        });
    }
}
