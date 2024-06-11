import java.util.Date;
import java.util.function.Supplier;

public class system_date {
    public static void main(String[] args) {
        Supplier<Date> dateSupplier = () -> new Date();
        System.out.println(dateSupplier.get());
        System.out.println(dateSupplier.get());
        System.out.println(dateSupplier.get());
    }
}
