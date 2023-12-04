package ex2;

import java.text.DecimalFormat;
import java.util.Scanner;

import ex1.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class KmLitro {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DecimalFormat formato = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);
        System.out.println("Dammi il numero di Km percorsi");
        Integer km = Integer.parseInt(sc.nextLine());
        System.out.println("Dammi i litri carburante consumati");
        Integer litri = Integer.parseInt(sc.nextLine());
        try {
            System.out.println("Km/l = "+ formato.format(km/litri));
        }catch (ArithmeticException e){
            log.error("Divisione per zero!");
        }finally {
            sc.close();
        }

    }
}
