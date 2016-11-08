package com.example.luciano.controlecliente;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Luciano on 07/11/2016.
 */
public class Cliente extends SugarRecord implements Serializable{

    private long Codigo;
    private String Nome;
    private String Endereco;
    private String Cidade;

    public Cliente() {
    }

    public long getCodigo() {
        return Codigo;
    }

    public void setCodigo(long codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        this.Endereco = endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    @Override
    public String toString() {
        return ""+this.Codigo+"     "+this.Nome;
    }
}
