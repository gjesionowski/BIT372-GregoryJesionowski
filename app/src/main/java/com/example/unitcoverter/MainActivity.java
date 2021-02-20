package com.example.unitcoverter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button fbtn = findViewById(R.id.convert_btn);
        EditText finput = findViewById(R.id.converter_input);

        Converter converter = new Converter();
        ConverterViewModel model = new ViewModelProvider(this).get(ConverterViewModel.class);
        model.getCurrentConversion();
        model.getConversionOutput();
        model.conversion.observe(this, conversion -> {
            TextView title = findViewById(R.id.conversion_title);
            title.setText(conversion);
            Log.i("INFO", "Conversion Observer is working, changed title to " + conversion);
        });
        model.conversionOutput.observe(this, conversionOutput -> {
            TextView coutput = findViewById(R.id.converter_output);
            coutput.setText(conversionOutput);
            Log.i("INFO", "Output Observer is working, changed output value to " + conversionOutput);
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                model.updateCurrentConversion(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            float input = Float.parseFloat(finput.getText().toString());
            int pos = spinner.getSelectedItemPosition();
            model.updateConversionOutput(converter.convertValues(pos, input));
            });
    }
}