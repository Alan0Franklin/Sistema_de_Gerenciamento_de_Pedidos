# Sistema de Gerenciamento de Pedidos
Um sistema para gerenciamento de pedidos recebidos, capaz de registrar novos pedidos, remover pedidos existentes e listar todos os pedidos ativos de forma organizada. Possui uma classe principal Sistema e duas classes Pedido e Item que representam as entidades desse sistema.


## Sumário

- [1. Estrutura](#1-estrutura)
- [2. Descrição das Funções](#2-descricao_das_classes)

---

## Estrutura <a name="1-estrutura"></a>
```
Sistema_de_Gerenciamento_de_Pedidos/
├── src/
│   └── LAB_1/
│       ├── Item.java
│       ├── Pedido.java
│       └── Sistema.java
└── README.md
```

## Descrição das Classes <a name="2-descricao_das_classes"></a>

### a) public class Pedido
Classe `Pedido` que representa um dado pedido de um cliente.
- private static int `nextId`: Número inteiro que se mantém estático para todos os objetos da classe `Pedido`, é o que permite o programa gerar `id_pedido`'s sequenciais para cada `Pedido`, começando em 1.
- private int `id_pedido`: Número inteiro que representa o número de identificação do pedido.
- private String `nome_cliente`: String o qual deseja-se definir como nome do cliente.
- private ArrayList<Item> `lista_itens`: Uma lista dinâmica (ArrayList) de itens que um dado cliente incluiu no pedido.

#### + public Pedido(Scanner cin)
Construtor para criar um objeto `Pedido` que autoincrementa o `id_pedido` com ajuda do `nextId`, além de atribuir o `nome_cliente` e os itens em `lista_itens` (com o `nome_item` e o `preco_item` de cada um) aos atributos do objeto `Pedido` com as entradas do console recebidas através do `cin`. Caso os valores inteiros lidos do console para a atribuição de certas variáveis estejam fora do intervalo de valores que essas variáveis podem assumir - por exemplo, definir que a quantidade de itens para serem inseridos no pedido seja `0` ou definir que o preço de um item seja `-1,00` -, o programa exibe uma mensagem de erro e insiste que o usuário insira outro número até que ele seja considerado válido.
- Scanner `cin`: Scanner que lê do console as entradas necessárias para se inicializar cada atributo do `Pedido`.

#### + public void resumo_pedido()
Método para exibir as informações do `Pedido`, no caso seu `id_pedido`, `nome_cliente` e os itens `lista_itens`, tal como seus `nome_item` e `preco_item`.

#### + public double valor_total_itens()
Método para somar o preço de todos os itens na `lista_itens` de um `Pedido`. Retornando o valor total dos itens em formato de número flutuante.

#### + public int getId_pedido()
Método para acessar o `id_pedido` do pedido. Retornando o número de identificação do pedido em formato de número inteiro.

---

### b) public class Item
Classe `Item` que representa os itens que um dado cliente pediu e presumivelmente deseja comprar.
- private String `nome_item`: String o qual deseja-se definir como nome do item.
- private double `preco_item`: Número flutante que representa o preço do item.

#### + public Item(String nome_item, double preco_item)
Construtor para criar um objeto `Item` que atribui o `nome_item` e o `preco_item` aos atributos do objeto `Item`.
- String `nome_item`: String o qual deseja-se definir como o nome do item.
- double `preco_item`: Número flutante o qual deseja-se definir como o preço do item.

#### + public String getNome_item()
Método para acessar o atributo `nome_item` do item. Retornando o nome do item em formato de String.

#### + public double getPreco_item()
Método para acessar o atributo `preco_item` do item. Retornando o preço em formato de número flutuante.

---

### c) public class Sistema
Classe principal `Sistema` que contém a função `main` que executa o programa. O sistema é executado via console e apresenta um menu principal com as seguintes operações que podem ser realizadas: 

#### 1 - Registrar Pedido:
O sistema inicializa uma variável `Pedido` a qual é armazenada em uma lista dinâmica (ArrayList) de pedidos. É nesta operação que se solicitam os dados do pedido, como o `nome_cliente`, a quantidade de itens que vão ser adicionados em `lista_itens` e as informações de cada item - que são o `nome_item` e o `preco_item` -. Além de gerar automaticamente o `id_pedido` de forma sequencial e distinta para cada novo pedido. Após esse registro, o sistema exibe o resumo do pedido recém-criado.

#### 2 - Remover Pedido: 
O sistema solicita o `id_pedido` do número do pedido que o usuário deseja remover. Caso o pedido exista, ele será removido da lista. Caso contrário, uma mensagem de erro é exibida.

#### 3 - Listar Pedidos: 
O sistema exibe todos os pedidos registrados. A exibição se mantém ordenada crescentemente em relação ao número do pedido. Isso é garantido pela lógica ao adicioná-la na lista dinâmica de pedidos, mas também com a aplicação de uma função de ordenação que possui como comparador o número de identificação de um pedido. Para cada pedido, são mostradas seus `id_pedido`, `nome_cliente`, itens em `lista_itens` (com o `nome_item` e o `preco_item` de cada um) e o valor total do pedido (calculado dinamicamente pela soma dos preços de seus itens).

#### 4 - Sair:
Encerra a execução do programa.

Caso se dê entrada em um número de operação não reconhecido, o programa exibe uma mensagem de erro e regressa ao menu principal para a inserção de outro número até que ele seja considerado válido.
