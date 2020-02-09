package br.com.teste.basico.entity;

import javax.persistence.*;

/* PRIORIDADE: NECESSÁRIA
* Precisamos implementar uma nova tabela do banco de dados chamada PRODUTO,
* esta nova tabela deverá ter a seguinte estrutura:
*
* 1. codigo (no banco de dados ela tem o tipo INT e é uma chave primária)
* 2. nome (no banco de dados ela tem o tipo VARCHAR(100) e é obrigatória)
* 3. tipo (no banco de dados ela tem o tipo VARCHAR(100) e é obrigatória)
* 4. preco (no banco de dados ela tem o tipo NUMERIC(10,2) e é obrigatória)
* 5. descricao (no banco de dados ela tem o tipo VARCHAR(500) e é opcional)
*
* Dica: A outra entity já criada é um bom exemplo, mas você precisa explorar
*       um pouco melhor as opções das colunas para garantir as restrições.
*/
@Entity(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODIGO")
    private long codigo;

    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @Column(name = "TIPO", length = 100, nullable = false)
    private String tipo;

    @Column(name = "PRECO", nullable = false)
    private double preco;

    @Column(name = "DESCRICAO", length = 100, nullable = true)
    private String descricao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
