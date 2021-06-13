package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SalaryController {

    @FXML
    private TextField PostStr;

    @FXML
    private TextField SalaryStr;

    @FXML
    private TextField percentStr;

    @FXML
    private TextField insuranceStr;

    @FXML
    private TextField taxStr;

    @FXML
    private Button saveButton;

    @FXML
    void saveSalary(MouseEvent event) {
        String post = PostStr.getText();
        String salary = SalaryStr.getText();
        String percent = percentStr.getText();
        String insurance = insuranceStr.getText();
        String tax = taxStr.getText();

        if (post.isEmpty() || salary.isEmpty() || percent.isEmpty() || insurance.isEmpty() || tax.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Заполните ВСЕ ПОЛЯ!");
            alert.showAndWait();
        } else {
            int num;
            num = ExcelParse.slary.size() + 1;
            ExcelParse.slary.add(new Salary(num, post, salary, percent, insurance, tax));
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }
    }
}
