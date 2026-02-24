package br.com.kalleo.service;

import br.com.kalleo.domain.product.Produto;
import br.com.kalleo.repository.ProdutoRepository;

import javax.swing.*;

public class ProdutoService {





     ProdutoRepository produtoRepository;


//    public ProdutoService(ProdutoRepository produtoRepository) {
//        this.produtoRepository = produtoRepository;
//    }


     public void produtosDisponiveis(){
        produtoRepository.getProdutos().stream()
                .filter(p -> p.getEstoque() >= 1)
                .filter(Produto::isDisponibilidade)
                .forEach(p -> System.out.println(p.getNameProduto()));
    }



    public String verifcandoProduto(String produto) {
        String returnAlgo = null;

       for (Produto p: produtoRepository.getProdutos()) {
           if (p.getNameProduto().equalsIgnoreCase(produto)) {
               returnAlgo = produto  ;
           }
// método para chegar todos os produtos, porque do jeito que esta, so da true se for o primeiro da lista
           }

       return returnAlgo;

    }



    public void setProdutoRepository(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public ProdutoRepository getProdutoRepository() {
        return produtoRepository;
    }
}
