/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabalhoed;

import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
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
            
            case 1 :
                
                System.out.println("Método escolhido Ordenação bolha!");
                System.out.println("Vetor original: ");
                ImprimeVetor(vetor);
                System.out.println("----------------------------");
                System.out.println("Vetor ordenado por bolha: ");
                OrdenacaoBolha(vetor);
                System.out.println("----------------------------");
                System.out.println("Vetor ordenado por Seleção: ");
                OrdenacaoSelecao(vetor);
                System.out.println("----------------------------");
                System.out.println("Vetor ordenado por Inserção: ");
                OrdenacaoInsercao(vetor);
                break;
                
            case 2 : 
                System.out.println("Método escolhido Ordenação Seleção!");
                System.out.println("Vetor original: ");
                ImprimeVetor(vetor);
                System.out.println("Vetor ordenado por Seleção: ");
                OrdenacaoSelecao(vetor);
                break;
                
            case 3 :
                System.out.println("Método escolhido Ordenação Inserção!");
                System.out.println("Vetor original: ");
                ImprimeVetor(vetor);
                System.out.println("Vetor ordenado por Inserção: ");
                OrdenacaoInsercao(vetor);
                break;
                
            default : 
                break;
                
        }

        
    }
    public static void ImprimeVetor(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
    }
    
    
    public static void OrdenacaoBolha(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
        ImprimeVetor(vetor);
        ImprimirTempoExecucao(vetor);
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
        ImprimeVetor(vetor);
        ImprimirTempoExecucao(vetor);
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
        ImprimeVetor(vetor);
        ImprimirTempoExecucao(vetor);
    }

    public static void ImprimirTempoExecucao(int[] vetor) {
        long inicio = System.currentTimeMillis();
        long fim = System.currentTimeMillis();
        long tempoExecucao = fim - inicio;

        System.out.println("O tempo de execução foi: " + tempoExecucao);

    }

}
