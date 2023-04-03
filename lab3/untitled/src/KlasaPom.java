import umontreal.iro.lecuyer.functions.MathFunction;
import umontreal.iro.lecuyer.functions.MathFunctionWithDerivative;

public class KlasaPom {
    public static void main(String[] args) {
        new MathFunctionWithDerivative() {
            @Override
            public double evaluate(double v) {
                return 0;
            }

            @Override
            public double derivative(double v, int i) {
                return 0;
            }
        };
        new MathFunction() {
            @Override
            public double evaluate(double v) {
                return 0;
            }
        };
    }

}
