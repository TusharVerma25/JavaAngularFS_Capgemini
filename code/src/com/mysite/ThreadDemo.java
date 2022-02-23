package com.mysite;

import java.io.*;
import java.util.Scanner;

class Input {

    public synchronized void writeIntoFile() {
        try {

            Scanner sc = new Scanner(System.in);
            FileOutputStream opt = new FileOutputStream("file1.txt", true);
            OutputStreamWriter op = new OutputStreamWriter(opt);

            System.out.println("*** Enter the Data to insert into the File *** ");
            op.write("\n" + sc.nextLine());
            op.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Output  {

    public synchronized void readFile() {

        char [] streams= new char[100];

        try {

            FileInputStream f1 = new FileInputStream("file1.txt");
            InputStreamReader isr=new InputStreamReader(f1);

            isr.read(streams);
            System.out.println("The characters from the files are");
            System.out.println(streams);
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

public class ThreadDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread obj1=new Thread(new Runnable() {

            @Override
            public void run() {
                new Input().writeIntoFile();
            }
        });

        Thread obj2=new Thread(new Runnable() {

            @Override
            public void run() {
                    new Output().readFile();
            }
        });
        obj1.start();
        obj2.start();

    }
}
