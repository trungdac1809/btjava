package bt.btchuong2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class BT48 extends JFrame {

    public BT48() {
        setTitle("Number Input");

        setSize(300, 200);

        setLayout(new FlowLayout(
                FlowLayout.CENTER,
                10,
                60
        ));

        JTextField textField = new JTextField(15);

        JLabel label = new JLabel("Number: ");

        AbstractDocument document =
                (AbstractDocument) textField.getDocument();

        document.setDocumentFilter(new DocumentFilter() {

            @Override
            public void insertString(
                    FilterBypass fb,
                    int offset,
                    String string,
                    AttributeSet attr)
                    throws BadLocationException {

                if (string != null && string.matches("\\d+")) {
                    fb.insertString(offset, string, attr);
                }
            }

            @Override
            public void replace(
                    FilterBypass fb,
                    int offset,
                    int length,
                    String text,
                    AttributeSet attrs)
                    throws BadLocationException {

                if (text == null || text.matches("\\d*")) {
                    fb.replace(
                            offset,
                            length,
                            text,
                            attrs
                    );
                }
            }
        });

        document.addDocumentListener(
                new DocumentListener() {

            private void updateLabel() {
                label.setText(
                        "Number: " + textField.getText()
                );
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel();
            }
        });
        add(textField);
        add(label);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BT48 frame = new BT48();
        frame.setVisible(true);
    }
}