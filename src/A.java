import java.util.Objects;

/**
 * @Author:hdx
 * @Date:2022/5/17 16:16
 * @Description:
 */
public class A {

    private Integer a;
    private String b;


    public A(Integer a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a1 = (A) o;
        return Objects.equals(getA(), a1.getA()) &&
                Objects.equals(getB(), a1.getB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB());
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
