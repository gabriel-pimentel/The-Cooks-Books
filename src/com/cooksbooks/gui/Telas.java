package com.cooksbooks.gui;

public enum Telas {
  TELA_CADASTRO("gui/views/TelaCadastro.fxml"),
  TELA_LOGIN("gui/views/TelaLogin.fxml"),
  TELA_CRIACAO_CADERNO("gui/views/TelaCriacaoCaderno.fxml"),
  TELA_CRIACAO_RECEITA("gui/views/TelaCriacaoReceita.fxml"),
  TELA_PRINCIPAL_USUARIO("gui/views/TelaPrincipalUsuario.fxml"),
  TELA_PERFIL("gui/views/TelaPerfil.fxml"),
  TELA_EDITAR_PERFIL("gui/views/TelaEditarPerfil.fxml"),
  TELA_CADERNO("gui/views/TelaDoCaderno.fxml"),
  TELA_RESULTADOS_PESQUISA("gui/views/TelaResultadosPesquisa.fxml");

  private final String caminho;

  Telas(String caminho) {
    this.caminho = caminho;
  }

  public String caminho() {
    return this.caminho;
  }
}
