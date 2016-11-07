package com.example.luciano.controlecliente;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroCliente extends AppCompatActivity {

    private Button Salvar;
    private Button Cancelar;
    private EditText Codigo;
    private EditText Nome;
    private EditText Endereco;
    private Spinner Cidades;

    private Cliente cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        Salvar = (Button) findViewById(R.id.btSalvar);
        Cancelar = (Button) findViewById(R.id.btCancelar);
        Codigo = (EditText) findViewById(R.id.edtCodigo);
        Nome = (EditText) findViewById(R.id.edtNome);
        Endereco = (EditText) findViewById(R.id.edtEndereco);
        Cidades = (Spinner) findViewById(R.id.spinnerCidade);


        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(Long.parseLong(Codigo.getText().toString()));
                    cliente.setNome(Nome.getText().toString());
                    cliente.setEndereco(Endereco.toString());

                    cliente.save();

                    Intent it = new Intent(CadastroCliente.this, CrudCliente.class);
                    startActivity(it);
                }catch (SQLException ex){
                    Toast toast = Toast.makeText(CadastroCliente.this,"Erro ao Cadastrar", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroCliente.this, CrudCliente.class);
                startActivity(it);
            }
        });
    }
}
