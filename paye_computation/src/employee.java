public class employee {

    String employeeId;
    String employeeName;
    float employeePay;

    public employee(String employeeId, String employeeName, float employeePay) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePay = employeePay;
    }

    public double getPAYE() {
        payCalc pc = new payCalc(1);
        return pc.getPAYE(employeePay);
    }

    public void displayPAYE() {
        payCalc pc = new payCalc(1);
        System.out.println(employeeId + " : " + employeeName);
        System.out.println(pc.getPAYE(employeePay));
    }
}
