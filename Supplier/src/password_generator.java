import java.util.function.Supplier;

public class password_generator {
    public static void main(String... args) {
        Supplier<String> supplier = () -> {
            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#$@";
            Supplier<Integer> integerSupplier = () -> (int)(Math.random()*10);
            Supplier<Character> characterSupplier = () -> symbols.charAt((int)(Math.random()*29));
            String password = "";
            for(int i =1 ; i<=8; i++) {
                if(i%2 == 0) {
                    password = password + integerSupplier.get();
                }
                else {
                    password = password + characterSupplier.get();
                }
            }
            return password;
        };
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
