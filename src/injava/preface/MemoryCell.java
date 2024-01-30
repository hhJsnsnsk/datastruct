package preface;

/**
 * @author starrysky
 */
public class MemoryCell {
    // private internal data representation
    private Object storedVal;

    /**
     * only reference types are compatible with Object
     * 只有引用类型能够与Object相容
     */
    public void write(Object x) {
        storedVal = x;
    }

    public Object read() {
        return storedVal;
    }

    public static void main(String[] args) {
        MemoryCell cell = new MemoryCell();
        cell.write("37");
        Object val = cell.read();
        String i = (String) val;
        System.out.println(i);
        System.out.println(val.toString());
    }

}
