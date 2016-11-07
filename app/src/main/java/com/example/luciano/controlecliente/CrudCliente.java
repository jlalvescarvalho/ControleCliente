package com.example.luciano.controlecliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class CrudCliente extends AppCompatActivity {

    private ImageButton btCad;
    private EditText Pesq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_cliente);

        btCad = (ImageButton) findViewById(R.id.btcad);
        Pesq = (EditText) findViewById(R.id.edtPesq);

        btCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CrudCliente.this, CadastroCliente.class);
                startActivity(it);
            }
        });
    }
}
