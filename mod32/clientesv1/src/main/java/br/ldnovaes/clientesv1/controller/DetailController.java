package br.ldnovaes.clientesv1.controller;

import br.ldnovaes.clientesv1.Main;
import br.ldnovaes.clientesv1.dao.ClienteDAO;
import br.ldnovaes.clientesv1.enums.LogEnum;
import br.ldnovaes.clientesv1.enums.ScreenChangeEnum;
import br.ldnovaes.clientesv1.enums.ScreenEnum;
import br.ldnovaes.clientesv1.interfaces.IController;
import br.ldnovaes.clientesv1.interfaces.IObservador;
import br.ldnovaes.clientesv1.interfaces.ISubject;
import br.ldnovaes.clientesv1.model.Cliente;
import br.ldnovaes.clientesv1.service.ClienteService;
import br.ldnovaes.clientesv1.utills.ObservadorLog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author ldnovaes
 */

public class DetailController implements IController, ISubject {

    private static List<IObservador> observadores = new ArrayList<>();
    private static LogEnum acao;
    private static IObservador observadorLog = new ObservadorLog();
    private static Cliente cliente;
    private static ScreenChangeEnum modo;
    private ClienteDAO clienteDAO;

    Set<String> fieldsFaltando = new HashSet<>();

    @FXML protected Button buttonSalvarCadastro;
    @FXML protected TextField cadastroNome;
    @FXML protected TextField cadastroCpf;
    @FXML protected TextField cadastroTelefone;
    @FXML protected TextField cadastroEmail;

    public static void setModo(ScreenChangeEnum screenChangeEnum) {
        modo = screenChangeEnum;
    }

    @FXML
    protected void initialize() {
        this.registerObserver(observadorLog);
        this.clienteDAO = new ClienteDAO();

        if (cliente != null && modo.equals(ScreenChangeEnum.DETAIL)) {
            this.cadastroNome.setText(cliente.getNome());
            this.cadastroCpf.setText(String.valueOf(cliente.getCpf()));
            this.cadastroTelefone.setText(String.valueOf(cliente.getTel()));
            this.cadastroEmail.setText(cliente.getEmail());
        }
    }

    @FXML
    protected void voltarMain() throws IOException {
        Main.changeScreen(ScreenEnum.MAIN, ScreenChangeEnum.MAIN);
        acao = LogEnum.VOLTAR;
        this.notifyObservers();
    }

    @FXML
    protected void salvarCadastro() throws IOException {

        String nome = this.getNomeField();
        String cpf = this.getCpfField();
        String telefone = this.getTelefoneField();
        String email = this.getEmailField();

        if (cliente != null && modo.equals(ScreenChangeEnum.DETAIL)) {
            this.updateCadastro();
        } else {

            // verificar se os campos foram todos preenchidos
            if (nome != null && email != null && cpf != null && telefone != null) {
                ClienteService clienteServiceInstancia = new ClienteService();
                Cliente cliente = clienteServiceInstancia.salvar(nome, cpf, telefone, email); // trata da regra de negócio

                this.clienteDAO.abreConexao();
                cliente = this.clienteDAO.salvarCliente(cliente);
                this.clienteDAO.fechaConexao();

                if (cliente != null) {
                    Main.changeScreen(ScreenEnum.MAIN, ScreenChangeEnum.MAIN);
                    acao = LogEnum.CADASTRO;
                    this.notifyObservers();
                    JOptionPane.showMessageDialog(null, "Cadastro de " + nome.toUpperCase() + " realizado com sucesso!");
                }

            } else {
                StringBuilder mensagem = new StringBuilder();
                mensagem.append("Os seguintes campos estão inválidos:\n");
                for (String field : fieldsFaltando) {
                    mensagem.append("- " + field.toUpperCase()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensagem.toString());
            }
        }
    }

    @FXML
    protected void updateCadastro() throws IOException {
        String nome = this.getNomeField();
        String cpf = this.getCpfField();
        String telefone = this.getTelefoneField();
        String email = this.getEmailField();
        ClienteService clienteService = new ClienteService();
        Cliente cliente = clienteService.update(nome, cpf, telefone, email);

        this.clienteDAO.abreConexao();
        this.clienteDAO.atualizarCliente(cliente);
        this.clienteDAO.fechaConexao();

        Main.changeScreen(ScreenEnum.MAIN, ScreenChangeEnum.MAIN);
        JOptionPane.showMessageDialog(null, "Cadastro de " + nome.toUpperCase() + " alterado com sucesso!");
        acao = LogEnum.VOLTAR;
        this.notifyObservers();
    }

    @Override
    public void registerObserver(IObservador observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
    }

    @Override
    public void unregisterObserver(IObservador observer) {
        if (observadores.contains(observer)) {
            observadores.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (IObservador observador:observadores) {
            observador.update(observador, acao);
        }
    }

    private String getNomeField() {
        String nome = this.cadastroNome.getText();
        if (nome.trim().isEmpty()) {
            this.fieldsFaltando.add("Nome");
            return null;
        }
        this.fieldsFaltando.remove("Nome");
        return nome;
    }

    private String getCpfField() {
        String cpf = this.cadastroCpf.getText();
        if (cpf.trim().isEmpty()) {
            this.fieldsFaltando.add("CPF");
            return null;
        }
        this.fieldsFaltando.remove("CPF");
        return cpf;
    }
    private String getTelefoneField() {
        String telefone = this.cadastroTelefone.getText();
        if (telefone.trim().isEmpty()) {
            this.fieldsFaltando.add("Telefone");
            return null;
        }
        this.fieldsFaltando.remove("Telefone");
        return telefone;
    }

    private String getEmailField() {
        String email = this.cadastroEmail.getText();
        if (email.trim().isEmpty()) {
            this.fieldsFaltando.add("Email");
            return null;
        }
        this.fieldsFaltando.remove("Email");
        return email;
    }

    public static void setDados(Cliente cliente) {
        DetailController.cliente = cliente;
    }
}
