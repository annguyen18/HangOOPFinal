package hus.oop.fraction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FractionTestDrive {
    public static void main(String[] args) {
        /*
        TODO:
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu DataSet, được gọi là dataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.

         5. - Chạy chương trình và lưu kết quả chạy chương trình và file text được đặt tên
              là <TenSinhVien_MaSinhVien_Fraction>.txt (Ví dụ, NguyenVanA_123456_Fraction.txt).
            - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
              <TenSinhVien_MaSinhVien_Fraction>.zip (Ví dụ, NguyenVanA_123456_Fraction.zip),
              nộp lên classroom.
         */
        Random rand = new Random();
        int numbers = rand.nextInt(30, 50);

        Fraction[] fractions = new Fraction[5];

        for (int i = 0; i < 5; i++) {
            Fraction num = new Fraction(rand.nextInt(1, 101), rand.nextInt(1, 101));
            fractions[i] = num;

        }
        DataSet dataSet = new DataSet(fractions);
        System.out.println(dataSet);

        System.out.println("tang dan: ");
        dataSet.printFractions(dataSet.sortIncreasing());
        System.out.println("giam dan: ");
        DataSet.printFractions(dataSet.sortDecreasing());

        System.out.println("phan so toi gian: ");
        System.out.println(dataSet.toSimplify().toString());
        System.out.println("phan so toi gian tang dan: ");
        DataSet.printFractions(dataSet.toSimplify().sortIncreasing());
        System.out.println("phan so toi gian giam dan: ");
        DataSet.printFractions(dataSet.toSimplify().sortDecreasing());


    }
}
