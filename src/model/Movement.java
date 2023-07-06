package model;

public class Movement {
    short id;
    String name;
    int value;

    public Movement(short id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
