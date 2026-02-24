package br.com.kalleo.service;

import br.com.kalleo.cli.logicaServiceCli;
import br.com.kalleo.repository.ProdutoRepository;

import java.util.HashSet;
import java.util.Set;

public class CarrinhoService {

    ProdutoService produto;
    ProdutoRepository produtoRepository;
    PagamentoService pagamentoService;
    double valorPagamento;
    String produtoPago;
    Set<String> produtosDocarrinho = new HashSet<>();

logicaServiceCli cli = new logicaServiceCli();

    public void setCli(logicaServiceCli cli) {
        this.cli = cli;
    }

    public void addCarrinho(String aparelho) {
        // aqui chamo o metodo do produtoservice para verificar
        String resultado = produto.verifcandoProduto(aparelho);
        if (resultado != null) {
            produtosDocarrinho.add(resultado);
            System.out.println("adicionado no carrinho");
            // podemos add um cli aqui, pra dizer no system "adicionado no carrinho"
// cli.Decisao(); isso aqui  nao vai ser necessario nesse conjunto, melhor, nao agora!
        } else {
            System.out.println("Esse produto nao foi adicionado ao carrinho");
        }

    }

    public void fazerCompraDoCarrinho() {
        // Reduz o estoque de todos os produtos no carrinho
        System.out.println("\n--- Atualizando estoque ---");
        for (String nomeProduto : produtosDocarrinho) {
            produtoRepository.reduzirEstoque(nomeProduto, 1);
        }

        calculandoValor();
    }


    public double calculandoValor() {
        valorPagamento = 0d;

        for (String x : produtosDocarrinho) {
            valorPagamento += produtoRepository.buscandoPorNome(x);
        }

        //  vamos dar esse valor para PagamentoService
        pagamentoService.logicaPagamento(valorPagamento);

        return valorPagamento;

    }
public void produtosCarrinho(){
        for (String interador: produtosDocarrinho){
            System.out.println(interador);
        }
}

    public void removerCarrinho(String recebeItem) {

        boolean verificacao = produtosDocarrinho.remove(recebeItem);
        System.out.println("removeu o produto " + recebeItem);
    }





    public Set<String> getProdutosDocarrinho() {
        return produtosDocarrinho;
    }

    public void setProdutosDocarrinho(Set<String> produtosDocarrinho) {
        this.produtosDocarrinho = produtosDocarrinho;
    }

    public PagamentoService getPagamentoService() {
        return pagamentoService;
    }

    public void setPagamentoService(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    public ProdutoService getProduto() {
        return produto;
    }

    public void setProduto(ProdutoService produto) {
        this.produto = produto;
    }

    public ProdutoRepository getProdutoRepository() {
        return produtoRepository;
    }

    public void setProdutoRepository(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

}