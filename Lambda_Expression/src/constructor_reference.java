class Sample {
    private String s;
    Sample(String s) {
        this.s = s;
        System.out.println("Constructor executed : " + s);
    }
}
interface Interf{
    public Sample get(String s);
}
public class constructor_reference {
    public static void main(String[] args) {
        Interf f = s -> new Sample(s);
        f.get("From Lambda Expression");
        Interf f1= Sample :: new;
        f1.get("From constructor reference");
    }
}

// in method and constructor reference compulsory the argument type must be matched