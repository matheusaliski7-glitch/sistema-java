public class Pessoa {

    private int codigo;
    private String nome;
    private String tipoPessoa;

    public Pessoa(int codigo, String nome, String tipoPessoa) {

        this.codigo = codigo;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public String toLinhaArquivo() {

        return codigo + ";" +
               nome + ";" +
               tipoPessoa;
    }

    public static Pessoa fromLinhaArquivo(String linha) {

        String[] p = linha.split(";");

        return new Pessoa(
                Integer.parseInt(p[0]),
                p[1],
                p[2]
        );
    }

    @Override
    public String toString() {

        return "Código: " + codigo +
               " | Nome: " + nome +
               " | Tipo: " + tipoPessoa;
    }
}