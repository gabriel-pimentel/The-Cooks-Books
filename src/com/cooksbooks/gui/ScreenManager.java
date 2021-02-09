package com.cooksbooks.gui;

import com.cooksbooks.gui.controllers.ControladorAdm;
import com.cooksbooks.gui.controllers.ControladorTelaCadastro;
import com.cooksbooks.gui.controllers.ControladorTelaCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoRec;
import com.cooksbooks.gui.controllers.ControladorTelaEditarCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaEditarPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaEditarReceita;
import com.cooksbooks.gui.controllers.ControladorTelaLogin;
import com.cooksbooks.gui.controllers.ControladorTelaPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaPrincipal;
import com.cooksbooks.gui.controllers.ControladorTelaReceita;
import com.cooksbooks.gui.controllers.ControladorTelaUsuarioPesquisado;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {


  private static Stage stagePrincipal;
  private static ScreenManager instancia;
  private Scene telaCadastro, telaCriacaoCaderno, telaCriacaoReceita, telaCaderno,
      telaEditarCaderno, telaEditarPerfil, telaLogin,
      telaPerfil, telaPrincipalUsuario, telaResultadosPesquisa;

  private ControladorAdm controladorAdm;
  private ControladorTelaCadastro controladorTelaCadastro;
  private ControladorTelaCaderno controladorTelaCaderno;
  private ControladorTelaCriacaoRec controladorTelaCriacaoRec;
  private ControladorTelaEditarCaderno controladorTelaEditarCaderno;
  private ControladorTelaEditarPerfil controladorTelaEditarPerfil;
  private ControladorTelaEditarReceita controladorTelaEditarReceita;
  private ControladorTelaLogin controladorTelaLogin;
  private ControladorTelaPerfil controladorTelaPerfil;
  private ControladorTelaPrincipal controladorTelaPrincipal;
  private ControladorTelaReceita controladorTelaReceita;
  private ControladorTelaUsuarioPesquisado controladorTelaUsuarioPesquisado;


  public ScreenManager getInstancia() throws IOException {
    if (instancia == null) {
      instancia = new ScreenManager();
    }

    return instancia;
  }

  private ScreenManager() throws IOException {
    FXMLLoader loaderTelaCadastro = new FXMLLoader(getClass().getResource(Telas.TELA_CADASTRO.caminho()));
    telaCadastro = new Scene(loaderTelaCadastro.load());
    controladorTelaCadastro = loaderTelaCadastro.getController();

    FXMLLoader loaderTelaCriacaoCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_CADERNO.caminho()));
    telaCriacaoCaderno = new Scene(loaderTelaCriacaoCaderno.load());
    controladorTelaCadastro = loaderTelaCriacaoCaderno.getController();

    FXMLLoader loaderTelaCriacaoReceita = new FXMLLoader(getClass().getResource(Telas.TELA_CRIACAO_RECEITA.caminho()));
    telaCriacaoReceita = new Scene(loaderTelaCriacaoReceita.load());
    controladorTelaCriacaoRec = loaderTelaCriacaoReceita.getController();
  }

  public void setStagePrincipal(Stage stage) {
    stagePrincipal = stage;
  }
  
}
