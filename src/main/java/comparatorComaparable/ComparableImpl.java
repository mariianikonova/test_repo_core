package comparatorComaparable;

/**
 * Created by user on 03.03.15.
 */

public class ComparableImpl implements Comparable<ComparableImpl> {

    private String name;
    private Integer age;

    public ComparableImpl(String name) {
        this.name = name;
    }

    public ComparableImpl(String name, Integer age) {

        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(ComparableImpl o) {
        int res = this.getName().compareTo(o.getName());
        if (res != 0) {
            return res;
        }
        return this.getAge().compareTo(o.getAge());
    }
}
