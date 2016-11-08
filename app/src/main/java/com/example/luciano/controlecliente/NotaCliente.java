package com.example.luciano.controlecliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotaCliente extends AppCompatActivity {

    private ListView listViewClientes;

    private ArrayAdapter<Cliente> adpClientes;
    private List<Cliente> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_cliente);

        listViewClientes = (ListView) findViewById(R.id.lstNota);

        Iterator<Cliente> listaClientes = Cliente.findAll(Cliente.class);

        lista = new ArrayList<Cliente>();
        adpClientes = new ArrayAdapter(this, android.R.layout.simple_list_item_1);

        while (listaClientes.hasNext()){
            Cliente cliente = listaClientes.next();
            lista.add(cliente);
        }

        adpClientes.addAll(lista);
        listViewClientes.setAdapter(adpClientes);


        listViewClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent it = new Intent(NotaCliente.this, CrudNota.class);
                it.putExtra("cliente", adpClientes.getItem(i));
                startActivity(it);
            }
        });
    }
}
