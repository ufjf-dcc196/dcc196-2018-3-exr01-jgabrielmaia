package br.ufjf.ice.ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_STUDENT = 0;
    private static final int ADD_SERVER = 1;
    private static final int ADD_EXTERNAL = 2;

    private Button studentBtn;
    private Button serverBtn;
    private Button externalBtn;

    private TextView studentCounter;
    private TextView serverCounter;
    private TextView externalCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentBtn = (Button) findViewById(R.id.add_student_btn);
        serverBtn = (Button) findViewById(R.id.add_server_btn);
        externalBtn = (Button) findViewById(R.id.add_external_btn);

        studentCounter = (TextView) findViewById(R.id.count_students);
        serverCounter = (TextView) findViewById(R.id.count_servers);
        externalCounter = (TextView) findViewById(R.id.count_externals);

        int countStudents = 0;
        int countServers = 0;
        int countExternals = 0;

        studentCounter.setText(Integer.toString(countStudents));
        serverCounter.setText(Integer.toString(countServers));
        externalCounter.setText(Integer.toString(countExternals));

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
}
