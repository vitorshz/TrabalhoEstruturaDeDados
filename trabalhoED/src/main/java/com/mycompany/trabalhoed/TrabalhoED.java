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

        for (int i = 0; i < vetor.length; i++) {
            input = JOptionPane.showInputDialog("Insira número inteiros para o vetor: ");
            vetor[i] = Integer.parseInt(input);
        }

        int n;
        input = JOptionPane.showInputDialog("Escolha um método de ordenação \n 1 - Ordenação bolha "
                + "\n 2 - Ordenação Seleção"
                + "\n 3 - Ordenação Inserção");
        n = Integer.parseInt(input);

        switch (n) {

            case 1:

                System.out.println("Método escolhido Ordenação bolha!");
                System.out.println("----------------------------");
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
                System.out.println("Método escolhido Ordenação Seleção!");
                System.out.println("----------------------------");
                System.out.println("Vetor original: ");
                ImprimeVetor(vetor);
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
                System.out.println("Método escolhido Ordenação Inserção!");
                System.out.println("----------------------------");
                System.out.println("Vetor original: ");
                ImprimeVetor(vetor);
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

        }

        input = JOptionPane.showInputDialog("Deseja comparar com os outros métodos? S OU N");
        if (input.toUpperCase().equals("S")) {

            System.out.println("Vetor original: ");
            ImprimeVetor(vetor);

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
        } else {

        }

    }

    public static void ImprimeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
    }

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
