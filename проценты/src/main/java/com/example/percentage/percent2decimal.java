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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class percent2decimal extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> alExercises;
    ArrayAdapter<String> adapter;
    Button btnFind;
    EditText etPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent2decimal);

        btnFind = (Button) findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);

        etPercent = (EditText) findViewById(R.id.etPercent);

        ListView lvExercises = (ListView) findViewById(R.id.lvExercises);
        alExercises = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alExercises);
        lvExercises.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFind:
                String strNumber, strExercise;
                strNumber = etPercent.getText().toString();
                if (TextUtils.isEmpty(strNumber)) break;

                BigDecimal num = new BigDecimal(strNumber);

                BigDecimal result = num.multiply(new BigDecimal("0.01"));
                DecimalFormat formatter = new DecimalFormat("#.################");
                String strResult = formatter.format(result.doubleValue());
                String strNum = formatter.format(Double.parseDouble(strNumber));

                strExercise = String.format("%s%% = %s * 0,01 = %s", strNum, strNum, strResult);

                alExercises.add(0, strExercise);
                adapter.notifyDataSetChanged();
                etPercent.getText().clear();
                etPercent.requestFocus();

                break;
            default:
                break;
        }
    }
}
