package com.pillarproductivity.pillar_competitivefitnesstracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateAcctActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword, editTextFirst, editTextLast, editTextPhone;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        editTextEmail = findViewById(R.id.addEmail);
        editTextPassword = findViewById(R.id.addPassword);
        editTextFirst = findViewById(R.id.addFName);
        editTextLast = findViewById(R.id.addLName);
        editTextPhone = findViewById(R.id.addPhone);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioMale);


    }

    //Handles functions for verifying and submitting user data
    private void registerUser() {
        Boolean tempBool = validateInput();
        if (tempBool == false) return;
        else submitData();
    }

    private void submitData() {

    }

    private Boolean validateInput() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String first = editTextFirst.getText().toString().trim();
        String last = editTextLast.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is Required");
            editTextEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return false;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is Required");
            editTextPassword.requestFocus();
            return false;
        }

        if (password.length() < 6) {
            editTextPassword.setError(("Minimum length of password should be 6 characters"));
            editTextPassword.requestFocus();
            return false;

        }
        if (first.isEmpty()) {
            editTextFirst.setError("First name is Required");
            editTextFirst.requestFocus();
            return false;
        }
        if (last.isEmpty()) {
            editTextLast.setError("Last Name is Required");
            editTextLast.requestFocus();
            return false;
        }
        if (phone.isEmpty()) {
            editTextPhone.setError("Phone Number is Required");
            editTextPhone.requestFocus();
            return false;
        }

        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(CreateAcctActivity.this, "Gender Selection Required",
                    Toast.LENGTH_SHORT).show();
            return false;

        }
        return true;

    }

    //@Override
    public void onClick(View view) {
        registerUser();

    }
}
