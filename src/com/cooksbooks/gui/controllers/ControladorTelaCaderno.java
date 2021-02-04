package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.ControladorGUI;
import com.cooksbooks.DataReceiver;
import com.cooksbooks.DataSender;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.facilities.Telas;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaCaderno implements ControladorGUI, DataReceiver, DataSender {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private App app = App.getInstancia();

  private CadernoReceitas caderno;

  @FXML
  private Label lbNomeCaderno;

  @FXML
  private TextArea taDesc;

  @FXML
  private Button btVoltar;

  @FXML
  private Button btEditarCaderno;

  @FXML
  private Button btBuscarReceita;

  @FXML
  private TextField tfReceitaBuscar;

  @FXML
  private ListView<Receita> lvResultadoBuscaReceita;

  @FXML
  private ListView<Categoria> lvCategoriasCaderno;

  @FXML
  private void initialize() {
    this.taDesc.setText(caderno.getInformacoesCaderno());
    this.taDesc.disableProperty();

    this.lvCategoriasCaderno.getItems().addAll(caderno.listarCategorias());
    this.lvResultadoBuscaReceita.getItems().addAll
        (sistema.listarReceitasDoCaderno(caderno.getIdCaderno()));
  }

  @FXML
  void handleBuscarReceita() {
  }

  @FXML
  void handleEditarCaderno() {
    //app.alterarTela(Telas.TELA_ALTERAR_CADERNO, this); //Talvez a telaCriacaoCaderno possa atuar aqui
  }

  @FXML
  void handleVoltar() throws IOException {
    app.alterarTela(Telas.TELA_PRINCIPAL_USUARIO);
  }

  @Override
  public void setApp(App app) {
    this.app = app;
  }

  @Override
  public void setInformation(Object[] information) {
    this.caderno = (CadernoReceitas) information[0]; // Caderno selecionado da TelaPrincipal
  }

  @Override
  public HashMap<String, Object> getInformation() {

    Object[] information = new Object[1];
    information[0] = this.lvResultadoBuscaReceita.getSelectionModel().getSelectedItem(); // Receita
    return information;
  }
}