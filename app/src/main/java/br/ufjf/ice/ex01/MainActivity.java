package br.ufjf.ice.ex01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int ADD_STUDENT = 0;
    private static int ADD_SERVER = 1;
    private static int ADD_EXTERNAL = 2;

    private Button studentBtn;
    private Button serverBtn;
    private Button externalBtn;

    private TextView studentCounter;
    private TextView serverCounter;
    private TextView externalCounter;

    private int countStudents;
    private int countExternals;
    private int countServers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentBtn = findViewById(R.id.add_student_btn);
        serverBtn = findViewById(R.id.add_server_btn);
        externalBtn = findViewById(R.id.add_external_btn);

        studentCounter = findViewById(R.id.count_students);
        serverCounter = findViewById(R.id.count_servers);
        externalCounter = findViewById(R.id.count_externals);

        countStudents = 0;
        countServers = 0;
        countExternals = 0;

        studentCounter.setText(String.valueOf(countStudents));
        serverCounter.setText(String.valueOf(countServers));
        externalCounter.setText(String.valueOf(countExternals));

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivityForResult(intent, ADD_STUDENT);
            }
        });

        serverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServerActivity.class);
                startActivityForResult(intent, ADD_SERVER);
            }
        });

        externalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExternalActivity.class);
                startActivityForResult(intent, ADD_EXTERNAL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MainActivity.ADD_STUDENT && resultCode == Activity.RESULT_OK && data != null) {

            TextView name = findViewById(R.id.last_register_name);
            TextView idLabel = findViewById(R.id.last_register_id_label);
            TextView id = findViewById(R.id.last_register_id);

            idLabel.setText(R.string.insert_student_id_label);

            Bundle bundle = data.getExtras();
            try
            {
                String resName = bundle.getString("StudentName");
                String resId = bundle.getString("StudentId");
                name.setText(resName);

                id.setText(resId);

            } catch (NullPointerException ex)
            {

            }

            countStudents++;
            studentCounter.setText(String.valueOf(countStudents));

        } else if (requestCode == MainActivity.ADD_SERVER && resultCode == Activity.RESULT_OK && data != null) {

            TextView name = findViewById(R.id.last_register_name);
            TextView idLabel = findViewById(R.id.last_register_id_label);
            TextView id = findViewById(R.id.last_register_id);

            idLabel.setText(R.string.insert_server_id_label);

            Bundle bundle = data.getExtras();
            try
            {
                String resName = bundle.getString("ServerName");
                String resId = bundle.getString("ServerId");

                name.setText(resName);
                id.setText(resId);
            } catch (NullPointerException ex)
            {

            }
            countServers++;
            serverCounter.setText(String.valueOf(countServers));

        } else if (requestCode == MainActivity.ADD_EXTERNAL && resultCode == Activity.RESULT_OK && data != null) {

            TextView name = findViewById(R.id.last_register_name);
            TextView idLabel = findViewById(R.id.last_register_id_label);
            TextView id = findViewById(R.id.last_register_id);

            idLabel.setText(R.string.insert_external_mail_label);

            Bundle bundle = data.getExtras();

            try
            {
                String resName = bundle.getString("ExternalName");
                String resId = bundle.getString("ExternalId");
                name.setText(resName);
                id.setText(resId);
            } catch (NullPointerException ex)
            {

            }

            countExternals++;
            externalCounter.setText(String.valueOf(countExternals));

        }
    }
}
