package tr.edu.mu.ceng.week8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {



    public Fragment1() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtStudentName = view.findViewById(R.id.txtStudentName);
        TextView txtStudentScore = view.findViewById(R.id.txtScore);

        StudentViewModel model = new ViewModelProvider(getActivity()).get(StudentViewModel.class);

        model.studentLiveData.observe(getActivity(), new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                Log.d("Fragment1", "student name = " + student.name);
                Log.d("Fragment1", "student name = " + student.score);
                txtStudentName.setText(student.name);
                txtStudentScore.setText(student.score + "");
            }
        });

        Button btnIncrement = view.findViewById(R.id.btnIcrement);
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentViewModel model = new ViewModelProvider(getActivity()).get(StudentViewModel.class);
                model.incrementScore();
            }
        });


    }
}