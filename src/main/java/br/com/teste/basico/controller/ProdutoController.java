package br.com.teste.basico.controller;


import br.com.teste.basico.entity.Produto;
import br.com.teste.basico.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/* PRIORIDADE: NECESSÁRIA
 * Para utilizar a entity Produto, será necessário criar um novo controller,
 * que deverá ter duas rotas, uma para inserir um novo produto e outra
 * para listar todos os produtos existentes no banco de dados.
 *
 * Obs.: Não esqueça de alterar o service e criar o repository para utilizar este controller.
 *
 * Dica: Tome como base o outro controller já criado.
 */

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;


    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST, consumes = "application/json")
    public void inserirProduto(@RequestBody Produto produto) {
        this.produtoServiceImpl.inserirProduto(produto);
    }


    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET, produces = "application/json")
    public List<Produto> listarProdutos() {
        return this.produtoServiceImpl.listarProdutos();
    }

}
