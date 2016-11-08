package com.example.luciano.controlecliente;

import com.orm.SugarRecord;

/**
 * Created by Luciano on 07/11/2016.
 */
public class Red extends SugarRecord{

    private double nota;
    private long id_Cliente;

    public Red() {
    }

    public long getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(long id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
