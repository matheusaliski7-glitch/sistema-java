public class Endereco {

    private int codigoPessoa;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String tipoEndereco;

    public Endereco(int codigoPessoa,
                     String cep,
                     String logradouro,
                     int numero,
                     String complemento,
                     String tipoEndereco) {

        this.codigoPessoa = codigoPessoa;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.tipoEndereco = tipoEndereco;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public String toLinhaArquivo() {

        return codigoPessoa + ";" +
               cep + ";" +
               logradouro + ";" +
               numero + ";" +
               complemento + ";" +
               tipoEndereco;
    }

    public static Endereco fromLinhaArquivo(
            String linha) {

        String[] p = linha.split(";");

        return new Endereco(
                Integer.parseInt(p[0]),
                p[1],
                p[2],
                Integer.parseInt(p[3]),
                p[4],
                p[5]
        );
    }

    @Override
    public String toString() {

        return "Pessoa: " + codigoPessoa +
               " | CEP: " + cep +
               " | Logradouro: " + logradouro +
               " | Número: " + numero +
               " | Complemento: " + complemento +
               " | Tipo: " + tipoEndereco;
    }
}