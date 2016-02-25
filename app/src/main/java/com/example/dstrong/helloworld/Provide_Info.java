package com.example.dstrong.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Provide_Info extends AppCompatActivity {

    public static final String CLASS_NAME_EXTRA = "classNameExtra";
    public static final String PERSON_NAME_EXTRA = "personNameExtra";
    public static final String PERSON_EMAIL_EXTRA = "personEmailExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provide_info);

        setupViews();
    }

    private void setupViews() {
        Button done = (Button) findViewById(R.id.done_button);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Provide_Info.this.handleDoneButton((Button) view);
            }
        });
    }

    private void handleDoneButton(Button view) {
        String className = getSelectedValueOfRadioGroup(R.id.classSelectGroup);
        String name = getEditTextValue(R.id.name_edittext);
        String email = getEditTextValue(R.id.email_edittext);

        Intent results = new Intent();
        results.putExtra(CLASS_NAME_EXTRA, className);
        results.putExtra(PERSON_NAME_EXTRA, name);
        results.putExtra(PERSON_EMAIL_EXTRA,email);

        //set data on intent and pass back to parent activity
        setResult(RESULT_OK, results);
        finish();
    }

    private String getEditTextValue(int textViewId){
        EditText editText= (EditText) findViewById(textViewId);
        Editable editable = editText.getText();
        return editable != null ? editable.toString() :"";
    }

    private String getSelectedValueOfRadioGroup(int groupId){
        RadioGroup radioGroup = (RadioGroup) findViewById(groupId);

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(radioButtonId);

        return (String) radioButton.getText();
    }
}
