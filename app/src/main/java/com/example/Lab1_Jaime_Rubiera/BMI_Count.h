public class BMI_Count {
    public static final BMI_Count instance = new BMI_Count();

    private static final int CENTIMETERS_IN_METER = 100;
    private static final int INCHES_IN_FOOT = 12;
    private static final int BMI_IMPERIAL_WEIGHT_SCALAR = 703;

    public static final String BMI_CATEGORY_UNDERWEIGHT = "Underweight";
    public static final String BMI_CATEGORY_HEALTHY = "Healthy Weight Range";
    public static final String BMI_CATEGORY_OVERWEIGHT = "Overweight";
    public static final String BMI_CATEGORY_OBESE = "Obese";

    public static BMI_Count getInstance() {
        return instance;
    }

    public double calculateBMIMetric(double heightCm, double weightKg) {
        return (weightKg / ((heightCm / CENTIMETERS_IN_METER) * (heightCm / CENTIMETERS_IN_METER)));
    }

    public double calculateBMIImperial(double heightFeet, double heightInches, double weightLbs) {
        double totalHeightInInches = (heightFeet * INCHES_IN_FOOT) + heightInches;
        return (BMI_IMPERIAL_WEIGHT_SCALAR * weightLbs) / (totalHeightInInches * totalHeightInInches);
    }