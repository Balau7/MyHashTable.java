public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name == null ? 0 : name.length());
        return result;
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) o;
        return id == other.id && name.equals(other.name);
    }
}
