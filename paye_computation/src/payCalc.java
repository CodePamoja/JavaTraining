public class payCalc {

    float[][] payeRates = new float[0][0];
    float payeRelief = 0f;

    public payCalc(int rateSelection) {
        if(rateSelection == 1) {            // Current rates from January 2021
            payeRates = new float[][]{{24000f, 10f}, {32333f, 25f}, {10000000f, 30f}};
            payeRelief = 2400f;
        } else if(rateSelection == 2) {     // COVID-19 rates from April 2020
            payeRates = new float[][]{{24000f, 10f}, {40667f, 15f}, {57334f, 20f}, {10000000f, 25f}};
            payeRelief = 2400f;
        }
    }

    public void showPAYERate() {
        for (int i = 0; i < payeRates.length; i++) {
            System.out.println(payeRates[i][0] + " : " + payeRates[i][1]);
        }
    }

    public double getPAYE(String strGrossPay) {
        float grossPay = new Float(strGrossPay);
        return getPAYE(grossPay);
    }

    public double getPAYE(float grossPay) {
        double tax = 0;
        double prevRange = 0;

        System.out.println(grossPay);
        for (float[] payeRate : payeRates) {
            float range = payeRate[0];
            float rate = payeRate[1];
            //System.out.println(range + " : " + rate);

            if(grossPay <= range) {
                tax += (grossPay - prevRange) * rate / 100;
                break;
            } else {
                tax += (range - prevRange) * rate / 100;
            }

            prevRange = range;
        }

        tax -= payeRelief;
        if(tax < 0) tax = 0;

        return tax;
    }
}
