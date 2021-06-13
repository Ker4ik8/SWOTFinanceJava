package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FixedController {

    @FXML
    private TextField placeStr;

    @FXML
    private TextField nameStr;

    @FXML
    private TextField priceStr;

    @FXML
    private TextField amountStr;

    @FXML
    private Button saveButton;

    @FXML
    void saveFixed(MouseEvent event) {

        String place = placeStr.getText();
        String name = nameStr.getText();
        String price = priceStr.getText();
        String amount = amountStr.getText();

        if (place.isEmpty() || name.isEmpty() || price.isEmpty() || amount.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Заполните ВСЕ ПОЛЯ!");
            alert.showAndWait();
        } else {
            int num;
            num = ExcelParse.fixed.size() + 1;
            ExcelParse.fixed.add(new Fixed(num, place, name, price, amount,
                    Double.parseDouble(price) * Double.parseDouble(amount)));
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }

    }
}
