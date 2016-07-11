package homeworks._06_PlanckConstant;

class Calculation{
    public static final double PLANCK_CONSTANT = Double.valueOf("6.62606896e-34 ");
    public static final double PI = 3.14159;

    public static double getReducedPlanckConstant(){
        return PLANCK_CONSTANT / (2 * PI);
    }
}

public class Pr06PlanckConstant {
    public static void main(String[] args) {
        System.out.println(Calculation.getReducedPlanckConstant());
    }
}
