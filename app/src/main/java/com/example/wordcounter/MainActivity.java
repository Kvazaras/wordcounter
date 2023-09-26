package com.example.wordcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import utils.TextCounter;

public class MainActivity extends AppCompatActivity {

    private Spinner spSelectionOptions;
    private EditText edPhrase;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.edPhrase = findViewById(R.id.edPhrase);
        this.tvMain = findViewById(R.id.tvMain);

        this.spSelectionOptions = findViewById(R.id.spSelectionOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spSelectionOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        String selectedOption = this.spSelectionOptions.getSelectedItem().toString();
        String defaultCharsSelectedOption = getResources().getString(R.string.chars_selection);
        if(selectedOption.equals(defaultCharsSelectedOption)){
            String userInputText = this.edPhrase.getText().toString();
            if(TextUtils.isEmpty(userInputText)){
                //TODO:
            }
            else {
                String charsCount = TextCounter.getCharsCount(userInputText);
                this.tvMain.setText(charsCount);
            }
        }
    }

    //public static String getCharsCount(String input){
    //    return String.valueOf(input.length());
    //}
}