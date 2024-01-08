package hus.oop.basicstatistics;

import java.util.NoSuchElementException;

public class MyLinkedList extends MyAbstractList {
    private MyLinkedListNode head;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        head = null;
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        int count = 0;
        MyLinkedListNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getPayload();
    }

    /**
     * Xóa phần tử của list ở vị trí index.
     * @param index
     */
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            MyLinkedListNode previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            previous.setNext(previous.getNext().getNext());
        }
    }

    /**
     * Thêm vào cuối list phần tử có dữ liệu payload.
     * @param payload
     */
    @Override
    public void append(Object payload) {
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if (head == null) {
            head = newNode;
        } else {
            MyLinkedListNode lastNode = head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(newNode);
        }
    }

    /**
     * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Object payload, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        // if the index is zero, set the new node as the head
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            MyLinkedListNode previousNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }
            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
        }
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        return new MyLinkedListIterator(head);
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyLinkedListNode getNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        // return the node
        return currentNode;

    }
    private class MyLinkedListIterator implements MyIterator {
        /*
         * MyLinkedListIterator cần phải tham chiếu đến node hiện tại của MyLinkedList để có thể duyệt qua
           các phần tử còn lại trong MyLinkedList.
        */
        private MyLinkedListNode currentNode;
        private MyLinkedListNode previousNode;

        /**
         * Khởi tạo dữ liệu cho Iterator là node hiện tại trong MyLinkedList.
         * @param node
         */
        public MyLinkedListIterator(MyLinkedListNode node) {
            this.currentNode = node;
        }

        /**
         * Kiểm tra trong MyLinkedList có còn phần tử tiếp theo không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
         * @return payload của phần tử hiện tại.
         */
        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object payload = currentNode.getPayload();
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            return payload;
        }

        @Override
        public void remove() {
            if (previousNode == null) {
                throw new IllegalStateException();
            }
            if (previousNode == head) {
                head = currentNode;
            } else {
                MyLinkedListNode beforePrevious = head;
                while (beforePrevious.getNext() != previousNode) {
                    beforePrevious = beforePrevious.getNext();
                }
                beforePrevious.setNext(currentNode);
            }
            previousNode = null;
        }
    }
}
