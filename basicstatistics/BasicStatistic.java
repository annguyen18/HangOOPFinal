package hus.oop.basicstatistics;

import java.util.NoSuchElementException;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        if (data.size() == 0) {
            throw new NoSuchElementException();
        }
        double max = (double) data.get(0);
        for (int i = 1; i < data.size(); i++) {
            double current = (double) data.get(i);
            if (current > max) {
                max = current;
            }
        }
        return max;

    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            throw new NoSuchElementException();
        }
        double min = (double) data.get(0);
        for (int i = 1; i < data.size(); i++) {
            double current = (double) data.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        if (data.size() == 0) {
            throw new NoSuchElementException();
        }
        // otherwise, initialize the sum to zero
        double sum = 0;
        // loop through the list elements
        for (int i = 0; i < data.size(); i++) {
            // get the current element as a double and add it to the sum
            double current = (double) data.get(i);
            sum += current;
        }
        // calculate the mean by dividing the sum by the size of the list
        // return the mean
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() == 0) {
            throw new NoSuchElementException();
        }
        // otherwise, get the mean of the list
        double mean = mean();
        // initialize the squared difference sum to zero
        double squaredDifferenceSum = 0;
        // loop through the list elements
        for (int i = 0; i < data.size(); i++) {
            // get the current element as a double and subtract it from the mean
            double current = (double) data.get(i);
            double difference = current - mean;
            // square the difference and add it to the squared difference sum
            double squaredDifference = difference * difference;
            squaredDifferenceSum += squaredDifference;
        }
        // calculate the variance by dividing the squared difference sum by the size of the list
        // return the variance
        return squaredDifferenceSum / data.size();
    }
}
