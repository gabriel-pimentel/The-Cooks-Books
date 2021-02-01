package com.cooksbooks;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.facilities.Telas;
import com.cooksbooks.gui.controllers.ControladorTelaCadastro;
import com.cooksbooks.gui.controllers.ControladorTelaCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoRec;
import com.cooksbooks.gui.controllers.ControladorTelaLogin;
import com.cooksbooks.gui.controllers.ControladorTelaPrincipal;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class App extends Application {

  private static Stage estagio;


  @Override
  public void start(Stage stage) throws Exception {
    estagio = stage;
    FXMLLoader telaLoginLoader = new FXMLLoader(getClass().getResource(Telas.TELA_LOGIN.caminho()));
    Scene cenaTelaLogin = new Scene(telaLoginLoader.load());

    estagio.setScene(cenaTelaLogin);
    estagio.setTitle("Cook's Books");

    estagio.show();
  }

  public static void main(String[] args) {
    launch();
  }

  public void alterarTela(Telas tela) throws IOException {
    FXMLLoader novaTelaLoader = new FXMLLoader(getClass().getResource(tela.caminho()));
    Scene novaCena = new Scene(novaTelaLoader.load());

    ControladorGUI controller = novaTelaLoader.getController();
    controller.setApp(this);

    estagio.setScene(novaCena);
  }

  public void alterarTela(Telas tela, DataSender sender) throws IOException {
    FXMLLoader novaTelaLoader = new FXMLLoader(getClass().getResource(tela.caminho()));
    Scene novaCena = new Scene(novaTelaLoader.load());

    Object controllerObj = novaTelaLoader.getController();

    ((ControladorGUI) controllerObj).setApp(this);
    DataReceiver receiver = (DataReceiver) controllerObj;
    receiver.setInformation(sender.getInformation());

    estagio.setScene(novaCena);
  }

}
