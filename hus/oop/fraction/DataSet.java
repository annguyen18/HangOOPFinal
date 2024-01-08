package hus.oop.fraction;

import javax.xml.crypto.Data;
import java.util.Arrays;

public class DataSet {
    private static int DEFAULT_CAPACITY = 8;
    private Fraction[] data;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public DataSet() {
        data = new Fraction[DEFAULT_CAPACITY];
        length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số theo data.
     * @param data
     */
    public DataSet(Fraction[] data) {
        this.length = data.length;
        this.data = data;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    public boolean insert(Fraction fraction, int index) {
        if (index < 0 || index > length)
            return false;

        if (length == data.length) {
            Fraction[] newData = new Fraction[data.length * 2];
            for (int i = 0; i < length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        for (int i = length; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = fraction;
        length++;
        return true;
    }

    private Fraction simplify(int numerator, int denominator) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(numerator, denominator); i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }

        return new Fraction(numerator / gcd, denominator / gcd);
    }

    /**
     * Phương thức tạo ra một tập dữ liệu lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     * @return tập dữ liệu mới lưu các phân số tối giản của các phân số trong tập dữ liệu gốc.
     */
    public DataSet toSimplify() {
        DataSet dataSet = new DataSet(data);
        for (int i = 0; i < data.length; i++) {
            dataSet.append(simplify(data[i].getNumerator(), data[i].getDenominator()));
        }

        return dataSet;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dứ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return
     */
    public void append(Fraction fraction) {
        if (length == data.length)
            enlarge();

        data[length] = fraction;
        length++;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị tăng dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số tăng dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị tăng dần.
     */
    public Fraction[] sortIncreasing() {
        // bubble sort
         Fraction[] sorted = Arrays.copyOf(data, data.length);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (sorted[j].compareTo(sorted[j + 1]) > 0) {
                    Fraction temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        // Return the sorted copy
        return sorted;
    }

    /**
     * Sắp xếp mảng các phân số theo thứ tự có giá trị giảm dần.
     * Nếu hai phân số bằng nhau thì sắp xếp theo thứ tự có mẫu số giảm dần.
     * @return mảng mới được sắp xếp theo thứ tự có giá trị giảm dần.
     */
    public Fraction[] sortDecreasing() {
        Fraction[] sorted = Arrays.copyOf(data, data.length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (sorted[j].compareTo(sorted[j + 1]) < 0) {
                    Fraction temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void enlarge() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return (index >= 0 && index <= upperBound);
    }

    /**
     * In ra tập dữ liệu theo định dạng [a1, a2, ... , an].
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        if (length > 0) {
            result.append(this.data[0]);

            for (int i = 1; i < length; i++) {
                result.append(", ").append(this.data[i]);
            }
        }

        result.append("]");
        return result.toString();
    }

    /**
     * In ra mảng các phân số fractions theo định dạng [a1, a2, ... , an].
     * @param fractions
     */
    public static void printFractions(Fraction[] fractions) {
        StringBuilder result = new StringBuilder("[");

        if (fractions.length > 0) {
            result.append(fractions[0]);

            for (int i = 1; i < fractions.length; i++) {
                result.append(", ").append(fractions[i]);
            }
        }

        result.append("]");
        System.out.println(result);
    }
}
