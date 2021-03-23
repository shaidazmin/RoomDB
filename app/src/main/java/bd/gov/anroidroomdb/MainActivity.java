package bd.gov.anroidroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import bd.gov.anroidroomdb.room.MyRoomDB;
import bd.gov.anroidroomdb.room.StudentInfo;

public class MainActivity extends AppCompatActivity {

    private EditText name, department, subject, id;
    private Button save, show, update, delete;

    private MyRoomDB roomDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.name_edit_text);
        department = findViewById(R.id.dep_edit_text);
        subject = findViewById(R.id.sub_edit_text);
        id = findViewById(R.id.id_edit_text);

        save = findViewById(R.id.save_btn);
        show = findViewById(R.id.show_btn);
        update = findViewById(R.id.update_btn);
        delete = findViewById(R.id.delete_btn);

        setDatabase();

        save.setOnClickListener( v -> {
            saveDataOnDb();

        });

        show.setOnClickListener(a ->  showDataFromDb() );

        update.setOnClickListener( a -> updateUserInfo());

        delete.setOnClickListener( a -> deleteUserInfo());

    }

    private void deleteUserInfo() {
        roomDB.studentDAO().deleteStudentInfo(Integer.parseInt(id.getText().toString()));
        showDataFromDb();
    }

    private void updateUserInfo() {
        roomDB.studentDAO().updateStudentInfo(name.getText().toString(), subject.getText().toString(), Integer.parseInt(id.getText().toString()));
        showDataFromDb();
    }

    private void showDataFromDb() {

        List<StudentInfo> studentInfoList = roomDB.studentDAO().getAllStudent();
        for (int i = 0; i<studentInfoList.size(); i++){
            Log.d("StuentInfo", studentInfoList.get(i).getId()+"\t"
                    +studentInfoList.get(i).getName()+"\t"
                    +studentInfoList.get(i).getSubject()+"\t"
                    +studentInfoList.get(i).getDepartment());
        }
    }

    private void saveDataOnDb() {
        StudentInfo studentInfo = new StudentInfo(name.getText().toString(), subject.getText().toString(), department.getText().toString());
        roomDB.studentDAO().insertStudent(studentInfo);
    }

    private void setDatabase(){
        roomDB = Room.databaseBuilder(MainActivity.this, MyRoomDB.class,"RoomStudentDB")
                .allowMainThreadQueries().build();
    }
}