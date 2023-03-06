import java.util.Scanner;

public class Zad2 {
    public static void main(String[] args) {
        System.out.println("Podaj stopień wielomianu");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        float [] tab = new float[n+1];
        for (int i = 0; i < tab.length ; i++) {
            System.out.println("Podaj współczynniki");
            tab[i]=scan.nextInt();
        }
        System.out.println("W(x) = ");
        System.out.println("Podaj liczbę dla dwumianu");
        float x = scan.nextInt();
        System.out.println("Q(x) = x-"+x);
        for (int j = 1; j < tab.length ; j++) {
            tab[j] = (tab[j]+tab[j-1]*x);
        }
        int w = 0;
        for (int k = tab.length; k >0 ; k--) {
            System.out.print(tab[w++]+"x^"+(k-1)+" ");
        }


    }
}
