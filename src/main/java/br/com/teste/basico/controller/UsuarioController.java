package br.com.teste.basico.controller;


import br.com.teste.basico.entity.Usuario;
import br.com.teste.basico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    /* PRIORIDADE: NECESSÁRIA
    * Por algum motivo nosso cliente fez uma bagunça no banco de dados e estragou alguns registros,
    * caso o código do usuário que ele esteja procurando seja algum dos abaixo não devemos retornar
    * dado algum para ele:
    *
    * 4, 14, 33, 28, 11, 87, 144, 15, 7, 98
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsuario(@PathVariable("id") long codigo) {
        return ResponseEntity.ok(this.usuarioService.buscarUsuario(codigo));
    }


    /* PRIORIDADE: OPCIONAL
    * Seria interessante implementar uma funcionalidade para listar todos os usuários do banco de dados,
    * nosso cliente já nos pediu algumas vezes, porém não estamos com muito tempo para fazer.
    *
    * Obs.: Considere que será necessário alterar no service também.
    *
    * Dica: Procure por "implementar findAll com springboot e jpa".
    */


    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = "application/json")
    public void gravarUsuario(@RequestBody Usuario usuario) {
        this.usuarioService.gravarUsuario(usuario);
    }


}
