public class Produto {

    private int codigo;
    private String descricao;
    private double custo;
    private double precoVenda;
    private int codigoFornecedor;

    public Produto(int codigo,
                   String descricao,
                   double custo,
                   double precoVenda,
                   int codigoFornecedor) {

        this.codigo = codigo;
        this.descricao = descricao;
        this.custo = custo;
        this.precoVenda = precoVenda;
        this.codigoFornecedor = codigoFornecedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public String toLinhaArquivo() {

        return codigo + ";" +
               descricao + ";" +
               custo + ";" +
               precoVenda + ";" +
               codigoFornecedor;
    }

    public static Produto fromLinhaArquivo(String linha) {

        String[] p = linha.split(";");

        return new Produto(
                Integer.parseInt(p[0]),
                p[1],
                Double.parseDouble(p[2]),
                Double.parseDouble(p[3]),
                Integer.parseInt(p[4])
        );
    }

    @Override
    public String toString() {

        return "Código: " + codigo +
               " | Produto: " + descricao +
               " | Venda: R$ " + precoVenda;
    }
}