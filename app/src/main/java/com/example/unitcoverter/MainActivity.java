package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        Spinner spinner = findViewById(R.id.spinner);

        EditText finput = findViewById(R.id.converter_input);
        TextView foutput = findViewById(R.id.converter_output);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            switch (spinner.getSelectedItemPosition()) {
                case 0:
                    double output = Converter.toOranges(Float.parseFloat(finput.getText().toString()));
                    foutput.setText(String.format("%.2f Oranges", output));
                    break;
                case 1:
                    output = Converter.toMeters(Float.parseFloat(finput.getText().toString()));
                    foutput.setText(String.format("%.2f Meters", output));
                    break;
                case 2:
                    output = Converter.toKilograms(Float.parseFloat(finput.getText().toString()));
                    foutput.setText(String.format("%.2f Meters", output));
                    break;
                case 3:
                    output = Converter.toMilliliters(Float.parseFloat(finput.getText().toString()));
                    foutput.setText(String.format("%.2f Meters", output));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + spinner.getSelectedItemPosition());
            }


        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}