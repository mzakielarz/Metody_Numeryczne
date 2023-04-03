import umontreal.iro.lecuyer.functions.MathFunction;
import umontreal.iro.lecuyer.functions.MathFunctionWithDerivative;
import umontreal.iro.lecuyer.functions.MathFunctionWithFirstDerivative;
import java.util.Scanner;

import static umontreal.iro.lecuyer.functions.MathFunctionUtil.H;
import static umontreal.iro.lecuyer.functions.MathFunctionUtil.finiteCenteredDifferenceDerivative;

public class Main extends KlasaPom {
    public static void main(String[] args) {
        // bisekcja();
       // stycznych();
    }
    public static void bisekcja() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj stopien wielomianu");
        int n = scanner.nextInt();

        double wspolczynniki[] = new double[n + 1];
        for (int i = wspolczynniki.length - 1; i >= 0; i--) {
            System.out.print("x^" + (i) + ": ");
            wspolczynniki[i] = scanner.nextDouble();
        }

        System.out.println("Podaj a");
        double a = scanner.nextDouble();

        System.out.println("Podaj b");
        double b = scanner.nextDouble();

        System.out.println("Podaj dokladnosc");
        double epsilon = scanner.nextDouble();

        double pivot = 0;

        while (Math.abs(a - b) > epsilon) {
            pivot = (a + b) / 2;
            if (wartoscFunkcji(wspolczynniki, pivot) == 0) {
                System.out.println(pivot);
                break;
            } else if (wartoscFunkcji(wspolczynniki, pivot) * wartoscFunkcji(wspolczynniki, a) < 0) {
                b = pivot;
            } else {
                a = pivot;
            }
        }
        System.out.println(pivot);
    }

    public static void stycznych(){ // Newtona
        double epsilon =0.0001;
        int maxIteracje=100;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj stopień wielomianu");
        int n = scan.nextInt();

        System.out.println("Podaj współczynniki");
        double[] wspolczynniki = new double[n+1];
        for (int i = 0; i < wspolczynniki.length; i++) {
            wspolczynniki[i] = scan.nextDouble();
        }
        System.out.println("Podaj a:");
        double a = scan.nextDouble();

        System.out.println("Podaj b:");
        double b = scan.nextDouble();

        double x0 = a;
        double x1 = b;
        double x2 = 0;

        double fx0 = wartoscFunkcji(wspolczynniki,x0);
        double fx1 = wartoscFunkcji(wspolczynniki,x1);

        int iteracje = 0;

        while (iteracje < maxIteracje){

            double dfdx = (fx1 - fx0) / (x1 - x0);
            x2 = x1 - fx1 / dfdx;
            double fx2 = wartoscFunkcji(wspolczynniki,x2);

            if (Math.abs(fx2) < epsilon) {
                System.out.println(x2);
                return ;
            }

            x0 = x1;
            fx0 = fx1;
            x1 = x2;
            fx1 = fx2;
            iteracje++;
        }

    }
    public static void styczne_pochodne(){
        double epsilon =0.0001;
        int maxIteracje=100;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj stopień wielomianu");
        int n = scan.nextInt();

        System.out.println("Podaj współczynniki");
        double[] wspolczynniki = new double[n+1];
        for (int i = 0; i < wspolczynniki.length; i++) {
            wspolczynniki[i] = scan.nextDouble();
        }
        System.out.println("Podaj a:");
        double a = scan.nextDouble();

        System.out.println("Podaj b:");
        double b = scan.nextDouble();

        double x0 = a;
        double x1 = b;
        double x2 = 0;

        double fx0 = wartoscFunkcji(wspolczynniki,x0);
        double fx1 = wartoscFunkcji(wspolczynniki,x1);

        int iteracje = 0;

        while (iteracje < maxIteracje){

            double dfdx = (fx1 - fx0) / (x1 - x0);
            x2 = x1 - fx1 / dfdx;
            double fx2 = wartoscFunkcji(wspolczynniki,x2);

            if (Math.abs(fx2) < epsilon) {
                System.out.println(x2);
                return ;
            }

            x0 = x1;
            fx0 = fx1;
            x1 = x2;
            fx1 = fx2;
            iteracje++;
        }
    }

    public static double wartoscFunkcji(double wspolczynniki[], double x){
        double value = 0;
        for(int i = wspolczynniki.length-1; i >=0; i--){
            value+=Math.pow(x,i)*wspolczynniki[i];
        }
        return value;
    }
    public static double derivative (MathFunction func, double x) {
        if (func instanceof MathFunctionWithFirstDerivative)
            return ((MathFunctionWithFirstDerivative)func).derivative (x);
        else if (func instanceof MathFunctionWithDerivative)
            return ((MathFunctionWithDerivative)func).derivative (x, 1);
        else
            return finiteCenteredDifferenceDerivative (func, x, H);
    }

}
