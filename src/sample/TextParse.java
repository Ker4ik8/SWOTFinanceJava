package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextParse {

    public static void parseText(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String line = "";
        String v1;
        String v2;
        String v3;
        String v4;
        String v5;
        int flag = 0;
        int number = 0;
        while (sc.hasNext()) {
            v1 = sc.nextLine();
            line = v1.replaceAll("\n", "");
            line = line.replaceAll(" ", "");
            if (line.equals("proceeds")) {
                flag = 1;
                number = 0;
                v1 = sc.nextLine();
            } else if (line.equals("salary")) {
                flag = 2;
                number = 0;
                v1 = sc.nextLine();
            } else if (line.equals("credit")) {
                flag = 3;
                number = 0;
                v1 = sc.nextLine();
            } else if (line.equals("expenses")) {
                flag = 4;
                number = 0;
                v1 = sc.nextLine();
            } else if (line.equals("fixed")) {
                flag = 5;
                number = 0;
                v1 = sc.nextLine();
            }
            if (flag == 1) {
                number++;
                v2 = sc.nextLine().replaceAll(" \n", "");
                v3 = sc.nextLine().replaceAll(" \n", "");
                v4 = sc.nextLine().replaceAll(" \n", "");
                ExcelParse.proceeds.add(new Proceeds(number, v1, v2, v3, v4,
                        Double.parseDouble(v3) * Double.parseDouble(v4)));
            }
            if (flag == 2) {
                number++;
                v2 = sc.nextLine().replaceAll(" \n", "");
                v3 = sc.nextLine().replaceAll(" \n", "");
                v4 = sc.nextLine().replaceAll(" \n", "");
                v5 = sc.nextLine().replaceAll(" \n", "");
                ExcelParse.slary.add(new Salary(number, v1, v2, v3, v4, v5));
            }
            if (flag == 3) {
                number++;
                ExcelParse.credit.get(number - 1).setValue(v1);
            }
            if (flag == 4) {
                number++;
                v2 = sc.nextLine().replaceAll(" \n", "");
                ExcelParse.expenses.add(new Expenses(number, v1, v2));
            }
            if (flag == 5) {
                number++;
                v2 = sc.nextLine().replaceAll(" \n", "");
                v3 = sc.nextLine().replaceAll(" \n", "");
                v4 = sc.nextLine().replaceAll(" \n", "");
                ExcelParse.fixed.add(new Fixed(number, v1, v2, v3, v4,
                        Double.parseDouble(v3) * Double.parseDouble(v4)));
            }
        }
        ExcelParse.proceed = 0;
        for (int i = 0; i < ExcelParse.proceeds.size(); i++) {
            ExcelParse.proceed += ExcelParse.proceeds.get(i).getIncome();
        }
        ExcelParse.salary = 0;
        for (int i = 0; i < ExcelParse.slary.size(); i++) {
            ExcelParse.salary += (Double.parseDouble(ExcelParse.slary.get(i).getSalary()) * 12 * Double.parseDouble(ExcelParse.slary.get(i).getInsurance()) / 100
                    + ExcelParse.proceed * Double.parseDouble(ExcelParse.slary.get(i).getPercent()) / 100);
        }
        ExcelParse.expense = 0;
        for (int i = 0; i < ExcelParse.expenses.size(); i++) {
            ExcelParse.expense += Double.parseDouble(ExcelParse.expenses.get(i).getSpend());
        }
        ExcelParse.fixedS = 0;
        for (int i = 0; i < ExcelParse.fixed.size(); i++) {
            ExcelParse.fixedS += ExcelParse.fixed.get(i).getSpend();
        }
    }

}
