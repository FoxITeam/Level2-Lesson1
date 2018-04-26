package ru.foxit.grayfox;


 /*1. Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)
         1 3 1 2
         2 3 2 2
         5 6 7 1
         3 3 1 0
         Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив
         типа String[][];
         2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и
         вернуть результат;
         3. Ваш метод должен бросить исключения в случаях:
         Если размер матрицы, полученной из строки, не равен 4x4;
         Если в одной из ячеек полученной матрицы не число; (например символ или слово)
         4. В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.
 */

import static ru.foxit.grayfox.Main.stringToArray;

public class Main {

    public static void main(String[] args) {
        String strings = new String("1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"); //нужный вид строки
        String stringsOne = new String("1 3 1 2\n2 3 G b\n5 6 7 1\n3 3 1 0"); //MyArrayDataException
        String stringsTwo = new String ("1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n2 3 2 2"); //MyArraySizeException

        try {
            System.out.println(stringToArray(strings));}
        catch (RuntimeException rune){
            rune.printStackTrace();
        }

    }

    public static int stringToArray(String string) {//task1
        String[] arrays = string.split("\n");
        if (arrays.length != 4) throw new MyArraySizeException("Кол-во строк в матрице не равно 4x4");
        String[][] matrixArrays = {
                arrays[0].split(" "),
                arrays[1].split(" "),
                arrays[2].split(" "),
                arrays[3].split(" "),
        };

        int[][] intArrays = new int[4][4]; //task2
        for (int i = 0; i < matrixArrays.length; i++) {
            for (int j = 0; j < matrixArrays[i].length; j++) {
                try {
                    intArrays[i][j] = Integer.parseInt(matrixArrays[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В матрице,в строке "+i+" столбце "+j+" не число (символ/слово)"
                    );
                }
            }
        }for (int i = 0; i < matrixArrays.length; i++) {
            for (int j = 0; j < matrixArrays.length; j++) {
                System.out.print(intArrays[i][j] + " ");
            }System.out.println(" ");
        }System.out.println("=======");
        int sum = 0;
        int div;
        for (int i = 0; i < intArrays.length; i++) {
            for (int j = 0; j < intArrays[i].length; j++) {
                sum += intArrays[i][j];
            }
        }div = sum / 2;
        System.out.print("Сумма нашей матрицы, деленная на 2, равна ");
        return div;
    }
}
