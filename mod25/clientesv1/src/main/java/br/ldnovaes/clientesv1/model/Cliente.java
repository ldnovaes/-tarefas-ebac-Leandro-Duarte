package br.ldnovaes.clientesv1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ldnovaes
 */

public class Cliente {

    private static List<Cliente> clientes = new ArrayList<>();
    private long id;
    private String nome;
    private long cpf;
    private long tel;
    private String email;

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public long getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private Cliente(String nome, long cpf, long tel, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.email = email;
    }

    public Cliente() {

    };

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removecliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cliente cliente = (Cliente) object;
        return Objects.equals(nome, cliente.nome);
    }

    public Cliente salvar(String nome, long cpf, long tel, String email) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTel(tel);
        this.setEmail(email);
        return this;
    }

    public Cliente update(String nome, long cpf, long tel, String email) {
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
