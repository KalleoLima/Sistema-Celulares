package br.com.kalleo;

import br.com.kalleo.cli.CarrinhoCli;
import br.com.kalleo.cli.logicaServiceCli;
import br.com.kalleo.domain.order.StatusPedido;
import br.com.kalleo.domain.product.Produto;
import br.com.kalleo.domain.user.Cliente;
import br.com.kalleo.repository.ProdutoRepository;
import br.com.kalleo.service.CarrinhoService;
import br.com.kalleo.service.FreteService;
import br.com.kalleo.service.PagamentoService;
import br.com.kalleo.service.PedidoService;
import br.com.kalleo.service.ProdutoService;

import java.util.Scanner;

import static br.com.kalleo.domain.product.Categorias.categorias.android;
import static br.com.kalleo.domain.product.Categorias.categorias.iphone;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 1) Frete (depende do seu construtor)
        FreteService frete = new FreteService("rua baao");

        // 2) Cliente
        Cliente cliente = new Cliente();
        cliente.setSaldo(9000);

        // 3) Pedido (cria ANTES e injeta no CLI pra não ficar null)
        PedidoService pedido = new PedidoService();
        pedido.setNome(cliente.getName()); // se seu Cliente usa outro getter, ajuste aqui
        pedido.setValor(0);                // valor real você pode atualizar depois
        pedido.setLocalizacao("");         // vai ser preenchido quando digitar o endereço

        // 4) CLI (injeções: frete + pedido)
        logicaServiceCli cli = new logicaServiceCli();
        cli.setFrete(frete);

        cli.setNome(cliente);

        // 5) PagamentoService (injeções: cliente + cli)
        PagamentoService pagamentoService = new PagamentoService();
        pagamentoService.setCliente(cliente);
        pagamentoService.setLogicaService(cli); // <-- precisa existir esse setter no PagamentoService

        // 6) Produto + Repo
        Produto addProdutoSamsung = new Produto();
        addProdutoSamsung.Produtoo("M52 5G", android,2000d,true,500);

        Produto addProdutoIphone = new Produto();
        addProdutoIphone.Produtoo("iphone 8", iphone,3000d,true,1000);

        ProdutoRepository repo = new ProdutoRepository();
        repo.addProdutoo(addProdutoSamsung);
        repo.addProdutoo(addProdutoIphone);

        // 7) ProdutoService
        ProdutoService produtoService = new ProdutoService();
        produtoService.setProdutoRepository(repo);


        // 8) CarrinhoService
        CarrinhoService carrinho = new CarrinhoService();
        carrinho.setProduto(produtoService);
        carrinho.setPagamentoService(pagamentoService);
        carrinho.setProdutoRepository(repo);


        cli.setCarrinhoService(carrinho);
carrinho.setCli(cli);

        // 9) CarrinhoCli
        CarrinhoCli carrinhoCli = new CarrinhoCli(repo, produtoService, carrinho);



        // 10) Atualiza o pedido depois do fluxo (opcional, mas útil)
        pedido.setLocalizacao(frete.getLocal());
        pedido.setValor(carrinho.getValorPagamento());

        //11) atualizar StatusPedido
        StatusPedido statusPedido = new StatusPedido();
statusPedido.setLogicaServiceCli(cli);


        // menu produto

        boolean opcao = true;
  while (opcao ){

      int number = 0;
      System.out.println("escolha opção abaixo");
      System.out.println("digite 1 para colocar no carrinho");
      System.out.println("digite 2 para fazer compra do produtos do carrinho");
      System.out.println("digite 3 para remover produto");
      System.out.println("digite 4 para sair");
number = input.nextInt();
      if (number == 1){
          produtoService.ProdutosDisponiveis();
          carrinhoCli.MetodoParaTestePagamento();
      }if (number == 2){
      cli.fazerCompra();
      }if (number == 3){
cli.removerProduto();
      }else if (number == 4 | number > 4){opcao = false;}
  };


    }
}