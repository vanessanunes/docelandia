package utils;

/*Pequena cópia da atividade do Prof. Edson, todo crédito e louvores a ele*/

import java.util.Random;

public class Utilidades {
    // Variável para armazenar o novo RA
    private final int num;

    /**
     * Instancia um objeto da classe Random usando o construtor genérico
     */
    public Utilidades() {
        // Cria um objeto para gerar os número randômicos
        Random gerador = new Random();

        // Cria a variável para armazenar o RA criado
        int retorno = 0;

        // Concatena os números aleatórios entre 1 e 9
        for (int i = 1; i < 60; i++) {
            retorno += gerador.nextInt(60);
        }
        this.num = retorno;
    }

    /**
     *
     * @return String
     */
    public int getGeraNumero() {
        return num;
    }

}
