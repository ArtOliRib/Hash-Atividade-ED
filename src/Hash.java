import java.lang.Math.*;
import java.util.ArrayList;

public class Hash {

    private int size;
    private ArrayList<cidadao>[][] tabela;
    private int chave;

    public Hash(int t) {

        if ((int) (t * 1.25) % 2 == 0) {
            this.size = (int) Math.round(t * 1.25) + 1;
        } else {
            this.size = (int) Math.round(t * 1.25);
        }

        tabela = new ArrayList[10][size];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < size; j++) {
                tabela[i][j] = new ArrayList<cidadao>();
            }
        }

    }

    public int chave_hash_1(long s) {
        return (int) (s % 10);

    }

    private int chave_hash_2(long s) {
        return (int) (s % (size / 10));

    }

    public void insert(cidadao c) {
        int pos1 = chave_hash_1(c.getCpf());
        int pos2 = chave_hash_2(c.getCpf());

        cidadao pessoa = new cidadao(c.getNome(), c.getCpf());

        tabela[pos1][pos2].add(pessoa);
        System.out.println("A Pessoa " + pessoa.getNome() + " foi adicionada na tabela hash");
        System.out.println("Chave da palavra adicionada:" + pessoa.getCpf() + "\n");

    }

    public cidadao get(long cpf) {
        int pos1 = chave_hash_1(cpf);
        int pos2 = chave_hash_2(cpf);

        if (tabela[pos1][pos2].size() == 0) {
            System.out.println("Não existem palavras na tabela com mesma chave que " + cpf
                    + " utilize a função de inserir primeiro");
        }

        for (int i = 0; i < tabela[pos1][pos2].size(); i++) {
            if (tabela[pos1][pos2].get(i).getCpf() == cpf) {
                return tabela[pos1][pos2].get(i);
            }
        }
        return null;

    }

    public void mostrar() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Posição " + (i + 1) + " da tabela possui estas palavras:");
            System.out.print("[ ");

            for (int j = 0; j < (size / 10); j++) {
                System.out.print("(" + tabela[i][j] + "),");

            }
            System.out.print(" ]\n\n");
        }
    }

}
