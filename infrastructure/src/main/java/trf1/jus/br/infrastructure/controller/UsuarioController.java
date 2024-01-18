package trf1.jus.br.infrastructure.controller;

import br.jus.trf1.usecase.usuario.BuscarUsuarioUC;

public class UsuarioController {

    private final BuscarUsuarioUC buscarUsuarioUC;

    public UsuarioController(BuscarUsuarioUC buscarUsuarioUC) {
        this.buscarUsuarioUC = buscarUsuarioUC;
    }
}
