package com.example.percentage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class fraction2percent extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> alExercises;
    ArrayAdapter<String> adapter;
    Button btnFind;
    EditText etNum1, etNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraction2percent);

        btnFind = (Button) findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        ListView lvExercises = (ListView) findViewById(R.id.lvExercises);
        alExercises = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alExercises);
        lvExercises.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFind:
                if (TextUtils.isEmpty(etNum1.getText().toString()) || TextUtils.isEmpty(etNum2.getText().toString())) return;
                String strNumber, strExercise, strTemp;
                strNumber = etNum1.getText().toString();
                if (strNumber.indexOf('.') == -1) {
                    int num = Integer.parseInt(strNumber);
                    strExercise = String.format("%d = %d * 100%% = %d%%", num, num, num * 100);
                } else {
                    double num = Double.parseDouble(strNumber);
                    int placesAfterPoint = strNumber.length() - strNumber.indexOf('.') -1;
                    strTemp = String.format("%%.%df = %%.%df * 100%%%% = %%.%df%%%%", placesAfterPoint, placesAfterPoint, placesAfterPoint>2 ? placesAfterPoint-2 : 0);
                    strExercise = String.format(strTemp, num, num, num * 100);
                }
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
