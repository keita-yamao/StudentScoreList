package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    //変数宣言
    String menuNumber;
    String name;
    int score;
    int index;

    //オブジェクトのインスタンス化
    Scanner scanner = new Scanner(System.in);
    StudentList studentList = new StudentList();

    //フラグを立てる
    boolean flag = true;

    while (flag) {
      //メニュー表示
      System.out.println("メニュー===================");
      System.out.println("1.学生を追加");
      System.out.println("2.学生を削除");
      System.out.println("3.点数を更新");
      System.out.println("4.平均点を計算");
      System.out.println("5.全学生の情報を表示");
      System.out.println("6.終了");
      System.out.println("==========================");
      System.out.println("メニュー番号を入力してください");
      //メニュー番号の入力処理
      menuNumber = scanner.nextLine();
      try {
        switch (menuNumber) {
          //追加
          case "1":
            System.out.println("学生の名前を入力してください");
            name = scanner.nextLine();
            //登録済みの名前か確認
            index = studentList.searchIndex(name);
            if (index == -1) {
              //登録のない場合の処理
              System.out.println(name + "の点数を入力してください");
              score = scanner.nextInt();
              scanner.nextLine();//バッファのクリア
              studentList.listAdd(name, score);
            } else {
              //登録済みの場合の処理
              System.out.println(name + "はすでに登録されています。");
            }
            break;
          //削除
          case "2":
            System.out.println("学生の名前を入力してください");
            name = scanner.nextLine();
            index = studentList.searchIndex(name);
            //名前が一致しなかった場合の処理
            if (index == -1) {
              System.out.println("一致する名前がありませんでした。");
              break;
            }
            studentList.listDelete(index);
            break;
          //更新
          case "3":
            System.out.println("学生の名前を入力してください");
            name = scanner.nextLine();
            index = studentList.searchIndex(name);
            //名前が一致しなかった場合の処理
            if (index == -1) {
              System.out.println("一致する名前がありませんでした。");
              break;
            }
            System.out.println(name + "点数を入力してください");
            score = scanner.nextInt();
            scanner.nextLine();//バッファのクリア
            studentList.overwrite(index, name, score);
            break;
          //平均点の算出
          case "4":
            //得点リストの作成
            ArrayList<Integer> scoreList;
            scoreList = studentList.scoreList();
            //合計点の算出
            int totalScore = 0;
            for (int s : scoreList) {
              totalScore = totalScore + s;
            }
            //平均点の算出
            double average = (double) totalScore / scoreList.size();
            //平均点の表示
            System.out.println("平均点:" + average + "点");
            break;
          //一覧表示
          case "5":
            System.out.println("学生一覧:");
            studentList.display();
            break;
          //終了
          case "6":
            //scannerを閉じて処理を抜ける
            scanner.close();
            flag = false;
            System.out.println("===========終了============");
            break;
          //条件外の処理
          default:
            System.out.println("1~6のメニュー番号を半角数字で入力してください。");
        }
      } catch (InputMismatchException e) {
        e.printStackTrace();
        System.out.println("入力された値の型が一致しません");
        scanner.nextLine();//バッファのクリア
      }
    }
    scanner.close();
  }
}
