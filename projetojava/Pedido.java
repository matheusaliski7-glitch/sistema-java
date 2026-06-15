import java.util.ArrayList;

public class Pedido {

    private int numeroPedido;
    private int codigoCliente;
    private String enderecoEntrega;

    private ArrayList<ItemPedido> itens =
            new ArrayList<>();

    public Pedido(int numeroPedido,
                  int codigoCliente,
                  String enderecoEntrega) {

        this.numeroPedido = numeroPedido;
        this.codigoCliente = codigoCliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void adicionarItem(ItemPedido item) {

        itens.add(item);
    }

    public double getTotal() {

        double total = 0;

        for (ItemPedido i : itens) {
            total += i.getSubtotal();
        }

        return total;
    }

    public String toLinhaArquivo() {

        String textoItens = "";

        for (int i = 0; i < itens.size(); i++) {

            textoItens += itens.get(i).toTexto();

            if (i < itens.size() - 1) {
                textoItens += "|";
            }
        }

        return numeroPedido + ";" +
               codigoCliente + ";" +
               enderecoEntrega + ";" +
               textoItens;
    }

    public static Pedido fromLinhaArquivo(String linha) {

        String[] p = linha.split(";");

        Pedido pedido = new Pedido(
                Integer.parseInt(p[0]),
                Integer.parseInt(p[1]),
                p[2]
        );

        if (p.length > 3) {

            String[] itens = p[3].split("\\|");

            for (String item : itens) {

                pedido.adicionarItem(
                        ItemPedido.fromTexto(item)
                );
            }
        }

        return pedido;
    }

    @Override
    public String toString() {

        return "Pedido: " + numeroPedido +
               " | Cliente: " + codigoCliente +
               " | Total: R$ " + getTotal();
    }
}