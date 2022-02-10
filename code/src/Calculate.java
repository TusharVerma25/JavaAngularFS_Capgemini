class Calculator{

    private int op1;
    private int op2;

    public Calculator(int op1, int op2) {
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

    public double divide(){
        return this.getOperand1()*1.0/this.getOperand2();
    }

    public String toString() {
        return "Calculator";
    }
}

public class Calculate {

    public static void main(String[] args) {

        Calculator calculator= new Calculator(10,4);
        System.out.println(calculator.add());
        System.out.println(calculator.subtract());
        System.out.println(calculator.multiply());
        System.out.println(calculator.divide());
        System.out.println(calculator);
    }
}
