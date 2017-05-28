package utils;

import java.util.Random;

public class Utilidades {

    public int geraNumero() {
        Random r = new Random();
//        tem que ver como não gerar números repetidos
        int random = r.nextInt();
        System.out.print("Gera número:" +random);
        return random;
    }
}
