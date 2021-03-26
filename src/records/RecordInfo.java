package records;

public class RecordInfo {
    private final String name;
    private final String ID;
    private final int marks;

    public RecordInfo(String name, String ID, int marks) {
        this.name = name;
        this.ID = ID;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getMarks() {
        return marks;
    }
}
