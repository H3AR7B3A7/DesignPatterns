package Caching;

import java.util.Objects;

public class Caching {
    /**
     * HashCode methods must adhere to contract::
     * - Consistent
     * - Two objects that are equal must have the same hashcode
     * - Hash table performance is better if objects that are not equal have different hashCodes
     *
     * When caching hashCodes, make sure the objects are immutable!!!
     */
    public static void main(String[] args) {
        ExpensiveToHash o = new ExpensiveToHash(1,"Steven","1234");
        ExpensiveToHash p = new ExpensiveToHash(1,"Steven","1234");

        System.out.println(o.equals(p));
        System.out.println(o.hashCode());
        System.out.println(p.hashCode());
    }
}

class ExpensiveToHash {
    private final int id;
    private final String name;
    private final String number;
    private int hashCode;

    public ExpensiveToHash(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpensiveToHash that = (ExpensiveToHash) o;
        return id == that.id && hashCode == that.hashCode && Objects.equals(name, that.name) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0){
            result = Integer.hashCode(id);
            result = 31 * result + name.hashCode();
            result = 31 * result + number.hashCode();
            hashCode = result;  // Cache the hashCode
        }
        return result;
    }
}
