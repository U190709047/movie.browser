package tr.edu.mu.ceng.week8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    StudentViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new ViewModelProvider(this).get(StudentViewModel.class);
        model.fetchStudent(1);
        TextView txtGrade = findViewById(R.id.txtGrade);
        model.studentLiveData.observe(this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                Log.d("MainActivity", "student name = " + student.name);
                Log.d("MainActivity", "student name = " + student.score);

                txtGrade.setText(model.getLetterGrade());
            }
        });

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.fetchStudent(2);
            }
        });
    }
}