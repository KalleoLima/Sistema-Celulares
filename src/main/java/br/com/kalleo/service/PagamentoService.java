package br.com.kalleo.service;

import br.com.kalleo.cli.logicaServiceCli;
import br.com.kalleo.domain.user.Cliente;

public class PagamentoService {
//constructor and class
private logicaServiceCli logicaService;
    private Cliente cliente;
    private int frete = 3;

    public void setLogicaService(logicaServiceCli logicaService) {
        this.logicaService = logicaService;
    }

    public void logicaPagamento(double total) {
        if (cliente.getSaldo() > total) {
            double saldo = cliente.getSaldo() - (total + frete);
            cliente.setSaldo(saldo);



        } else {
            System.out.println("saldo insuficiente");
        }


}


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
