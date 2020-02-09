package br.com.teste.basico.controller;


import br.com.teste.basico.entity.Usuario;
import br.com.teste.basico.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;


    /* PRIORIDADE: NECESSÁRIA
    * Por algum motivo nosso cliente fez uma bagunça no banco de dados e estragou alguns registros,
    * caso o código do usuário que ele esteja procurando seja algum dos abaixo não devemos retornar
    * dado algum para ele:
    *
    * 4, 14, 33, 28, 11, 87, 144, 15, 7, 98
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUsuario(@PathVariable("id") long codigo) {

        /*
        * Esta funcionalidade possui diversas implementações, a que estou deixando
        * abaixo é uma das mais simples e fáceis de fazer, porém não é uma das melhores
        * em questão de performance.
        */
        for (long codigoComProblema : new long[] {4, 14, 33, 28, 11, 87, 144, 15, 7, 98}) {
            if (codigo == codigoComProblema) {
                return null;
            }
        }

        return ResponseEntity.ok(this.usuarioServiceImpl.buscarUsuario(codigo));
    }


    /* PRIORIDADE: OPCIONAL
    * Seria interessante implementar uma funcionalidade para listar todos os usuários do banco de dados,
    * nosso cliente já nos pediu algumas vezes, porém não estamos com muito tempo para fazer.
    *
    * Obs.: Considere que será necessário alterar no service também.
    *
    * Dica: Procure por "implementar findAll com springboot e jpa".
    */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET, produces = "application/json")
    public List<Usuario> listarUsuarios() {
        return this.usuarioServiceImpl.listarUsuarios();
    }


    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = "application/json")
    public void gravarUsuario(@RequestBody Usuario usuario) {
        this.usuarioServiceImpl.gravarUsuario(usuario);
    }


    /*
    * Utilizamos PUT quando queremos fazer atualizações.
    */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT, consumes = "application/json")
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        this.usuarioServiceImpl.atualizarUsuario(usuario);
    }


}
