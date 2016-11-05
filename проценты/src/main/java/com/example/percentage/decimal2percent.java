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

public class decimal2percent extends AppCompatActivity implements View.OnClickListener{

    ArrayList<String> alExercises;
    ArrayAdapter<String> adapter;
    Button btnFind;
    EditText etDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal2percent);

        btnFind = (Button) findViewById(R.id.btnFind);
        btnFind.setOnClickListener(this);

        etDecimal = (EditText) findViewById(R.id.etDecimal);

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
                strNumber = etDecimal.getText().toString();
                if (TextUtils.isEmpty(strNumber)) break;

                BigDecimal num = new BigDecimal(strNumber);

                DecimalFormat formatter = new DecimalFormat("#.#########");
                String strNum = formatter.format(num.doubleValue());
                formatter.applyPattern("#.#########%");
                String strResult = formatter.format(num.doubleValue());

                strExercise = String.format("%s = %s * 100%% = %s", strNum, strNum, strResult);

                alExercises.add(0, strExercise);
                adapter.notifyDataSetChanged();
                etDecimal.getText().clear();
                etDecimal.requestFocus();

                break;
            default:
                break;
        }

    }
}
