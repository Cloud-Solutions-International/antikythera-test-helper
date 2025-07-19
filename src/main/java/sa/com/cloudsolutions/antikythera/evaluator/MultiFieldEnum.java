package sa.com.cloudsolutions.antikythera.evaluator;

public enum MultiFieldEnum {
    SMILEY("SMILEY", 1), KARLA("KARLA", 2);
    int id;
    String name;

    MultiFieldEnum( String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
