package org.example;

import java.util.ArrayList;

public class StudentList {

  //リストの作成
  ArrayList<Student> studentList = new ArrayList<>();

  //インデックス検索処理
  public int searchIndex(String name) {
    //カウンタ変数の宣言
    int i = 0;
    //名前の検索
    for (Student student : studentList) {
      //名前が一致したらインデックスを返す
      if (student.name.equals(name)) {
        return i;
      }
      i = i + 1;
    }
    //名前と一致しなかった場合
    return -1;
  }

  //リストへ追加処理
  public void listAdd(String name, int score) {
    Student student = new Student(name, score);
    studentList.add(student);
  }

  //リストの削除処理
  public void listDelete(int index) {
    studentList.remove(index);
  }

  //リストの上書き処理
  public void overwrite(int index, String name, int score) {
    Student student = new Student(name, score);
    studentList.set(index, student);
  }

  //リストの表示処理
  public void display() {
    for (Student student : studentList) {
      System.out.println(student.name + ":" + student.score + "点");
    }
  }

  //点数のリストを返す
  public ArrayList<Integer> scoreList() {
    ArrayList<Integer> returnList = new ArrayList<>();
    for (Student student : studentList) {
      returnList.add(student.score);
    }
    return returnList;
  }
}
