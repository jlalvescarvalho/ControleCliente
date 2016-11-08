package com.example.luciano.controlecliente;

import android.content.Intent;
import android.database.SQLException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Alterar_Cliente extends AppCompatActivity {

    private Cliente cliente;
    private String posicao;

    private EditText nome;
    private EditText endereco;
    private TextView codigo;
    private Spinner cidade;

    private Button Alterar;
    private Button Excluir;
    private Button cancelar;

    private String cidadeNome;
    private List<String> spn_cidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar__cliente);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.containsKey("cliente")){
            cliente =(Cliente) bundle.getSerializable("cliente");
        }

        Bundle bundles = getIntent().getExtras();
        if(bundles != null && bundles.containsKey("posicao")){
            posicao = (String) bundles.getSerializable("posicao");
        }

        codigo = (TextView) findViewById(R.id.txtCodigo_alt);
        nome = (EditText) findViewById(R.id.edtNome_alt);
        endereco = (EditText) findViewById(R.id.edtEndereco_alt);
        cidade = (Spinner) findViewById(R.id.spinner_alt);
        Alterar = (Button) findViewById(R.id.btalt);
        Excluir = (Button) findViewById(R.id.btExcluir);
        cancelar = (Button) findViewById(R.id.btCancelar_alt);



        spn_cidades = new ArrayList<>();
        spn_cidades.add("Calçado");
        spn_cidades.add("Águas Belas");
        spn_cidades.add("Canhotinho");
        spn_cidades.add("Lagoa do Ouro");
        spn_cidades.add("Jucati");
        spn_cidades.add("Jupi");

        ArrayAdapter<String> arrayAdapterSPN = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spn_cidades);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapterSPN;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cidade.setAdapter(spinnerArrayAdapter);
        Preencher();
        cidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cidadeNome = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cliente c = Cliente.findById(Cliente.class, Integer.parseInt(posicao));

                    c.setCodigo(Long.parseLong(codigo.getText().toString()));
                    c.setNome(nome.getText().toString());
                    c.setEndereco(endereco.getText().toString());
                    c.setCidade(cidadeNome);

                    c.save();

                    Intent it = new Intent(Alterar_Cliente.this, CrudCliente.class);
                    startActivity(it);

                    Toast toast = Toast.makeText(Alterar_Cliente.this, "Cliente alterado Com sucesso", Toast.LENGTH_LONG);
                    toast.show();
                }catch (SQLException ex){
                    Toast toast = Toast.makeText(Alterar_Cliente.this, "Erro ao alterar", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        Excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente c = Cliente.findById(Cliente.class, Integer.parseInt(posicao));
                c.delete();

                Intent it = new Intent(Alterar_Cliente.this, CrudCliente.class);
                startActivity(it);

                Toast toast = Toast.makeText(Alterar_Cliente.this, "Excluido com sucesso !", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Alterar_Cliente.this, CrudCliente.class);
                startActivity(it);
            }
        });
    }

    public void Preencher(){

        codigo.setText(String.valueOf(cliente.getCodigo()));
        nome.setText(cliente.getNome().toString());
        endereco.setText(cliente.getEndereco().toString());
    }
}
