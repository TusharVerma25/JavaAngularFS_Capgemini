package com.mysite;

import java.util.regex.Pattern;

class TransactionParty {
    String seller;
    String buyer;

    public TransactionParty(String seller, String buyer) {
        this.seller = seller;
        this.buyer = buyer;
    }
}

class Receipt {
    TransactionParty transactionParty;
    String productsQR;

    public Receipt(TransactionParty transactionParty, String productsQR) {
        this.transactionParty = transactionParty;
        this.productsQR = productsQR;
    }
}

class GenerateReceipt {
    public int verifyParty(Receipt  r) {
        int count=0;
        if(Pattern.matches("^[a-zA-Z]['a-zA-Z- ]+[A-Za-z]$",r.transactionParty.seller)){
            count+=1;
        }
        if(Pattern.matches("^[a-zA-Z][a-zA-Z- ]+[A-Za-z]$",r.transactionParty.buyer)){
            count+=1;
        }
        return count;
    }

    public String calcGST(Receipt r){
        int GST=0;
        String value=r.productsQR;
        int [] qua=new int[4];
        String[] splitstring=value.split("@");
        for(String i:splitstring){
            String[] news=new String(i).split(",");
            int total=1;
            for(String k:news){
                total=total*Integer.valueOf(k);
            }
            GST+=total;
        }

        return String.valueOf((GST*12)/100);
    }
}

public class ValidatingUsers {

    public static void main(String[] args) {
        TransactionParty tp=new TransactionParty("gaj'jhafj","jha h-dsk");
        Receipt r=new Receipt(tp,"250,10@100,3@50,7");
        GenerateReceipt receipt=new GenerateReceipt();
        System.out.println(receipt.verifyParty(r));
        System.out.println(receipt.calcGST(r));
    }
}
