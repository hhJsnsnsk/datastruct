package preface;

/**
 * @author starrysky
 */
public class MemoryDemo {
    public static void main(String[] args) {
        MemoryCell cell = new MemoryCell();
        cell.write(new Integer(11));
        Object val = cell.read();
        Integer i = (Integer) val;
        int value = i.intValue();
        System.out.println(value);
    }
}
