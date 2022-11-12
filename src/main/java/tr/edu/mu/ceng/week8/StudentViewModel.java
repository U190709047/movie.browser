package tr.edu.mu.ceng.week8;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentViewModel extends ViewModel {

    public final MutableLiveData<Student> studentLiveData = new MutableLiveData<>() ;

    public StudentViewModel(){

    }


    public void fetchStudent(int id){
        if (id ==1){
            studentLiveData.setValue(new Student("Ali", 72));
        }else{
            studentLiveData.setValue(new Student("Ozgur", 79));
        }
    }

    public void incrementScore(){
        Student st = studentLiveData.getValue();
        studentLiveData.setValue(new Student(st.name, st.score+1));
    }

    public String getLetterGrade() {
        int score = studentLiveData.getValue().score;
        if (score >= 90)
            return "A";
        else if( score >= 85){
            return "BA";
        }else if( score >= 80){
            return "BB";
        }else if( score >= 75){
            return "BB";
        }else if( score >= 70){
            return "CB";
        }else
            return  "CC";
    }
}
