package hus.oop.fraction;

public class Fraction implements FractionComparable {
    private int numerator;
    private int denominator;

    /**
     * Hàm dựng khởi tạo giá trị mặc định là 1/1.
     */
    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Hàm dựng khởi tạo giá trị cho tử số và mẫu số.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Hàm dựng copy, copy giá trị của phân số truyền vào.
     * @param copyFraction
     */
    public Fraction(Fraction copyFraction) {
        this.numerator = copyFraction.numerator;
        this.denominator = copyFraction.denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu byte của phân số.
     * @return
     */
    public byte byteValue() {
        return (byte) (numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu int của phân số.
     * @return
     */
    public int intValue() {
        return numerator / denominator;
    }

    /**
     * Phương thức trả về giá trị kiểu long của phân số.
     * @return
     */
    public long longValue() {
        return (long) (numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu short của phân số.
     * @return
     */
    public short shortValue() {
        return (short) (numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu double của phân số.
     * @return
     */
    public double doubleValue() {
        return ((double) numerator / denominator);
    }

    /**
     * Phương thức trả về giá trị kiểu float của phân số.
     * @return
     */
    public float floatValue() {
        return (float) numerator / (float) denominator;
    }

    /**
     * Phương thức tính ước số chung lớn nhất của tử số và mẫu số.
     * @return ước số chung lớn nhất của tử số và mẫu số.
     */
    private int gcd() {
        int gcd = 1;
        // Loop from 1 to the minimum of numerator and denominator
        for (int i = 1; i <= Math.min(numerator, denominator); i++) {
            // If both numerator and denominator are divisible by i, update the GCD
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    /**
     * Phương thức rút gọn phân số về phân số tối giản.
     */
    private void simplify() {
        this.numerator = this.numerator / gcd();
        this.denominator = this.denominator / gcd();
    }

    @Override
    public int compareTo(Fraction another) {
        int product1 = numerator * another.denominator;
        int product2 = another.numerator * denominator;

        if (product1 < product2)
            return -1;
        else if (product1 == product2)
            return 0;
        return 1;
    }

    /**
     * Phương thức mô tả phân số theo định dạng numerator/denominator;
     * @return
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}
