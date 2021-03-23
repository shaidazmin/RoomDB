package bd.gov.anroidroomdb.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public void insertStudent(StudentInfo studentInfo);

    @Query("SELECT * FROM StudentInfo")
    public List<StudentInfo> getAllStudent();

    @Query("UPDATE StudentInfo SET name = :name, subject = :subject WHERE id = :id")
    public void updateStudentInfo(String name, String subject, int id);

    @Query("DELETE FROM StudentInfo WHERE id = :id")
    public void deleteStudentInfo(int id);

}
