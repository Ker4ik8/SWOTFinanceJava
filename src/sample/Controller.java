package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    private static XYChart.Series ProceedChart = new XYChart.Series();
    private static XYChart.Series ExpensesChart = new XYChart.Series();
    private static XYChart.Series SalaryChart = new XYChart.Series();
    private static XYChart.Series FixedChart = new XYChart.Series();
    private static XYChart.Series ResultChart = new XYChart.Series();
    int arraySize = 0;

    @FXML
    private TableView<Proceeds> ProceedTable;

    @FXML
    private TableColumn<Proceeds, Integer> ProceedNum;

    @FXML
    private TableColumn<Proceeds, String> ProceedUsl;

    @FXML
    private TableColumn<Proceeds, String> ProceedMeasure;

    @FXML
    private TableColumn<Proceeds, String> ProceedPrice;

    @FXML
    private TableColumn<Proceeds, String> ProceedAmount;

    @FXML
    private TableColumn<Proceeds, Double> ProceedIncome;

    @FXML
    private Button ProceedAdd;

    @FXML
    private Button ProceedRefresh;

    @FXML
    private TextField ProceedStrDel;

    @FXML
    private Button ProceedsDelete;

    @FXML
    private BarChart<?, ?> ProceedBar;

    @FXML
    private TableView<Salary> SalaryTable;

    @FXML
    private TableColumn<Salary, Integer> SalaryNum;

    @FXML
    private TableColumn<Salary, String> SalaryPost;

    @FXML
    private TableColumn<Salary, String> SalarySalary;

    @FXML
    private TableColumn<Salary, String> SalaryOfIncome;

    @FXML
    private TableColumn<Salary, String> SalaryInsurance;

    @FXML
    private TableColumn<Salary, String> SalaryTax;

    @FXML
    private Button SalaryAdd;

    @FXML
    private Button SalaryRefresh;

    @FXML
    private TextField SalaryStrDel;

    @FXML
    private Button SalaryDelete;

    @FXML
    private BarChart<?, ?> SalaryBar;

    @FXML
    private TableView<Credit> CreditTable;

    @FXML
    private TableColumn<Credit, Integer> CreditNum;

    @FXML
    private TableColumn<Credit, String> CreditRate;

    @FXML
    private TableColumn<Credit, String> CreditValue;

    @FXML
    private Button CreditRefresh;

    @FXML
    private TableView<Expenses> ExpensesTable;

    @FXML
    private TableColumn<Expenses, Integer> ExpensesNum;

    @FXML
    private TableColumn<Expenses, String> ExpensesType;

    @FXML
    private TableColumn<Expenses, String> ExpensesSpend;

    @FXML
    private Button ExpensesAdd;

    @FXML
    private Button ExpensesRefresh;

    @FXML
    private Button ExpensesDelete;

    @FXML
    private TextField ExpensesStrDel;

    @FXML
    private BarChart<?, ?> ExpensesBar;

    @FXML
    private TableView<Fixed> FixedTable;

    @FXML
    private TableColumn<Fixed, Integer> FixedNum;

    @FXML
    private TableColumn<Fixed, String> FixedPlace;

    @FXML
    private TableColumn<Fixed, String> FixedName;

    @FXML
    private TableColumn<Fixed, String> FixedPrice;

    @FXML
    private TableColumn<Fixed, String> FixedAmount;

    @FXML
    private TableColumn<Fixed, String> FixedSpend;

    @FXML
    private Button FixedAdd;

    @FXML
    private Button FixedRefresh;

    @FXML
    private TextField FixedStrDel;

    @FXML
    private Button FixedDelete;

    @FXML
    private BarChart<?, ?> FixedBar;

    @FXML
    private BarChart<?, ?> ResultBar;

    @FXML
    private Button saveButton;

    @FXML
    private TextField fileName;


    @FXML
    void addExpenses(MouseEvent event) {
        arraySize = ExcelParse.expenses.size();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("expenses.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ExcelParse.expenses.size() > arraySize) {
            ExpensesTable.getItems().add(ExcelParse.expenses.get(ExcelParse.expenses.size() - 1));
            ExpensesTable.refresh();
            ExcelParse.expense = 0;
            for (int i = 0; i < ExcelParse.expenses.size(); i++) {
                ExcelParse.expense += Double.parseDouble(ExcelParse.expenses.get(i).getSpend());
            }
            makeResultBar();
        }
    }

    @FXML
    void addFixed(MouseEvent event) {
        arraySize = ExcelParse.expenses.size();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("fixed.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ExcelParse.fixed.size() > arraySize) {
            FixedTable.getItems().add(ExcelParse.fixed.get(ExcelParse.fixed.size() - 1));
            FixedTable.refresh();
            ExcelParse.fixedS = 0;
            for (int i = 0; i < ExcelParse.fixed.size(); i++) {
                ExcelParse.fixedS += ExcelParse.fixed.get(i).getSpend();
            }
            makeResultBar();
        }
    }

    @FXML
    void addProceed(MouseEvent event) {
        arraySize = ExcelParse.proceeds.size();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("proceeds.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ExcelParse.proceeds.size() > arraySize) {
            ProceedTable.getItems().add(ExcelParse.proceeds.get(ExcelParse.proceeds.size() - 1));
            ProceedTable.refresh();
            ExcelParse.proceed = 0;
            for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
                ExcelParse.proceed += ExcelParse.proceeds.get(i).getIncome();
            }
            makeResultBar();
        }
    }

    @FXML
    void addSalary(MouseEvent event) {
        arraySize = ExcelParse.slary.size();
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("salary.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ExcelParse.slary.size() > arraySize) {
            SalaryTable.getItems().add(ExcelParse.slary.get(ExcelParse.slary.size() - 1));
            SalaryTable.refresh();
            ExcelParse.salary = 0;
            for (int i = 0; i < ExcelParse.slary.size(); i++) {
                ExcelParse.salary += Double.parseDouble(ExcelParse.expenses.get(i).getSpend());
            }
            makeResultBar();
        }
    }

    @FXML
    void changeAmount(TableColumn.CellEditEvent editedCell) {
        Proceeds selectedData = ProceedTable.getSelectionModel().getSelectedItem();
        selectedData.setAmount(editedCell.getNewValue().toString());
        selectedData.setIncome(Double.parseDouble(selectedData.getPrice()) * Double.parseDouble(selectedData.getAmount()));
    }

    @FXML
    void changeFixedAmount(TableColumn.CellEditEvent editedCell) {
        Fixed selectedData = FixedTable.getSelectionModel().getSelectedItem();
        selectedData.setAmount(editedCell.getNewValue().toString());
        selectedData.setSpend(Double.parseDouble(selectedData.getOnePrice()) * Double.parseDouble(selectedData.getAmount()));
    }

    @FXML
    void changeInsurance(TableColumn.CellEditEvent editedCell) {
        Salary selectedData = SalaryTable.getSelectionModel().getSelectedItem();
        selectedData.setInsurance(editedCell.getNewValue().toString());
    }

    @FXML
    void changeMeasure(TableColumn.CellEditEvent editedCell) {
        Proceeds selectedData = ProceedTable.getSelectionModel().getSelectedItem();
        selectedData.setMeasure(editedCell.getNewValue().toString());
    }

    @FXML
    void changeName(TableColumn.CellEditEvent editedCell) {
        Fixed selectedData = FixedTable.getSelectionModel().getSelectedItem();
        selectedData.setName(editedCell.getNewValue().toString());
    }

    @FXML
    void changeOnePrice(TableColumn.CellEditEvent editedCell) {
        Fixed selectedData = FixedTable.getSelectionModel().getSelectedItem();
        selectedData.setOnePrice(editedCell.getNewValue().toString());
        selectedData.setSpend(Double.parseDouble(selectedData.getOnePrice()) * Double.parseDouble(selectedData.getAmount()));
    }

    @FXML
    void changePercent(TableColumn.CellEditEvent editedCell) {
        Salary selectedData = SalaryTable.getSelectionModel().getSelectedItem();
        selectedData.setPercent(editedCell.getNewValue().toString());
    }

    @FXML
    void changePlace(TableColumn.CellEditEvent editedCell) {
        Fixed selectedData = FixedTable.getSelectionModel().getSelectedItem();
        selectedData.setPlace(editedCell.getNewValue().toString());
    }

    @FXML
    void changePrice(TableColumn.CellEditEvent editedCell) {
        Proceeds selectedData = ProceedTable.getSelectionModel().getSelectedItem();
        selectedData.setPrice(editedCell.getNewValue().toString());
        selectedData.setIncome(Double.parseDouble(selectedData.getPrice()) * Double.parseDouble(selectedData.getAmount()));
    }

    @FXML
    void changeSalary(TableColumn.CellEditEvent editedCell) {
        Salary selectedData = SalaryTable.getSelectionModel().getSelectedItem();
        selectedData.setSalary(editedCell.getNewValue().toString());
    }

    @FXML
    void changeTax(TableColumn.CellEditEvent editedCell) {
        Salary selectedData = SalaryTable.getSelectionModel().getSelectedItem();
        selectedData.setTax(editedCell.getNewValue().toString());
    }

    @FXML
    void changeSpends(TableColumn.CellEditEvent editedCell) {
        Expenses selectedData = ExpensesTable.getSelectionModel().getSelectedItem();
        selectedData.setSpend(editedCell.getNewValue().toString());
    }

    @FXML
    void changeValue(TableColumn.CellEditEvent editedCell) {
        Credit selectedData = CreditTable.getSelectionModel().getSelectedItem();
        selectedData.setValue(editedCell.getNewValue().toString());
    }

    @FXML
    void deleteExpenses(MouseEvent event) {
        String number = ExpensesStrDel.getText();
        ExcelParse.expenses.remove(Integer.parseInt(number) - 1);
        for (int i = 0; i < ExcelParse.expenses.size(); i++) {
            ExcelParse.expenses.get(i).setNum(i + 1);
        }
        ExpensesTable.refresh();
        ExcelParse.expense = 0;
        for (int i = 0; i < ExcelParse.expenses.size(); i++) {
            ExcelParse.expense += Double.parseDouble(ExcelParse.expenses.get(i).getSpend());
        }
        makeResultBar();
    }

    @FXML
    void deleteFixed(MouseEvent event) {
        String number = FixedStrDel.getText();
        ExcelParse.fixed.remove(Integer.parseInt(number) - 1);
        for (int i = 0; i < ExcelParse.fixed.size(); i++) {
            ExcelParse.fixed.get(i).setNum(i + 1);
        }
        FixedTable.refresh();
        ExcelParse.fixedS = 0;
        for (int i = 0; i < ExcelParse.fixed.size(); i++) {
            ExcelParse.fixedS += ExcelParse.fixed.get(i).getSpend();
        }
        makeResultBar();
    }

    @FXML
    void deleteProceed(MouseEvent event) {
        String number = ProceedStrDel.getText();
        ExcelParse.proceeds.remove(Integer.parseInt(number) - 1);
        for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
            ExcelParse.proceeds.get(i).setNum(i + 1);
        }
        ProceedTable.refresh();
        ExcelParse.proceed = 0;
        for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
            ExcelParse.proceed += ExcelParse.proceeds.get(i).getIncome();
        }
        makeResultBar();
    }

    @FXML
    void deleteSalary(MouseEvent event) {
        String number = SalaryStrDel.getText();
        ExcelParse.slary.remove(Integer.parseInt(number) - 1);
        for (int i = 0; i < ExcelParse.slary.size(); i++) {
            ExcelParse.slary.get(i).setNum(i + 1);
        }
        SalaryTable.refresh();
        ExcelParse.salary = 0;
        for (int i = 0; i < ExcelParse.slary.size(); i++) {
            ExcelParse.salary += (Double.parseDouble(ExcelParse.slary.get(i).getSalary()) * 12 * Double.parseDouble(ExcelParse.slary.get(i).getInsurance()) / 100
                    + ExcelParse.proceed * Double.parseDouble(ExcelParse.slary.get(i).getPercent()) / 100);
        }
        makeResultBar();
    }

    @FXML
    void refreshCredit(MouseEvent event) {
        CreditTable.refresh();
    }

    @FXML
    void refreshExpenses(MouseEvent event) {
        ExpensesTable.refresh();
        ExpensesBar.getData().clear();
        ExpensesChart.getData().clear();
        ExpensesBar.setAnimated(false);
        for (int i = 0; i < ExcelParse.expenses.size(); i++) {
            ExpensesChart.getData().add(new XYChart.Data<>(ExcelParse.expenses.get(i).getType(), Double.parseDouble(ExcelParse.expenses.get(i).getSpend())));
        }
        ExpensesBar.getData().addAll(ExpensesChart);
        ExcelParse.expense = 0;
        for (int i = 0; i < ExcelParse.expenses.size(); i++) {
            ExcelParse.expense += Double.parseDouble(ExcelParse.expenses.get(i).getSpend());
        }
        makeResultBar();
    }

    @FXML
    void refreshFixed(MouseEvent event) {
        FixedTable.refresh();
        FixedBar.getData().clear();
        FixedChart.getData().clear();
        FixedBar.setAnimated(false);
        for (int i = 0; i < ExcelParse.fixed.size(); i++) {
            FixedChart.getData().add(new XYChart.Data<>(ExcelParse.fixed.get(i).getName(), ExcelParse.fixed.get(i).getSpend()));
        }
        FixedBar.getData().addAll(FixedChart);
        ExcelParse.fixedS = 0;
        for (int i = 0; i < ExcelParse.fixed.size(); i++) {
            ExcelParse.fixedS += ExcelParse.fixed.get(i).getSpend();
        }
        makeResultBar();
    }

    @FXML
    void refreshProceed(MouseEvent event) {
        ProceedTable.refresh();
        ProceedBar.getData().clear();
        ProceedChart.getData().clear();
        ProceedBar.setAnimated(false);
        for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
            ProceedChart.getData().add(new XYChart.Data<>(ExcelParse.proceeds.get(i).getService(), ExcelParse.proceeds.get(i).getIncome()));
        }
        ProceedBar.getData().addAll(ProceedChart);
        ExcelParse.proceed = 0;
        for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
            ExcelParse.proceed += ExcelParse.proceeds.get(i).getIncome();
        }
        makeResultBar();
    }

    @FXML
    void refreshSalary(MouseEvent event) {
        SalaryTable.refresh();
        SalaryBar.getData().clear();
        SalaryChart.getData().clear();
        SalaryBar.setAnimated(false);
        for (int i = 0; i < ExcelParse.slary.size(); i++) {
            SalaryChart.getData().add(new XYChart.Data<>(ExcelParse.slary.get(i).getPost(),
                    (Double.parseDouble(ExcelParse.slary.get(i).getSalary()) * 12 * Double.parseDouble(ExcelParse.slary.get(i).getInsurance()) / 100
                    + ExcelParse.proceed * Double.parseDouble(ExcelParse.slary.get(i).getPercent()) / 100)));
        }
        SalaryBar.getData().addAll(SalaryChart);
        ExcelParse.salary = 0;
        for (int i = 0; i < ExcelParse.slary.size(); i++) {
            ExcelParse.salary += (Double.parseDouble(ExcelParse.slary.get(i).getSalary()) * 12 * Double.parseDouble(ExcelParse.slary.get(i).getInsurance()) / 100
                    + ExcelParse.proceed * Double.parseDouble(ExcelParse.slary.get(i).getPercent()) / 100);
        }
        makeResultBar();
    }

    void makeResultBar() {
        ResultBar.getData().clear();
        ResultChart.getData().clear();
        ResultBar.setAnimated(false);
        double income = ExcelParse.proceed - ExcelParse.salary - ExcelParse.creditYear - ExcelParse.expense;
        ResultChart.getData().add(new XYChart.Data<>("Планируемый доход", ExcelParse.proceed));
        ResultChart.getData().add(new XYChart.Data<>("Затраты на зарплату", ExcelParse.salary));
        ResultChart.getData().add(new XYChart.Data<>("Стоимость основных средств", ExcelParse.fixedS));
        ResultChart.getData().add(new XYChart.Data<>("Гдовая стоимость кредита", ExcelParse.creditYear));
        ResultChart.getData().add(new XYChart.Data<>("Текущие расходы", ExcelParse.expense));
        ResultChart.getData().add(new XYChart.Data<>("Доходы - расходы", income));
        ResultChart.getData().add(new XYChart.Data<>("Доходы - Расходы(учитывая единоразовые)", income - ExcelParse.fixedS));
        ResultChart.getData().add(new XYChart.Data<>("Налог на прибыль", income * 0.15));
        ResultChart.getData().add(new XYChart.Data<>("Чистая прибыль", income - income * 0.15));
        ResultBar.getData().addAll(ResultChart);
    }

    @FXML
    void saveFile(MouseEvent event) throws IOException {
        JFileChooser fileopen = new JFileChooser();
        fileopen.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ret = fileopen.showDialog(null, "Выбрать папку");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            String path = file.getPath();
            path = path + "\\" + fileName.getText() + ".txt";
            file = new File(path);
            FileWriter writer = new FileWriter(file);
            String result = "";
            result += "proceeds \n";
            for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
                result += (ExcelParse.proceeds.get(i).getService()) + " \n";
                result += (ExcelParse.proceeds.get(i).getMeasure()) + " \n";
                result += (ExcelParse.proceeds.get(i).getPrice()) + " \n";
                result += (ExcelParse.proceeds.get(i).getAmount()) + " \n";
            }
            result += "salary \n";
            for (int i = 0; i < ExcelParse.slary.size(); i++) {
                result += (ExcelParse.slary.get(i).getPost()) + " \n";
                result += (ExcelParse.slary.get(i).getSalary()) + " \n";
                result += (ExcelParse.slary.get(i).getPercent()) + " \n";
                result += (ExcelParse.slary.get(i).getInsurance()) + " \n";
                result += (ExcelParse.slary.get(i).getTax()) + " \n";
            }
            result += "credit \n";
            for (int i = 0; i < ExcelParse.credit.size(); i++) {
                result += (ExcelParse.credit.get(i).getValue()) + " \n";
            }
            result += "expenses \n";
            for (int i = 0; i < ExcelParse.expenses.size(); i++) {
                result += (ExcelParse.expenses.get(i).getType()) + " \n";
                result += (ExcelParse.expenses.get(i).getSpend()) + " \n";
            }
            result += "fixed \n";
            for (int i = 0; i < ExcelParse.fixed.size(); i++) {
                result += (ExcelParse.fixed.get(i).getPlace()) + " \n";
                result += (ExcelParse.fixed.get(i).getName()) + " \n";
                result += (ExcelParse.fixed.get(i).getOnePrice()) + " \n";
                result += (ExcelParse.fixed.get(i).getAmount()) + " \n";
            }
            writer.write(result);
            writer.close();
        }
    }

    @FXML
    void downloadFile(MouseEvent event) throws FileNotFoundException {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            ProceedTable.getItems().clear();
            SalaryTable.getItems().clear();
            CreditTable.getItems().clear();
            FixedTable.getItems().clear();
            ExpensesTable.getItems().clear();
            File file = fileopen.getSelectedFile();
            String path = file.getPath();
            String tag = "";
            ExcelParse.credit.add(new Credit(1, "Уставной капитал, руб"));
            ExcelParse.credit.add(new Credit(2, "Величина кредита, руб"));
            ExcelParse.credit.add(new Credit(3, "Годовая процентная ставка, %"));
            for (int i = path.length() - 3; i < path.length(); i++) {
                tag += path.charAt(i);
            }
            if (tag.equals("lsx")) {
                ExcelParse.parse(path);
            } else {
                TextParse.parseText(path);
            }
            ProceedTable.setItems(ExcelParse.proceeds);
            SalaryTable.setItems(ExcelParse.slary);
            CreditTable.setItems(ExcelParse.credit);
            ExpensesTable.setItems(ExcelParse.expenses);
            FixedTable.setItems(ExcelParse.fixed);
            makeResultBar();
        }
    }

    @FXML
    public void initialize() {
        ProceedNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        ProceedUsl.setCellValueFactory(new PropertyValueFactory<>("service"));
        ProceedUsl.setCellValueFactory(new PropertyValueFactory<>("service"));
        ProceedMeasure.setCellValueFactory(new PropertyValueFactory<>("measure"));
        ProceedMeasure.setCellFactory(TextFieldTableCell.forTableColumn());
        ProceedPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        ProceedPrice.setCellFactory(TextFieldTableCell.forTableColumn());
        ProceedAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        ProceedAmount.setCellFactory(TextFieldTableCell.forTableColumn());
        ProceedIncome.setCellValueFactory(new PropertyValueFactory<>("income"));
        ProceedTable.setEditable(true);

        SalaryNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        SalaryPost.setCellValueFactory(new PropertyValueFactory<>("post"));
        SalarySalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        SalarySalary.setCellFactory(TextFieldTableCell.forTableColumn());
        SalaryOfIncome.setCellValueFactory(new PropertyValueFactory<>("percent"));
        SalaryOfIncome.setCellFactory(TextFieldTableCell.forTableColumn());
        SalaryInsurance.setCellValueFactory(new PropertyValueFactory<>("insurance"));
        SalaryInsurance.setCellFactory(TextFieldTableCell.forTableColumn());
        SalaryTax.setCellValueFactory(new PropertyValueFactory<>("tax"));
        SalaryTax.setCellFactory(TextFieldTableCell.forTableColumn());
        SalaryTable.setEditable(true);

        CreditNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        CreditRate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        CreditValue.setCellValueFactory(new PropertyValueFactory<>("value"));
        CreditValue.setCellFactory(TextFieldTableCell.forTableColumn());
        ExcelParse.credit.add(new Credit(1, "Уставной капитал, руб"));
        ExcelParse.credit.add(new Credit(2, "Величина кредита, руб"));
        ExcelParse.credit.add(new Credit(3, "Годовая процентная ставка, %"));
        CreditTable.setEditable(true);

        ExpensesNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        ExpensesType.setCellValueFactory(new PropertyValueFactory<>("type"));
        ExpensesSpend.setCellValueFactory(new PropertyValueFactory<>("spend"));
        ExpensesTable.setEditable(true);

        FixedNum.setCellValueFactory(new PropertyValueFactory<>("num"));
        FixedPlace.setCellValueFactory(new PropertyValueFactory<>("place"));
        FixedPlace.setCellFactory(TextFieldTableCell.forTableColumn());
        FixedName.setCellValueFactory(new PropertyValueFactory<>("name"));
        FixedName.setCellFactory(TextFieldTableCell.forTableColumn());
        FixedPrice.setCellValueFactory(new PropertyValueFactory<>("onePrice"));
        FixedPrice.setCellFactory(TextFieldTableCell.forTableColumn());
        FixedAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        FixedAmount.setCellFactory(TextFieldTableCell.forTableColumn());
        FixedSpend.setCellValueFactory(new PropertyValueFactory<>("spend"));
        FixedTable.setEditable(true);

        ProceedTable.setItems(ExcelParse.proceeds);
        SalaryTable.setItems(ExcelParse.slary);
        CreditTable.setItems(ExcelParse.credit);
        ExpensesTable.setItems(ExcelParse.expenses);
        FixedTable.setItems(ExcelParse.fixed);
    }

}
