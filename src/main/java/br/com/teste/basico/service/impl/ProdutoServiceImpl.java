package br.com.teste.basico.service.impl;


import br.com.teste.basico.entity.Produto;
import br.com.teste.basico.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProdutoServiceImpl {

    @Autowired
    private ProdutoRepository produtoRepository;

    /* PRIORIDADE: NECESSÁRIA
    * Para a funcionalidade de inclusão dos produtos, caso o tipo seja "ELETRÔNICO" e
    * o valor seja inferior a R$ 100,00, não devemos gravar no banco de dados.*/
    public void inserirProduto(Produto produto) {
        if (!(produto.getTipo().equals("ELETRÔNICO") && produto.getPreco() < 100)) {
            this.produtoRepository.save(produto);
        }
    }


    public List<Produto> listarProdutos() {
        return this.produtoRepository.findAll();
    }

}
