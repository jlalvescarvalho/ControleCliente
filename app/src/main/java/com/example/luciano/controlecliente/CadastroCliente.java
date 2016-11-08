package com.example.luciano.controlecliente;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadastroCliente extends AppCompatActivity {

    private Button Salvar;
    private Button Cancelar;
    private EditText Codigo;
    private EditText Nome;
    private EditText Endereco;
    private Spinner Cidades;

    private List<String> spn_cidades;
    private String CidadeNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        spn_cidades = new ArrayList<>();
        spn_cidades.add("Calçado");
        spn_cidades.add("Águas Belas");
        spn_cidades.add("Canhotinho");
        spn_cidades.add("Lagoa do Ouro");
        spn_cidades.add("Jucati");
        spn_cidades.add("Jupi");

        Salvar = (Button) findViewById(R.id.btSalvar);
        Cancelar = (Button) findViewById(R.id.btCancelar);
        Codigo = (EditText) findViewById(R.id.edtCodigo);
        Nome = (EditText) findViewById(R.id.edtNome);
        Endereco = (EditText) findViewById(R.id.edtEndereco);
        Cidades = (Spinner) findViewById(R.id.spinnerCidade);

        ArrayAdapter<String> arrayAdapterSPN = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spn_cidades);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapterSPN;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Cidades.setAdapter(spinnerArrayAdapter);
        Cidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             CidadeNome = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final Cliente cliente = new Cliente();
                    cliente.setCodigo(Long.parseLong(Codigo.getText().toString()));
                    cliente.setNome(Nome.getText().toString());
                    cliente.setEndereco(Endereco.getText().toString());
                    cliente.setCidade(CidadeNome);
                    cliente.save();

                    Intent it = new Intent(CadastroCliente.this, CrudCliente.class);
                    startActivity(it);

                    Toast toast = Toast.makeText(CadastroCliente.this,"Cadastrado com sucesso ", Toast.LENGTH_LONG);
                    toast.show();

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
