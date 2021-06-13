package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ExpensesController {

    @FXML
    private TextField TypeStr;

    @FXML
    private TextField SpendStr;

    @FXML
    private Button saveButton;

    @FXML
    void saveExpenses(MouseEvent event) {
        String type = TypeStr.getText();
        String spend = SpendStr.getText();

        if (type.isEmpty() || spend.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Заполните ВСЕ ПОЛЯ!");
            alert.showAndWait();
        } else {
            int num;
            num = ExcelParse.expenses.size() + 1;
            ExcelParse.expenses.add(new Expenses(num, type, spend));
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }
    }
}
