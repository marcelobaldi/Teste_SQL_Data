package mb.listarecyclerview.model;
import android.graphics.Bitmap;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DogModel implements Serializable {
    //Atributos
    private Integer     id;
    private String      nome;
    private Long        dataCadastro;

    //Construtor
    public DogModel() { }

    //GetterSetter
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Long getDataCadastro() {return dataCadastro;}
    public void setDataCadastro(Long dataCadastro) {this.dataCadastro = dataCadastro;}

    //To String
    @Override public String toString() {
        return "DogModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}

