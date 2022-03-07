package com.mysite;


import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

class Winner {
    private String name;
    private int lengthKm;
  //  private Duration winningTime;

    public Winner(String name, int lengthKm) {
        this.name = name;
        this.lengthKm = lengthKm;
      //  this.winningTime = winningTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengthKm() {
        return lengthKm;
    }

    public void setLengthKm(int lengthKm) {
        this.lengthKm = lengthKm;
    }

//    public Duration getWinningTime() {
//        return winningTime;
//    }
//
//    public void setWinningTime(Duration winningTime) {
//        this.winningTime = winningTime;
//    }
}

class WinnerImplementation{
    public List<String> firstTwoWinner(List<Winner> winners){
         return winners.stream().filter( u -> u.getLengthKm()>3500).map(w->w.getName()).collect(Collectors.toList());
    }

    public int totalistance(List<Winner> winners) {
        int sum=0;
        sum = winners.stream().collect(Collectors.summingInt(w -> w.getLengthKm()));
        return sum;
    }

    public List<String> winnerofTours(List<Winner> winners) {
        return winners.stream().filter(w->w.getLengthKm()>3000).map(w->w.getName()).collect(Collectors.toList());
    }
}

class Staff {
    String name;
    String ssn;
    String dept;
    int salary;

    public Staff(String name, String ssn, String dept, int salary) {
        this.name = name;
        this.ssn = ssn;
        this.dept = dept;
        this.salary = salary;
    }
}

class StaffImplementation {
    public Staff getStaffInfo(String str) {
        int n=str.lastIndexOf('@');
        String name=str.substring(0,n);
        int n1=str.lastIndexOf('-');
        String ssn=str.substring(n+1,n1);
        int n2=str.lastIndexOf('#');
        String dept=str.substring(n1+1,n2);
        int sal=Integer.parseInt(str.substring(n2+1));
        Staff staff=new Staff(name,ssn,dept,sal);
        return staff;
    }

    public String getStaffLevel(Staff s){
        String str=s.ssn.substring(s.ssn.length()-3);
        int n=Integer.parseInt(str);

        if(n>=1 && n<=60)
            return "L1";
        else if(n>61 && n<=120)
            return "L2";
        else if(n>=121 && n<=180)
            return "L3";
        else
            return "L4";
    }
}

public class HiringOn {

    public static void main(String[] args) {
        StaffImplementation st = new StaffImplementation();
        Staff s = st.getStaffInfo("Rahul@1PE16CS046-SE#8");
        System.out.println(st.getStaffLevel(s));

        List<Winner> w=new ArrayList<>();
        w.add(new Winner("2g",4000));
        w.add(new Winner("1g",3000));
        w.add(new Winner("ghghg",5000));
        w.add(new Winner("eerer",6500));
        w.add(new Winner("3g",3000));
        w.add(new Winner("4g",3500));

        WinnerImplementation wl= new WinnerImplementation();
        System.out.println(wl.firstTwoWinner(w));

    }
}

