class Calculate{

    private int op1;
    private int op2;

    public Calculate(int op1, int op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public int getOperand1() {
        return op1;
    }

    public void setOperand1(int op1) {
        this.op1 = op1;
    }

    public int getOperand2() {
        return op2;
    }

    public void setOperand2(int op2) {
        this.op2 = op2;
    }

    public int add(){
        return this.getOperand1()+this.getOperand2();
    }

    public int subtract(){
        return this.getOperand1()-this.getOperand2();
    }

    public int multiply(){
        return this.getOperand1()*this.getOperand2();
    }

    public int divide(){
        return this.getOperand1()/this.getOperand2();
    }
}

public class Calculator {

    public static void main(String[] args) {

        Calculate calculate= new Calculate(10,2);
        System.out.println(calculate.add());
        System.out.println(calculate.subtract());
        System.out.println(calculate.multiply());
        System.out.println(calculate.divide());
    }
}
