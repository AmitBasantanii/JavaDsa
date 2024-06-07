import java.util.function.Predicate;

class softwareEngineer {
    String name;
    int age;
    boolean isHavingLeadRole;
    softwareEngineer(String name, int age, boolean isHavingLeadRole) {
        this.name = name;
        this.age=age;
        this.isHavingLeadRole=isHavingLeadRole;
    }
    public String toString() {
        return name;
    }
}

public class allowed_or_not {
    public static void main(String... args) {
        softwareEngineer[] softwareEngineers = { new softwareEngineer("Amit", 22, false),
        new softwareEngineer("Raghav", 22, false),
        new softwareEngineer("Surbhi", 25, true),
        new softwareEngineer("Pradeep", 27, true)};

        Predicate<softwareEngineer> allowed = se -> se.isHavingLeadRole==true && se.age>=18;
        System.out.println("The allowed members in the party are : ");
        for(softwareEngineer se: softwareEngineers) {
            if(allowed.test(se)) {
                System.out.println(se);
            }
        }
    }
}
