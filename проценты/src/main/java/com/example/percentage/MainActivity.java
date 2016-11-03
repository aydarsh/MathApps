package com.example.percentage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnPercent2Decimal, btnDecimal2Percent, btnFraction2Percent, btnPercentOfNumber, btnNumberFromPercent, btnPercentIncrease, btnPercentDecrease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPercent2Decimal = (Button) findViewById(R.id.btnPercent2Decimal);
        btnDecimal2Percent = (Button) findViewById(R.id.btnDecimal2Percent);
        btnFraction2Percent = (Button) findViewById(R.id.btnFraction2Percent);
        btnPercentOfNumber = (Button) findViewById(R.id.btnPercentOfNumber);
        btnNumberFromPercent = (Button) findViewById(R.id.btnNumberFromPercent);
        btnPercentIncrease = (Button) findViewById(R.id.btnPercentIncrease);
        btnPercentDecrease = (Button) findViewById(R.id.btnPercentDecrease);

        btnPercent2Decimal.setOnClickListener(this);
        btnDecimal2Percent.setOnClickListener(this);
        btnFraction2Percent.setOnClickListener(this);
        btnPercentOfNumber.setOnClickListener(this);
        btnNumberFromPercent.setOnClickListener(this);
        btnPercentIncrease.setOnClickListener(this);
        btnPercentDecrease.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPercent2Decimal:
                Intent percent2decimal = new Intent(this, percent2decimal.class);
                startActivity(percent2decimal);
                break;
            case R.id.btnDecimal2Percent:
                Intent decimal2percent = new Intent(this, decimal2percent.class);
                startActivity(decimal2percent);
                break;
            case R.id.btnFraction2Percent:
                Intent fraction2percent = new Intent(this, fraction2percent.class);
                startActivity(fraction2percent);
                break;
            case R.id.btnPercentOfNumber:
                Intent percentOfNumber = new Intent(this, percentofnumber.class);
                startActivity(percentOfNumber);
                break;
            case R.id.btnNumberFromPercent:
                Intent numberFromPercent = new Intent(this, numberfrompercent.class);
                startActivity(numberFromPercent);
                break;
            case R.id.btnPercentIncrease:
                Intent percentIncrease = new Intent(this, percentincrease.class);
                startActivity(percentIncrease);
                break;
            case R.id.btnPercentDecrease:
                Intent percentDecrease = new Intent(this, percentdecrease.class);
                startActivity(percentDecrease);
                break;

            default:
                break;
        }

    }
}
