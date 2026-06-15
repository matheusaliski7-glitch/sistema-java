import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    public static void criarPastasEArquivos() {

        try {

            File pasta = new File("dados");

            if (!pasta.exists()) {
                pasta.mkdir();
            }

            criarArquivo("dados/pessoas.txt");
            criarArquivo("dados/produtos.txt");
            criarArquivo("dados/pedidos.txt");
            criarArquivo("dados/log.txt");

        } catch (Exception e) {

            System.out.println(
                    "Erro ao criar arquivos."
            );
        }
    }

    private static void criarArquivo(String caminho)
            throws IOException {

        File arquivo = new File(caminho);

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    public static void adicionarLinha(
            String caminho,
            String linha) {

        try {

            FileWriter fw =
                    new FileWriter(
                            caminho,
                            true
                    );

            BufferedWriter bw =
                    new BufferedWriter(fw);

            bw.write(linha);

            bw.newLine();

            bw.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro ao salvar."
            );
        }
    }

    public static List<String> lerLinhas(
            String caminho) {

        List<String> linhas =
                new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(caminho)
                    );

            String linha;

            while ((linha =
                    br.readLine()) != null) {

                linhas.add(linha);
            }

            br.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro ao ler."
            );
        }

        return linhas;
    }
}