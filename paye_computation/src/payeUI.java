import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payeUI implements ActionListener {

    JTextField txtGrossPay;
    JLabel lblAnswer;

    public static void main(String[] args) {
        payeUI pui = new payeUI();
        pui.init();
    }

    public void init() {
        //1. Create the frame.
        JFrame frame = new JFrame("PAYE Calculator");

        //2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame.
        txtGrossPay = new JTextField(20);
        txtGrossPay.addActionListener(this);
        frame.getContentPane().add(txtGrossPay, BorderLayout.PAGE_START);

        lblAnswer = new JLabel("Result");
        frame.getContentPane().add(lblAnswer, BorderLayout.CENTER);

        //4. Size the frame.
        frame.setSize(300, 100);

        //5. Show it.
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
        System.out.println(txtGrossPay.getText());

        payCalc pcNew = new payCalc(1);
        pcNew.showPAYERate();
        System.out.println(pcNew.getPAYE(txtGrossPay.getText()));

        payCalc pcCovid = new payCalc(2);
        pcCovid.showPAYERate();
        System.out.println(pcCovid.getPAYE(txtGrossPay.getText()));

        Double tax = paye.getTax(txtGrossPay.getText());
        lblAnswer.setText(tax.toString());
    }
}
