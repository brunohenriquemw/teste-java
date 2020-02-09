package br.com.teste.basico.util;


public class Validadores {


    public static boolean cpfValido(String cpf) {
        /* PRIORIDADE: OPCIONAL
        * Na próxima demanda do nosso projeto os usuários passarão a ter
        * seus cpfs cadastrados no sistema, então pensamos em já deixar preparada
        * uma função para validar seu cpf. Ainda não temos as regras de validação,
        * mas é algo que será fácil de conseguir na internet.
        *
        * Obs.: Considere que o cpf será recebido com a máscara, ex.: "123.456.789-10"
        */

        String validacaoNumerosIguais = cpf
                .replace(".","")
                .replace("-","")
                .replace(Character.toString(cpf.charAt(0)), "");

        if (validacaoNumerosIguais.trim().equals("")) {
            return false;
        }

        char[] numerosCpf = cpf
                .replace(".","")
                .replace("-","")
                .toCharArray();

        int dv1 = 0, dv2 = 0, indice = 0;

        for (int numero = 11; numero > 1; numero--) {
            if (numero > 2) {
                dv1 += (numero - 1) * (numerosCpf[indice] - 48);
                dv2 += numero * (numerosCpf[indice++] - 48);
            } else {
                dv2 += numero * (numerosCpf[indice] - 48);
            }
        }

        dv1 = (dv1 * 10) % 11;
        dv2 = (dv2 * 10) % 11;

        if (dv1 == 10) {
            dv1 = 0;
        }

        if (dv2 == 10) {
            dv2 = 0;
        }

        if (dv1 == (numerosCpf[9] - 48) && dv2 == (numerosCpf[10] - 48)) {
            return true;
        } else {
            return false;
        }

    }


}
