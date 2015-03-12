package generics;

/**
 * Created by user on 03.03.15.
 */
public abstract class Product<T extends Product<T>> implements Comparable<T> {

    private String name;
    private Integer age;

    public Product(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public abstract int compareTo(T t);

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product p = (Product) o;
        if (!this.name.equals(p)) return false;
        if (!this.age.equals(p)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime * name.hashCode();
        return result = result * prime * age.hashCode();
    }

    public static void main(String[] args) {
        Kind1 kind11 = new Kind1();
        Kind1 kind12 = new Kind1();

        kind11.compareTo(kind12);
    }
}
