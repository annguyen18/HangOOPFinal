package hus.oop.basicstatistics;

import java.util.NoSuchElementException;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            // Nếu không, ném ra ngoại lệ
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Nếu có, trả về phần tử tại vị trí index trong data
        return data[index];
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            // Nếu không, ném ra ngoại lệ
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Nếu có, dịch chuyển các phần tử từ index + 1 đến size - 1 sang trái một vị trí
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        // Gán phần tử cuối cùng trong data bằng null
        data[size - 1] = null;
        // Giảm size đi 1
        size--;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        if (size == data.length) {
            // Nếu có, gọi phương thức enlarge để cấp phát thêm chỗ cho data
            enlarge();
        }
        // Gán phần tử tại vị trí size trong data bằng payload
        data[size] = payload;
        // Tăng size lên 1
        size++;
    }

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        if (index < 0 || index > size) {
            // Nếu không, ném ra ngoại lệ
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // Kiểm tra size có bằng độ dài của data không
        if (size == data.length) {
            // Nếu có, gọi phương thức enlarge để cấp phát thêm chỗ cho data
            enlarge();
        }
        // Dịch chuyển các phần tử từ size - 1 đến index sang phải một vị trí
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        // Gán phần tử tại vị trí index trong data bằng payload
        data[index] = payload;
        // Tăng size lên 1
        size++;
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        return new MyArrayListIterator(data);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void enlarge() {
        Object[] newData = new Object[data.length * 2];
        // Sao chép các phần tử từ data sang newData
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        // Gán data bằng newData
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
            /*
             * MyArrayListIterator cần phải biết vị trí hiện tại khi nó đang duyệt qua dữ liệu của MyArrayList.
             */
            private int currentPosition;

            /**
             * Khởi tạo dữ liệu cho Iterator bằng dữ liệu của MyArrayList để nó có thể duyệt qua các phần tử dữ liệu
             * của MyArrayList.
             * @param data
             */
            public MyArrayListIterator(Object[] data) {
                MyArrayList myArrayList = new MyArrayList();
                myArrayList.data = data;
                currentPosition = 0;
            }

        /**
         * Kiểm tra trong MyArrayList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra phần tử hiện tại của MyArrayList.
         * @return phần tử hiện tại.
         */
        @Override
        public Object next() {
            if (hasNext()) {
                // Nếu có, trả về phần tử tại vị trí currentPosition trong data và tăng currentPosition lên 1
                return data[currentPosition++];
            } else {
                // Nếu không, ném ra ngoại lệ
                throw new NoSuchElementException("No more elements in the list");
            }
        }

        /**
         * Iterator xóa phần tử hiện tại của MyArrayList.
         */
        @Override
        public void remove() {
            if (currentPosition > 0) {
                // Nếu có, gọi phương thức remove của MyArrayList với tham số là currentPosition - 1
                MyArrayList.this.remove(currentPosition - 1);
                // Giảm currentPosition đi 1
                currentPosition--;
            } else {
                // Nếu không, ném ra ngoại lệ
                throw new IllegalStateException("Cannot remove before calling next");
            }
        }
    }
}
