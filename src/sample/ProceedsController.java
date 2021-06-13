package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProceedsController {


    @FXML
    private TextField service;

    @FXML
    private TextField measure;

    @FXML
    private TextField Price;

    @FXML
    private TextField Amount;

    @FXML
    private Button saveButton;

    @FXML
    void saveProceed(MouseEvent event) {
        String serviceStr = service.getText();
        String measureStr = measure.getText();
        String priceStr = Price.getText();
        String AmountStr = Amount.getText();

        if (serviceStr.isEmpty() || measureStr.isEmpty() || priceStr.isEmpty() || AmountStr.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Заполните ВСЕ ПОЛЯ!");
            alert.showAndWait();
        } else {
            int num;
            num = ExcelParse.proceeds.size() + 1;
            ExcelParse.proceeds.add(new Proceeds(num, serviceStr, measureStr, priceStr, AmountStr,
                    Double.parseDouble(priceStr) * Double.parseDouble(AmountStr)));
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }
    }

}

