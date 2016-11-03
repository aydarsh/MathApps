package com.example.percentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
                if (TextUtils.isEmpty(etPercent.getText().toString())) return;
                String strNumber, strExercise, strTemp;
                strNumber = etPercent.getText().toString();
                if (strNumber.indexOf('.') == -1) {
                    int num = Integer.parseInt(strNumber);
                    strExercise = String.format("%d%% = %d * 0,01 = %.2f", num, num, num*0.01);
                }
                else {
                    double num = Double.parseDouble(strNumber);
                    int placesAfterPoint = strNumber.length() - strNumber.indexOf('.') -1;
                    strTemp = String.format("%%.%df%%%% = %%.%df * 0,01 = %%.%df", placesAfterPoint, placesAfterPoint, placesAfterPoint+2);
                    strExercise = String.format(strTemp, num, num, num*0.01);
                }
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
