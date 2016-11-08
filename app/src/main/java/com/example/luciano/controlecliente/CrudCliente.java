package com.example.luciano.controlecliente;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CrudCliente extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ImageButton btCad;
    private EditText Pesq;
    private ListView listView;

    private ArrayAdapter<Cliente> adpClientes;
    private List<Cliente> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_cliente);

        btCad = (ImageButton) findViewById(R.id.btcad);
        Pesq = (EditText) findViewById(R.id.edtPesq);
        listView = (ListView) findViewById(R.id.listViewClientes);
        listView.setOnItemClickListener(this);
        Iterator<Cliente> listaClientes = Cliente.findAll(Cliente.class);

        lista = new ArrayList<Cliente>();
        adpClientes = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

        while (listaClientes.hasNext()){
            Cliente cliente = listaClientes.next();
            lista.add(cliente);
        }

        adpClientes.addAll(lista);
        listView.setAdapter(adpClientes);


        btCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CrudCliente.this, CadastroCliente.class);
                startActivity(it);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Cliente c = adpClientes.getItem(i);

        Intent it = new Intent(this, Alterar_Cliente.class);
        it.putExtra("cliente", c);
        it.putExtra("posicao", lista.get(i).getId().toString());
        startActivity(it);


    }
}
