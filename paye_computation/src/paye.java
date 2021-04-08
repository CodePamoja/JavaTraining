public class paye {

    public static void main(String[] args) {
        System.out.println("PAYE Calculator");

        float grossPay = 50000;

        if(args.length > 0) grossPay = new Float(args[0]);

        double tax = getTax(grossPay);

        System.out.println("Gross Pay : " + grossPay);
        System.out.println("Tax : " + tax);

        employee emp1 = new employee("234", "Dennis Gichangi", 45000f);
        emp1.displayPAYE();

        employee emp2 = new employee("345", "Pharis Mwangi", 75000f);
        emp2.displayPAYE();
    }

    public static double getTax(String strGrossPay) {
        float grossPay = new Float(strGrossPay);
        return getTax(grossPay);
    }

    public static double getTax(float grossPay) {
        double tax = 0;

        if(grossPay <= 24000) {
            tax = grossPay * 0.1;
        } else if(grossPay <= (24000 + 8333)) {
            tax = 2400 + (grossPay - 24000) * 0.25;
        } else {
            tax = 4483.25 + (grossPay - 32333) * 0.3;
        }

        tax = tax - 2400;
        if(tax < 0) tax = 0;

        return tax;
    }
}
