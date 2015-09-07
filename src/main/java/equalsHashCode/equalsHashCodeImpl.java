package equalsHashCode;


/**
 * Created by user on 04.03.15.
 */
class EqualsHashCodeImpl implements Comparable<EqualsHashCodeImpl> {

    String name;
    int age;

    public EqualsHashCodeImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public EqualsHashCodeImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        EqualsHashCodeImpl inst = (EqualsHashCodeImpl) o;
        if (inst.getName() == null || !inst.getName().equals(this.getName())) {
            return false;
        }
        if (inst.getAge() != this.getAge()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 32;
        int res = 1;
        res = prime * this.getName().hashCode();
        res = prime * this.getAge();
        return res;
    }

    public int compareTo(EqualsHashCodeImpl o) {
        return this.getName().compareTo(o.getName()) == 0 ? Integer.compare(this.getAge(), o.getAge()) : this.getName().compareTo(o.getName());
    }
}
