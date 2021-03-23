package bd.gov.anroidroomdb.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudentInfo {

    @PrimaryKey (autoGenerate = true)
    int id;
    String name;
    String subject;
    String department;

    public StudentInfo(String name, String subject, String department) {
        this.name = name;
        this.subject = subject;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
