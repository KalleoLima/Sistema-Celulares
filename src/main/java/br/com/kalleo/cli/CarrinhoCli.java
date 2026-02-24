package br.com.kalleo.cli;

import br.com.kalleo.domain.product.Produto;
import br.com.kalleo.repository.ProdutoRepository;
import br.com.kalleo.service.CarrinhoService;
import br.com.kalleo.service.ProdutoService;

import java.util.Scanner;

public class CarrinhoCli {

    private final Scanner input = new Scanner(System.in);
    ProdutoRepository produtoRepository;
    ProdutoService produtoService;
    CarrinhoService carrinhoService;


    public CarrinhoCli(ProdutoRepository produtoRepository
            , ProdutoService produtoService,
                       CarrinhoService carrinhoService) {

    this.produtoRepository = produtoRepository;
    this.produtoService = produtoService;
    this.carrinhoService = carrinhoService;



    }

    public void metodoParaTestePagamento() {


        System.out.println("Produtos disponiveis: ");

        produtoService.produtosDisponiveis();
        System.out.println();
        System.out.println("Digite o nome do produto que você quer:");
        String resposta = input.nextLine();

        carrinhoService.addCarrinho(resposta);


    }
    public void onlySystem(double valor){
        System.out.println("preço total dos produtos: " + valor);

    }


}
