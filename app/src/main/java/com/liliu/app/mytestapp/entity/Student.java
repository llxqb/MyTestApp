package com.liliu.app.mytestapp.entity;

import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by li.liu on 2018/12/7.
 */

public class Student implements Comparable<Student> {

    /**
     * 对象的排序方式[升、降],true为升序反之降序
     */
    private static boolean sortASC = true;
    /**
     * 对象的排序属性,根据对象自己设置的id,名字、出生日期
     */
    private static boolean sortBybId = false;
    private static boolean sortBybName = false;
    private static boolean sortBybDate = true;

    private String name;
    private String id;
    private int age;
    private Date birthDay;

    public Student() {

    }

    public Student(String name, String id, int age, Date birthDay) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.birthDay = birthDay;
    }

    @Override
    public int compareTo(@NonNull Student o) {
        if (sortBybId) {
            int id1 = Integer.valueOf(this.id);
            int id2 = Integer.valueOf(o.id);
            if (sortASC) {
                return id1 > id2 ? 1 : id1 == id2 ? 0 : -1;
            } else {
                return id1 > id2 ? -1 : id1 == id2 ? 0 : 1;
            }
        } else if (sortBybName) {
            if (sortASC) {
                return this.name.compareTo(o.name);
            } else {
                int result = this.name.compareTo(o.name);
                return result > 0 ? -1 : result == 0 ? 0 : 1;
            }
        } else if (sortBybDate) {
            if (sortASC) {
                return this.birthDay.compareTo(o.birthDay);
            } else {
                int result = this.birthDay.compareTo(o.birthDay);
                return result > 0 ? -1 : result == 0 ? 0 : 1;
            }
        }
        //返回 1是默认值
        return 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age='" + age + '\'' +
                ", birthDay=" + birthDay +
                '}' + "\n";
    }
}
