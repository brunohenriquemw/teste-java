package br.com.teste.basico.service;

import br.com.teste.basico.entity.Produto;
import java.util.List;

public interface ProdutoService {

    void inserirProduto(Produto produto);
    List<Produto> listarProdutos();

}
