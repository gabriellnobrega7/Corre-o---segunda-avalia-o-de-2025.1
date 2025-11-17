 import java.util.Scanner;

public class Provadejunho {

    public static Scanner input = new Scanner(System.in);

    public static int compararNomes(String a, String b) {
        int tamA = a.length();
        int tamB = b.length();
        int limite = tamA < tamB ? tamA : tamB;

        for (int i = 0; i < limite; i++) {
            int ca = a.charAt(i);
            int cb = b.charAt(i);
            if (ca != cb) {
                return ca - cb;
            }
        }
        return tamA - tamB;
    }

    public static int buscarNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (compararNomes(v[i].nome, nome) == 0) {
                return i;
            }
        }
        return -1;
    }

    
    // QUESTÃO 1 – cadastrarPessoa
    public static int cadastrarPessoa(Pessoa[] v, int qtd) {

        if (qtd == v.length) {
            System.out.println("Nao é possível cadastrar");
            return qtd;
        }

        input.nextLine(); // limpa buffer
        Pessoa p = new Pessoa();

        // Nome sem repetir
        System.out.println("Digite o nome:");
        p.nome = input.nextLine();

        while (buscarNome(v, qtd, p.nome) != -1) {
            System.out.println("Nome já existe, digite outro:");
            p.nome = input.nextLine();
        }

        // Preencher idade, peso, altura
        System.out.println("Digite a idade:");
        p.idade = input.nextInt();
        System.out.println("Digite o peso:");
        p.peso = input.nextDouble();
        System.out.println("Digite a altura:");
        p.altura = input.nextDouble();

        v[qtd] = p; // insere no final
        return qtd + 1;
    }
    // Função IMC
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // QUESTÃO 2 – imprimirPessoas

    public static void imprimirPessoas(Pessoa[] v, int qtd) {

        for (int i = 0; i < qtd; i++) {
            Pessoa p = v[i];
            System.out.println("Pessoa " + (i + 1) + ":");
            System.out.println("Nome: " + p.nome);
            System.out.println("Idade: " + p.idade);
            System.out.println("Peso: " + p.peso);
            System.out.println("Altura: " + p.altura);

            double imc = calcularIMC(p.peso, p.altura);
            System.out.println("IMC: " + imc);
            System.out.println();
        }
    }

    // QUESTÃO 3 – maisVelhaIMCMagreza
    
    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {

        int indice = -1;
        int maiorIdade = -1;

        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i].peso, v[i].altura);

            if (imc < 18.5) { // Magreza
                if (v[i].idade > maiorIdade) {
                    maiorIdade = v[i].idade;
                    indice = i;
                }
            }
        }

        return indice;
    }

    // QUESTÃO 4 – insertionSortPorNome
  
    public static void insertionSortPorNome(Pessoa[] v, int qtd) {

        for (int i = 1; i < qtd; i++) {
            Pessoa chave = v[i];
            int j = i - 1;

            while (j >= 0 && compararNomes(chave.nome, v[j].nome) < 0) {
                v[j + 1] = v[j];
                j--;
            }

            v[j + 1] = chave;
        }
    }

    //QUESTÃO 5 - QUESTÃO PRÓPRIA FUNÇÃO:

    public static int buscaSequencial(int[] v, int tam, int key){


        for(int i = 0; i < tam; i++){

            if (v[i] == key) {
                return i;
            }
        }
        return -1;
    }

    }
