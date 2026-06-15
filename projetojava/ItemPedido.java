public class ItemPedido {

    private int codigoProduto;
    private int quantidade;
    private double valorUnitario;

    public ItemPedido(int codigoProduto,
                      int quantidade,
                      double valorUnitario) {

        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public double getSubtotal() {

        return quantidade * valorUnitario;
    }

    public String toTexto() {

        return codigoProduto + "," +
               quantidade + "," +
               valorUnitario;
    }

    public static ItemPedido fromTexto(String txt) {

        String[] p = txt.split(",");

        return new ItemPedido(
                Integer.parseInt(p[0]),
                Integer.parseInt(p[1]),
                Double.parseDouble(p[2])
        );
    }

    @Override
    public String toString() {

        return "Produto: " + codigoProduto +
               " | Quantidade: " + quantidade +
               " | Subtotal: R$ " +
               getSubtotal();
    }
}