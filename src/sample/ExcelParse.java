package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ExcelParse {

    public static ObservableList<Proceeds> proceeds = FXCollections.observableArrayList();
    public static ObservableList<Salary> slary = FXCollections.observableArrayList();
    public static ObservableList<Credit> credit = FXCollections.observableArrayList();
    public static ObservableList<Expenses> expenses = FXCollections.observableArrayList();
    public static ObservableList<Fixed> fixed = FXCollections.observableArrayList();
    public static double proceed = 0;
    public static double salary = 0;
    public static double fixedS = 0;
    public static double creditYear = 0;
    public static double expense = 0;


    public static void parse(String fileName) {
        //инициализируем потоки
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = null;
        if (workBook != null) {
            sheet = workBook.getSheetAt(0);
        }
        Iterator<Row> it = null;
        if (sheet != null) {
            it = sheet.iterator();
        }
        int number = 0;
        if (it != null) {
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                Cell cell = cells.next();
                String v1 = "", v2 = "", v3 = "", v4 = "";
                if (!cell.getStringCellValue().equals("") && !cell.getStringCellValue().equals("Наименование услуги")) {
                    number++;
                    v1 = cell.getStringCellValue();
                    cell = cells.next();
                    v2 = cell.getStringCellValue();
                    cell = cells.next();
                    v3 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    cell = cells.next();
                    v4 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    proceeds.add(new Proceeds(number, v1, v2, v3, v4, Double.parseDouble(v3) * Double.parseDouble(v4)));
                }

            }
        }
        for (int i = 0; i < proceeds.size(); i++) {
            proceed += proceeds.get(i).getIncome();
        }

        number = 0;
        if (workBook != null) {
            sheet = workBook.getSheetAt(1);
        }
        if (sheet != null) {
            it = sheet.iterator();
        }
        if (it != null) {
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                Cell cell = cells.next();
                String v1 = "", v2 = "", v3 = "", v4 = "", v5 = "";
                if (!cell.getStringCellValue().equals("") && !cell.getStringCellValue().equals("Должность")) {
                    number++;
                    v1 = cell.getStringCellValue();
                    cell = cells.next();
                    v2 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    cell = cells.next();
                    v3 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    cell = cells.next();
                    v4 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    cell = cells.next();
                    v5 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    slary.add(new Salary(number, v1, v2, v3, v4, v5));
                }

            }
        }
        for (int i = 0; i < slary.size(); i++) {
            salary += (Double.parseDouble(slary.get(i).getSalary()) * 12 * Double.parseDouble(slary.get(i).getInsurance()) / 100
                    + proceed * Double.parseDouble(slary.get(i).getPercent()) / 100);
        }

        number = 0;
        if (workBook != null) {
            sheet = workBook.getSheetAt(2);
        }
        if (sheet != null) {
            it = sheet.iterator();
        }
        if (it != null) {
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                if (cells.hasNext()) {
                    Cell cell = cells.next();
                    String v1 = "", v2 = "";
                    if (!cell.getStringCellValue().equals("") && !cell.getStringCellValue().equals("Показатель")) {
                        number++;
                        v1 = cell.getStringCellValue();
                        cell = cells.next();
                        v2 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                        credit.get(number - 1).setValue(v2);
                    }
                }

            }
        }
        creditYear = Double.parseDouble(credit.get(1).getValue()) * Double.parseDouble(credit.get(2).getValue()) / 100;

        number = 0;
        if (workBook != null) {
            sheet = workBook.getSheetAt(3);
        }
        if (sheet != null) {
            it = sheet.iterator();
        }
        if (it != null) {
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                Cell cell = cells.next();
                String v1 = "", v2 = "";
                if (!cell.getStringCellValue().equals("") && !cell.getStringCellValue().equals("Вид расхода")) {
                    number++;
                    v1 = cell.getStringCellValue();
                    cell = cells.next();
                    v2 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    expenses.add(new Expenses(number, v1, v2));
                }

            }
        }
        for (int i = 0; i < expenses.size(); i++) {
            expense += Double.parseDouble(expenses.get(i).getSpend());
        }

        number = 0;
        if (workBook != null) {
            sheet = workBook.getSheetAt(4);
        }
        if (sheet != null) {
            it = sheet.iterator();
        }
        if (it != null) {
            while (it.hasNext()) {
                Row row = it.next();
                Iterator<Cell> cells = row.iterator();
                Cell cell = cells.next();
                String v1 = "", v2 = "", v3 = "", v4 = "";
                if (!cell.getStringCellValue().equals("") && !cell.getStringCellValue().equals("Комментарии")) {
                    number++;
                    v1 = cell.getStringCellValue();
                    cell = cells.next();
                    v2 = cell.getStringCellValue();
                    cell = cells.next();
                    v3 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    cell = cells.next();
                    v4 = java.math.BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                    fixed.add(new Fixed(number, v1, v2, v3, v4, Double.parseDouble(v3) * Double.parseDouble(v4)));
                }

            }
        }
        for (int i = 0; i < fixed.size(); i++) {
            fixedS += fixed.get(i).getSpend();
        }
    }
}
