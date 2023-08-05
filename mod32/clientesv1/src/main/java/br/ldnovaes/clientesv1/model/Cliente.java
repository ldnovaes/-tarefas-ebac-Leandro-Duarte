package br.ldnovaes.clientesv1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ldnovaes
 */

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cpf;
    private String tel;
    private String email;

    public long getId() {
        return this.id;
    }
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private Cliente(String nome, String cpf, String tel, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.email = email;
    }

    public Cliente() {

    };


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cliente cliente = (Cliente) object;
        return Objects.equals(nome, cliente.nome);
    }

    public Cliente salvar(String nome, String cpf, String tel, String email) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTel(tel);
        this.setEmail(email);
        return this;
    }

    public Cliente update(String nome, String cpf, String tel, String email) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTel(tel);
        this.setEmail(email);
        return this;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.nome);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
