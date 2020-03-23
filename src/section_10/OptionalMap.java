package section_10;

import java.util.Optional;

public class OptionalMap {
    public static void main(String[] args) {
        Insurance insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        System.out.println(name);
        System.out.println("-------------------------------------------");
    }
}
