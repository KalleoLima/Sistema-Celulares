# Sistema de Pedidos

Projeto Java para gerenciamento de pedidos, carrinho de compras e produtos.

## Requisitos
- Java 21+
- Gradle 8.5+

## Como executar

### Compilar o projeto:
```bash
gradlew build
```

### Executar a aplicação:
```bash
gradlew run
```

## Estrutura do Projeto
```
src/main/java/br/com/kalleo/
├── App.java              # Classe principal
├── cli/                  # Interface de linha de comando
├── domain/               # Entidades de domínio
│   ├── cart/            # Carrinho de compras
│   ├── order/           # Pedidos
│   ├── product/         # Produtos
│   └── user/            # Usuários
├── repository/          # Camada de persistência
└── service/             # Lógica de negócio
```

## Funcionalidades
- Gerenciamento de produtos
- Carrinho de compras
- Sistema de pedidos
- Cálculo de frete
- Processamento de pagamentos
