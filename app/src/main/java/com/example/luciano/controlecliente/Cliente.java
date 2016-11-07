package com.example.luciano.controlecliente;

import com.orm.SugarRecord;

/**
 * Created by Luciano on 07/11/2016.
 */
public class Cliente extends SugarRecord{

    private long _id;
    private long Codigo;
    private String Nome;
    private String rua;
    private String Cidade;

    public Cliente() {
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    @Override
    public String toString() {
        return "Código:  "+this.Codigo+" Nome: "+this.Nome;
    }
}
