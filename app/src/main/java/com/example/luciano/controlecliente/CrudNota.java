package com.example.luciano.controlecliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CrudNota extends AppCompatActivity {

    private TextView Cliente;
    private EditText Nota;

    private Button Salvar;
    private Button Alterar;
    private Button Cancelar;

    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_nota);

        Salvar = (Button) findViewById(R.id.btSalvar_nota);
        Alterar = (Button) findViewById(R.id.btAlterar_nota);
        Cancelar = (Button) findViewById(R.id.btCancelar_nota);
        Cliente = (TextView) findViewById(R.id.txtCliente_nota);
        Nota = (EditText) findViewById(R.id.edtNota);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey("cliente")){
            cliente =(Cliente) bundle.getSerializable("cliente");
        }

        preencher();

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Red red = new Red();
                red.setNota(Double.valueOf(Nota.getText().toString()));
                red.setId_Cliente(cliente.getId());

                red.save();

                Intent it = new Intent(CrudNota.this, NotaCliente.class);
                startActivity(it);
            }
        });
    }

    public void preencher(){
        Cliente.setText(cliente.getNome());
    }
}
