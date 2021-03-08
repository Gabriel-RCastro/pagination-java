public class Ad {
    private final String id;
    private final String name;

    public Ad(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Ad of(String id, String name) {
        return new Ad(id, name);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
