

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc =
            new Scanner(System.in);

    public static void main(String[] args) {

        ArquivoUtil.criarPastasEArquivos();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");

            System.out.println("1 - Cadastrar Pessoa");
            System.out.println("2 - Listar Pessoas");

            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Listar Produtos");

            System.out.println("5 - Cadastrar Pedido");
            System.out.println("6 - Listar Pedidos");

            System.out.println("0 - Sair");

            System.out.print("Escolha: ");

            opcao = lerInteiro();

            switch (opcao) {

                case 1:
                    cadastrarPessoa();
                    break;

                case 2:
                    listarPessoas();
                    break;

                case 3:
                    cadastrarProduto();
                    break;

                case 4:
                    listarProdutos();
                    break;

                case 5:
                    cadastrarPedido();
                    break;

                case 6:
                    listarPedidos();
                    break;

                case 0:
                    System.out.println(
                            "Sistema encerrado."
                    );
                    break;

                default:
                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);
    }

    static int lerInteiro() {

        return Integer.parseInt(
                sc.nextLine()
        );
    }

    static double lerDouble() {

        return Double.parseDouble(
                sc.nextLine()
        );
    }

    // =========================
    // PESSOA
    // =========================

    static void cadastrarPessoa() {

        System.out.print("Código: ");
        int codigo = lerInteiro();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Tipo: ");
        String tipo = sc.nextLine();

        Pessoa p =
                new Pessoa(
                        codigo,
                        nome,
                        tipo
                );

        ArquivoUtil.adicionarLinha(
                "dados/pessoas.txt",
                p.toLinhaArquivo()
        );

        LogUtil.registrar(
                "Pessoa cadastrada: " +
                codigo
        );

        System.out.println(
                "Pessoa cadastrada."
        );
    }

    static void listarPessoas() {

        List<String> linhas =
                ArquivoUtil.lerLinhas(
                        "dados/pessoas.txt"
                );

        for (String linha : linhas) {

            Pessoa p =
                    Pessoa
                    .fromLinhaArquivo(
                            linha
                    );

            System.out.println(p);
        }
    }

    // =========================
    // PRODUTO
    // =========================

    static void cadastrarProduto() {

        System.out.print("Código: ");
        int codigo = lerInteiro();

        System.out.print("Descrição: ");
        String descricao =
                sc.nextLine();

        System.out.print("Custo: ");
        double custo =
                lerDouble();

        System.out.print(
                "Preço venda: "
        );

        double preco =
                lerDouble();

        System.out.print(
                "Fornecedor: "
        );

        int fornecedor =
                lerInteiro();

        Produto p =
                new Produto(
                        codigo,
                        descricao,
                        custo,
                        preco,
                        fornecedor
                );

        ArquivoUtil.adicionarLinha(
                "dados/produtos.txt",
                p.toLinhaArquivo()
        );

        LogUtil.registrar(
                "Produto cadastrado: " +
                codigo
        );

        System.out.println(
                "Produto cadastrado."
        );
    }

    static void listarProdutos() {

        List<String> linhas =
                ArquivoUtil.lerLinhas(
                        "dados/produtos.txt"
                );

        for (String linha : linhas) {

            Produto p =
                    Produto
                    .fromLinhaArquivo(
                            linha
                    );

            System.out.println(p);
        }
    }

    // =========================
    // PEDIDO
    // =========================

    static void cadastrarPedido() {

        System.out.print(
                "Número pedido: "
        );

        int numero =
                lerInteiro();

        System.out.print(
                "Código cliente: "
        );

        int cliente =
                lerInteiro();

        System.out.print(
                "Endereço entrega: "
        );

        String endereco =
                sc.nextLine();

        Pedido pedido =
                new Pedido(
                        numero,
                        cliente,
                        endereco
                );

        while (true) {

            System.out.print(
                    "Código produto: "
            );

            int codProduto =
                    lerInteiro();

            System.out.print(
                    "Quantidade: "
            );

            int qtd =
                    lerInteiro();

            System.out.print(
                    "Valor unitário: "
            );

            double valor =
                    lerDouble();

            pedido.adicionarItem(
                    new ItemPedido(
                            codProduto,
                            qtd,
                            valor
                    )
            );

            System.out.print(
                    "Adicionar mais? (s/n): "
            );

            String op =
                    sc.nextLine();

            if (!op.equalsIgnoreCase(
                    "s")) {

                break;
            }
        }

        ArquivoUtil.adicionarLinha(
                "dados/pedidos.txt",
                pedido.toLinhaArquivo()
        );

        LogUtil.registrar(
                "Pedido cadastrado: " +
                numero
        );

        System.out.println(
                "Pedido cadastrado."
        );
    }

    static void listarPedidos() {

        List<String> linhas =
                ArquivoUtil.lerLinhas(
                        "dados/pedidos.txt"
                );

        for (String linha : linhas) {

            Pedido p =
                    Pedido
                    .fromLinhaArquivo(
                            linha
                    );

            System.out.println(p);

            for (ItemPedido item :
                    p.getItens()) {

                System.out.println(item);
            }
        }
    }
}