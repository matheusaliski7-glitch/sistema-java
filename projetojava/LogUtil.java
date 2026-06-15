import java.io.BufferedWriter;
import java.io.FileWriter;

public class LogUtil {

    public static void registrar(String texto) {

        try {

            FileWriter fw =
                    new FileWriter(
                            "dados/log.txt",
                            true
                    );

            BufferedWriter bw =
                    new BufferedWriter(fw);

            bw.write(texto);

            bw.newLine();

            bw.close();

        } catch (Exception e) {

            System.out.println(
                    "Erro no log."
            );
        }
    }
}