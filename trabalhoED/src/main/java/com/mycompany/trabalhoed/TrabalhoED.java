package com.mycompany.trabalhoed;

import javax.swing.JOptionPane;

public class TrabalhoED {

    public static void main(String[] args) {
        //Pedindo ao usuario o tamanho do vetor
        String input;
        int x;

        input = JOptionPane.showInputDialog("Insira o tamanho do vetor: ");
        x = Integer.parseInt(input);
        int[] vetor = new int[x];
        //pedindo ao usuario os valores do vetor
        for (int i = 0; i < vetor.length; i++) {
            input = JOptionPane.showInputDialog("Insira número inteiros para o vetor: ");
            vetor[i] = Integer.parseInt(input);
        }
        //pedindo para o usuario selecionar qual método de ordenação quer usar
        int n;
        input = JOptionPane.showInputDialog("Escolha um método de ordenação \n 1 - Ordenação bolha "
                + "\n 2 - Ordenação Seleção"
                + "\n 3 - Ordenação Inserção");
        n = Integer.parseInt(input);

        switch (n) {
            //criando o meneu de opções de métodos de ordenações 
            case 1:

                System.out.println("Método escolhido Ordenação bolha!");
                System.out.println("Vetor original: ");
                ImprimeVetor(vetor);

                long inicio = System.nanoTime();
                System.out.println("----------------------------");
                System.out.println("Vetor ordenado por bolha: ");
                OrdenacaoBolha(vetor);
                ImprimeVetor(vetor);
                long fim = System.nanoTime();
                long tempoExecucao = fim - inicio;
                System.out.println("O tempo de execução foi de: " + tempoExecucao);

                break;
                
            case 2:
                long inicioSelecao = System.nanoTime();
                System.out.println("----------------------------");
                System.out.println("Vetor ordenado por Seleção: ");
                OrdenacaoSelecao(vetor);
                ImprimeVetor(vetor);
                long fimSelecao = System.nanoTime();
                long tempoExecucaoSelecao = fimSelecao - inicioSelecao;
                System.out.println("O tempo de execução foi de: " + tempoExecucaoSelecao);
                break;
                
            case 3:
                long inicioInsercao = System.nanoTime();
                System.out.println("----------------------------");
                System.out.println("Vetor ordenado por Inserção: ");
                OrdenacaoInsercao(vetor);
                ImprimeVetor(vetor);
                long fimInsercao = System.nanoTime();
                long tempoExecucaoInsercao = fimInsercao - inicioInsercao;
                System.out.println("O tempo de execução foi de: " + tempoExecucaoInsercao);
                break;

            default:
                break;

        } //comparando os tempos de execução dos métodos de ordenação
        long inicio = System.nanoTime(); 
        System.out.println("----------------------------");
        System.out.println("Vetor ordenado por bolha: ");
        OrdenacaoBolha(vetor);
        long fim = System.nanoTime();
        long tempoExecucao = fim - inicio;
        System.out.println("O tempo de execução foi de: " + tempoExecucao);

        long inicioSelecao = System.nanoTime(); 
        System.out.println("----------------------------");
        System.out.println("Vetor ordenado por Seleção: ");
        OrdenacaoSelecao(vetor);
        long fimSelecao = System.nanoTime();    
        long tempoExecucaoSelecao = fimSelecao - inicioSelecao;
        System.out.println("O tempo de execução foi de: " + tempoExecucaoSelecao);

        long inicioInsercao = System.nanoTime();   
        System.out.println("----------------------------");
        System.out.println("Vetor ordenado por Inserção: ");
        OrdenacaoInsercao(vetor);
        long fimInsercao = System.nanoTime();
        long tempoExecucaoInsercao = fimInsercao - inicioInsercao;
        System.out.println("O tempo de execução foi de: " + tempoExecucaoInsercao);

    }
    //método para imprimir o vetor
    public static void ImprimeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
    }
    //método para ordenar em bolha
    public static void OrdenacaoBolha(int[] vetor) {
        boolean troca = true;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
            }

        }
    }
    //método para ordenar em seleção
    public static void OrdenacaoSelecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int posMenor = i;

            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[posMenor]) {
                    posMenor = j;
                }
            }

            if (posMenor != i) {
                int aux = vetor[i];
                vetor[i] = vetor[posMenor];
                vetor[posMenor] = aux;
            }

        }

    }
    //método para ordenar em inserção
    public static void OrdenacaoInsercao(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int atual = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > atual) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = atual;
        }

    }

}
