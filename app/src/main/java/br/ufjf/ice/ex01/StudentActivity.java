package br.ufjf.ice.ex01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText inputName;
    private EditText inputId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        btnRegister = findViewById(R.id.student_register);
        inputName = findViewById(R.id.student_name_input);
        inputId = findViewById(R.id.student_id_input);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent res = new Intent();
                res.putExtra("StudentName", inputName.getText().toString());
                res.putExtra("StudentId", inputId.getText().toString());
                setResult(Activity.RESULT_OK, res);
                finish();
            }
        });
    }
}
