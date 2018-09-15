package br.ufjf.ice.ex01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExternalActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText inputName;
    private EditText inputId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        btnRegister = findViewById(R.id.external_register);
        inputName = findViewById(R.id.external_name_input);
        inputId = findViewById(R.id.external_mail_input);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent res = new Intent();
                res.putExtra("ExternalName", inputName.getText().toString());
                res.putExtra("ExternalId", inputId.getText().toString());
                setResult(Activity.RESULT_OK, res);
                finish();
            }
        });
    }
}
