package br.com.teste.basico.service;


import br.com.teste.basico.entity.Usuario;
import br.com.teste.basico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/* PRIORIDADE: OPCIONAL
* Este código não está muito adequado aos padrões de programação do springboot,
* é interessante que todos os services tenham uma interface que os represente.
*/
@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario buscarUsuario(long codigo) {
         return this.usuarioRepository.findByCodigo(codigo);
    }


    /* PRIORIDADE: OPCIONAL
    * A funcionalidade de gravar usuário funciona bem, porém ela precisa de um pequeno ajuste,
    * caso o usuário envie um nome assim "   joão", teremos uma informação mal formatada no
    * banco de dados, pois seria interessante gravar no banco de dados "joão".
    */
    public void gravarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }


    /* PRIORIDADE: NECESSÁRIA
    * Precisamos implementar uma nova funcionalidade neste service, pois os usuários precisam
    * alterar as informações de um usuário de vez em quando. Como validação precisamos garantir
    * que todos os dados do usuário estão preenchidos.
    *
    * Obs: Uma string em branco deve ser considerada como um dado não preenchido, mesmo que existam
    * apenas espaços em branco nela.
    *
    * Dica: procure por "springboot update entity with jpa".
    */


}
