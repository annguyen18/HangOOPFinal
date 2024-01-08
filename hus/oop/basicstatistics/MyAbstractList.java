package hus.oop.basicstatistics;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyIterator iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
