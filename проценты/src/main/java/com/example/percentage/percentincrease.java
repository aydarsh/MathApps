package com.example.percentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class percentincrease extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> alExercises;
    ArrayAdapter<String> adapter;
    Button btnFind;
    EditText etNum1, etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentincrease);

        btnFind = (Button) findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        ListView lvExercises = (ListView) findViewById(R.id.lvExercises);
        alExercises = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alExercises);
        lvExercises.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFind:
                String strNumber1, strNumber2, strExercise;
                strNumber1 = etNum1.getText().toString();
                strNumber2 = etNum2.getText().toString();
                if (TextUtils.isEmpty(strNumber1) || TextUtils.isEmpty(strNumber2)) break;

                BigDecimal num1 = new BigDecimal(strNumber1);
                BigDecimal num2 = new BigDecimal(strNumber2);

                DecimalFormat formatter = new DecimalFormat("#.############");
                String strIncrease = formatter.format(num2.add(new BigDecimal("100")).multiply(new BigDecimal("0.01")));
                BigDecimal result = num1.multiply(num2.add(new BigDecimal("100"))).multiply(new BigDecimal("0.01"));
                String strResult = formatter.format(result.doubleValue());
                String strNum1 = formatter.format(num1.doubleValue());
                String strNum2 = formatter.format(num2.doubleValue());
                String strNum2dividedBy100 = formatter.format(num2.multiply(new BigDecimal("0.01")).doubleValue());

                strExercise = String.format("%s + %s%%. \nx = %s * (1 + %s) = %s * %s = %s",
                        strNum1, strNum2, strNum1, strNum2dividedBy100, strNum1, strIncrease, strResult);
                alExercises.add(0, strExercise);
                adapter.notifyDataSetChanged();
                etNum1.getText().clear();
                etNum2.getText().clear();
                etNum1.requestFocus();

                break;
            default:
                break;
        }
    }
}
