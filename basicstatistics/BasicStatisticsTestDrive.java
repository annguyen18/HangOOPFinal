package hus.oop.basicstatistics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BasicStatisticsTestDrive {
    static String path = "BuiThuHang_20001549_BasicStatistics.txt";
    public static void main(String[] args) throws IOException {
        /*
           - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_BasicStatistics>.txt (Ví dụ, NguyenVanA_123456_BasicStatistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_BasicStatistics>.zip (Ví dụ, NguyenVanA_123456_BasicStatistics.zip),
             nộp lên classroom.
         */

        testMyArrayList();
        testMyLinkedList();
    }

    public static void testMyArrayList() throws IOException {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một danh sách kiểu MyArrayList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra các dữ liệu và các đại lượng thống kê.
         */
        Random rand = new Random();
        int length = rand.nextInt(30, 51);
        MyList list = new MyArrayList();
        for (int i = 0; i<length; i++) {
            list.append(rand.nextDouble(1,20));
        }

        BasicStatistic basicStatistic = new BasicStatistic(list);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("testMyArrayList\n");
            System.out.print("max: ");
            System.out.println(basicStatistic.max());
            writer.write("max: " + basicStatistic.max() + "\n");
            System.out.print("min: ");
            System.out.println(basicStatistic.min());
            writer.write("min: " + basicStatistic.min() + "\n");
            System.out.print("ky vong: ");
            System.out.println(basicStatistic.mean());
            writer.write("ky vong: " + basicStatistic.mean() + "\n");
            System.out.print("phuong sai: ");
            System.out.println(basicStatistic.variance());
            writer.write("phuong sai: " + basicStatistic.variance() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testMyLinkedList() throws IOException {
        /*
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo ra một danh sách kiểu MyLinkedList có các phần tử dữ liệu kiểu Double, các giá trị của phần
             tử được sinh ngẫu nhiên nằm trong đoạn [1, 20].
           - Sử dụng BasicStatistic để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai).
             In ra terminal các thông tin về dữ liệu và các đại lượng thống kê.
         */
        Random rand = new Random();
        int length = rand.nextInt(30, 51);
        MyList list = new MyLinkedList();
        for (int i = 0; i<length; i++) {
            list.append(rand.nextDouble(1,20));
        }
        BasicStatistic basicStatistic = new BasicStatistic(list);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write("\ntestMyArrayList\n");
            System.out.print("max: ");
            System.out.println(basicStatistic.max());
            writer.write("max: " + basicStatistic.max() + "\n");
            System.out.print("min: ");
            System.out.println(basicStatistic.min());
            writer.write("min: " + basicStatistic.min() + "\n");
            System.out.print("ky vong: ");
            System.out.println(basicStatistic.mean());
            writer.write("ky vong: " + basicStatistic.mean() + "\n");
            System.out.print("phuong sai: ");
            System.out.println(basicStatistic.variance());
            writer.write("phuong sai: " + basicStatistic.variance());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
