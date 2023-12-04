package ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(10)+1;
        }
        System.out.println("Prima stampa dell'array");
        printIntArray(array);
        Integer numero = null;
        Integer posizione = null;
        do {
            boolean cont;
            do {
                System.out.println("Scegliere una posizione all'interno dell'array (1-5):");
                try {
                    posizione = Integer.parseInt(sc.nextLine()) - 1;
                    cont = false;
                } catch (NumberFormatException e) {
                    cont = true;
                }
            }while (cont);


            System.out.println("Inserire il numero da mettere nella posizione specificata");
            try {
                numero = Integer.parseInt(sc.nextLine());

            }catch (NumberFormatException e){
                log.error("input non valido, sono ammessi solo numeri");
            }

            if(numero == 0){
                continue;
            }
            try {
                array[posizione] = numero;
            }catch (ArrayIndexOutOfBoundsException e){
                log.error("Posizione nell'array non valida");
                log.info("Valori accettati 1-5");
                continue;
            }


            System.out.println("Stampo il nuovo array");
            printIntArray(array);
        }while (numero != 0);
        sc.close();

    }

    static void printIntArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length ; i++){
            if(i < arr.length-1){
                System.out.print(arr[i]+", ");
            }else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }
}