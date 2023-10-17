import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o tamanho da tabela hash que voce deseja inicializar?");
        int size = sc.nextInt();
        sc.nextLine();

        Hash c = new Hash(size);
        String nome;
        long cpf;
        int z = 1;

        while (z == 1) {
            System.out.println(
                    "O que deseja fazer?\n1.Inserir na tabela Hash\n2.Mostrar a Tabela Hash Completa\n3.Procurar uma pessoa pelo cpf na tabela\n4.Encerrar o programa");
            int decisao = sc.nextInt();
            sc.nextLine();

            switch (decisao) {
                case (1):

                    System.out
                            .println("Digite o nome da pessoa e o seu cpf que voce deseja adicionar na tabela Hash:\n");
                    nome = sc.nextLine();
                    cpf = Long.parseLong(sc.nextLine());
                    sc.nextLine();
                    cidadao pessoa = new cidadao(nome, cpf);
                    c.insert(pessoa);
                    break;

                case (2):
                    c.mostrar();
                    break;

                case (3):
                    System.out.println("Digite o cpf da pessoa que voce deseja procurar na tabela Hash:\n");
                    long chave = Long.parseLong(sc.nextLine());
                    System.out.println("\nA chave retornou a pessoa: " + c.get(chave).getNome() + "\n");
                    break;

                case (4):
                    System.out.println("\nEncerrando o programa.");
                    z = 0;
                    break;

                default:
                    System.out.println("Voce escreveu um valor nao valido, tente novamente.\n");

            }
        }

    }
}
