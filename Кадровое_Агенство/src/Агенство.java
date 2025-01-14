import javax.swing.*;
import java.awt.*;
public class Агенство {
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> positionComboBox;
    private JRadioButton employmentTypeFullTime;
    private JRadioButton employmentTypeContract;
    private JRadioButton educationHigher;
    private JRadioButton educationSecondary;
    private JComboBox<String> specialtyComboBox;
    private JTextArea resultArea;

    public Агенство() {
        frame = new JFrame("Кадровое агентство");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 2));

        
        frame.add(new JLabel("Имя:"));
        nameField = new JTextField();
        frame.add(nameField);

       
        frame.add(new JLabel("Искомая должность:"));
        positionComboBox = new JComboBox<>(new String[]{"Менеджер", "Разработчик", "Дизайнер"});
        frame.add(positionComboBox);

       
        frame.add(new JLabel("Вид занятости:"));
        JPanel employmentPanel = new JPanel();
        employmentTypeFullTime = new JRadioButton("Штат");
        employmentTypeContract = new JRadioButton("Договор ГПХ");
        ButtonGroup employmentGroup = new ButtonGroup();
        employmentGroup.add(employmentTypeFullTime);
        employmentGroup.add(employmentTypeContract);
        employmentPanel.add(employmentTypeFullTime);
        employmentPanel.add(employmentTypeContract);
        frame.add(employmentPanel);

      
        frame.add(new JLabel("Вид образования:"));
        JPanel educationPanel = new JPanel();
        educationHigher = new JRadioButton("Высшее");
        educationSecondary = new JRadioButton("Среднее");
        ButtonGroup educationGroup = new ButtonGroup();
        educationGroup.add(educationHigher);
        educationGroup.add(educationSecondary);
        educationPanel.add(educationHigher);
        educationPanel.add(educationSecondary);
        frame.add(educationPanel);

       
        frame.add(new JLabel("Специальность:"));
        specialtyComboBox = new JComboBox<>(new String[]{"Инженер", "Программист", "Дизайнер"});
        frame.add(specialtyComboBox);

       
        JButton resultButton = new JButton("Вывести результат");
        resultButton.addActionListener(e -> showResult());
        frame.add(resultButton);

       
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        frame.add(new JScrollPane(resultArea));

        frame.setVisible(true);
    }

    private void showResult() {
        String name = nameField.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Пожалуйста, введите ваше имя.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String position = (String) positionComboBox.getSelectedItem();
        String employmentType = employmentTypeFullTime.isSelected() ? "Штат" : "Договор ГПХ";
        String education = educationHigher.isSelected() ? "Высшее" : "Среднее";
        String specialty = (String) specialtyComboBox.getSelectedItem();

        int salary;
        
        switch (position) {
            case "Менеджер":
                salary = 60000;
                break;
            case "Разработчик":
                salary = 80000;
                break;
            case "Дизайнер":
                salary = 50000;
                break;
            default:
                salary = 0; 
                break;
        }

        String result = String.format("Здравствуйте, %s!\n" +       
            "Вакансии по Вашему запросу:\n" +
                "Должность: %s\n" +
                "Вид занятости: %s\n" +
                "Образование: %s\n" +
                "Специальность: %s\n" +
                "Оклад: %d руб.\n", 
        name, position, employmentType, education, specialty, salary);

resultArea.setText(result);
}

public static void main(String[] args) {
SwingUtilities.invokeLater(Агенство::new);
}
}
