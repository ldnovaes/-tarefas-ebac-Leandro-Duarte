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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MainController implements IController, ISubject {

    private static List<IObservador> observadores = new ArrayList<>();

    private static LogEnum acao;
    ClienteDAO clienteDAO;
    private static IObservador observadorLog = new ObservadorLog();

    @FXML
    protected ListView<Cliente> lvClientesFxml;
    @FXML
    protected TextField searchInput;
    @FXML
    protected MenuItem editarClienteMenu;
    @FXML
    protected MenuItem apagarClienteMenu;

    @FXML
    protected void initialize() {
        this.clienteDAO = new ClienteDAO();
        this.registerObserver(observadorLog);
        this.updateList(this.clienteDAO.obterClientes());
        lvClientesFxml.getSelectionModel().selectedItemProperty().addListener(s -> {
            eventListenerMenu();
        });
        eventListenerMenu();
    }

    private void eventListenerMenu() {
        ObservableList<Cliente> ol = lvClientesFxml.getSelectionModel().getSelectedItems();
        if (!ol.isEmpty()) {
            editarClienteMenu.setVisible(true);
            apagarClienteMenu.setVisible(true);
        } else {
            editarClienteMenu.setVisible(false);
            apagarClienteMenu.setVisible(false);
        }
    }


    @FXML
    protected void cadastrarCliente() throws IOException {
        Main.changeScreen(ScreenEnum.DETAIL, ScreenChangeEnum.CADASTRO);
        acao = LogEnum.MAIN;
        DetailController.setModo(ScreenChangeEnum.CADASTRO);
        this.notifyObservers();
    }


    @FXML
    protected void editarCliente() throws IOException {
        List<Cliente> ol = lvClientesFxml.getSelectionModel().getSelectedItems();
        if (!ol.isEmpty()) {
            Cliente selecionado = ol.get(0);
            Cliente cliente = this.clienteDAO.buscarCliente(selecionado);
            DetailController.setDados(cliente);
            DetailController.setModo(ScreenChangeEnum.DETAIL);
            Main.changeScreen(ScreenEnum.DETAIL, ScreenChangeEnum.DETAIL);
        }
    }

    @FXML
    protected void apagarCliente() {
        ObservableList<Cliente> ol = lvClientesFxml.getSelectionModel().getSelectedItems();
        if (!ol.isEmpty()) {
            Cliente selecionado = ol.get(0);
            Cliente cliente = this.clienteDAO.buscarCliente(selecionado);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deseja realmente apagar?");
            alert.setHeaderText("Apagar um cliente significa perder os seus dados permanentemente");
            alert.setContentText("Você pode clicar em Cancelar para voltar");

            Optional<ButtonType> result = alert.showAndWait();
            if (((Optional<?>) result).get() == ButtonType.OK){
                this.clienteDAO.abreConexao();
                this.clienteDAO.removerCliente(cliente);
                this.updateList(this.clienteDAO.obterClientes());
                this.clienteDAO.fechaConexao();
            }
        }
    }

    @FXML
    protected void buscarCliente() throws IOException {
        acao = LogEnum.BUSCAR;
        this.notifyObservers();
        ClienteService clienteService = new ClienteService();
        String pesquisa = this.searchInput.getText();

        if (pesquisa.trim().isEmpty()) {
            ClienteDAO clienteDAO = new ClienteDAO();
            this.updateList(clienteDAO.obterClientes());
        } else {
            Stream<Cliente> clientes = clienteService.pesquisarCliente(pesquisa);
            updateList(clientes.toList());
        }
    }

    private void updateList(List<Cliente> listaClientes) {
        lvClientesFxml.getItems().clear();
        for (Cliente item:listaClientes) {
            lvClientesFxml.getItems().add(item);
        }
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
}