package records;

import java.util.ArrayList;

public class Records {
    private static final ArrayList<RecordInfo> studentList = new ArrayList<>();

    public Records(){
        studentList.add(new RecordInfo("mahadi", "193-15-13519", 549));
        studentList.add(new RecordInfo("arafat", "193-15-13512", 557));
        studentList.add(new RecordInfo("nayeem", "193-15-13434", 520));
        studentList.add(new RecordInfo("sazid", "193-15-13475", 536));
    }

    public ArrayList<RecordInfo> getList() {
        return studentList;
    }
}