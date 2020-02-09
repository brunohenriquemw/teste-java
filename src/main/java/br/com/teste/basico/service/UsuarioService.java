package br.com.teste.basico.service;

import br.com.teste.basico.entity.Usuario;
import java.util.List;

public interface UsuarioService {

    Usuario buscarUsuario(long codigo);
    List<Usuario> listarUsuarios();
    void gravarUsuario(Usuario usuario);
    void atualizarUsuario(Usuario usuario);

}
