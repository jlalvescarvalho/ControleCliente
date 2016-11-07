package com.example.luciano.controlecliente;

import com.orm.SugarRecord;

/**
 * Created by Luciano on 07/11/2016.
 */
public class Red extends SugarRecord{

    private long _id;
    private double nota;

    public Red() {
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
