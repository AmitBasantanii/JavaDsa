public class run_method {
    // with lambda expression
//    public static void main(String[] args) {
//        Runnable r = () -> {
//            for(int i=0; i<10; i++) {
//                System.out.println("Child method");
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
//        for(int i=0; i<=10; i++) {
//            System.out.println("Main method");
//        }
//    }

    // with method reference
    public static void m1() {
        for(int i=0; i<=10; i++) {
            System.out.println("Child Thread");
        }
    }
    public static void main(String[] args){
        Runnable r = run_method::m1; // method reference
        Thread t= new Thread(r);
        t.start();
        for(int i=0; i<=10; i++) {
            System.out.println("Main Thread");
        }
    }
}
