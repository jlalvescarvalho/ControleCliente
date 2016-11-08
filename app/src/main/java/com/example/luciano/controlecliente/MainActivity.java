package com.example.luciano.controlecliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btCliente;
    private Button btNotas;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCliente = (Button) findViewById(R.id.btCliente);
        btNotas = (Button) findViewById(R.id.btNota);

        btCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CrudCliente.class);
                startActivity(it);
            }
        });

        btNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, NotaCliente.class);
                startActivity(it);
            }
        });
    }
}
