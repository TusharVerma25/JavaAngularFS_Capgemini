package com.mysite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

class Header {
    String from;
    String to;

    public Header(String from, String to) {
        this.from = from;
        this.to = to;
    }
}

class Email {
    Header header;
    String body;
    String greetings;

    public Email(Header header, String body, String greetings) {
        this.header = header;
        this.body = body;
        this.greetings = greetings;
    }
}

class EmailOpeations {

    public int emailVerify(Email e) {
        int count=0;
        String emailRegex = "^[a-zA-Z_]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        if(Pattern.matches(emailRegex,e.header.from))
            count++;
        if(Pattern.matches(emailRegex,e.header.to))
            count++;
        return count;
    }

    public String bodyEncryption(Email e) {
        String text=e.body;
        String result="";
        for (int i=0; i<text.length(); i++)
        {
            if(text.charAt(i) == ' ')
                result=result+" ";
            else if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) + 3 - 65) % 26 + 65);
                result=result+ch;
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) + 3 - 97) % 26 + 97);
                result=result+ch;
            }
        }
        return result;
    }

    public String greetingMessage(Email e) {
        if(e.greetings.equals("Regards"))
            return "Regards " + e.header.from.substring(0,e.header.from.lastIndexOf("@"));
        else
            return e.greetings;
    }
}

public class EmailOpeation {

    public static void main(String[] args) {

        Header h= new Header("Amit@doselect.com","xyz@gmail.com");
        Email e=new Email(h,"Hi There Hows you","Regards");

        EmailOpeations eop=new EmailOpeations();
        System.out.println(eop.emailVerify(e));
        System.out.println(eop.bodyEncryption(e));
        System.out.println(eop.greetingMessage(e));
    }
}
