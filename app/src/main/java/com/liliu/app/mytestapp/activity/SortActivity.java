package com.liliu.app.mytestapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.liliu.app.mytestapp.BaseActivity;
import com.liliu.app.mytestapp.R;
import com.liliu.app.mytestapp.entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 排序
 */
public class SortActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        initView();
        initData();
    }

    private void initView() {
        TextView mSort = findViewById(R.id.sort);
//        mSort.setOnClickListener(v -> {
//
//        });
    }

    private void initData() {
        Student[] students =  generateData().toArray(new Student[]{});
        Arrays.sort(students);
        List<Student> newList = Arrays.asList(students);
        for (Student student : newList) {
            Log.e("MainActivity", student.toString());
        }

    }

    private List<Student> generateData() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Cy", "01", 22, getDate("1992-10-20")));
        students.add(new Student("Yl", "03", 23, getDate("1993-10-16")));
        students.add(new Student("Hk", "02", 21, getDate("1993-06-05")));
        students.add(new Student("Ly", "04", 24, getDate("1990-07-13")));
        students.add(new Student("Xlp", "06", 19, getDate("1994-01-11")));
        students.add(new Student("Spl", "05", 22, getDate("1992-05-14")));
        return students;
    }

    private Date getDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
