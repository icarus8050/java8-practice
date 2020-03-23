package section_10;

import java.util.Optional;

public class OptionalMap {
    public static void main(String[] args) {
        Insurance insurance = null;
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);

        System.out.println(name);
        System.out.println("-------------------------------------------");
        System.out.println("FlatMap Optional Exam");
        System.out.println(getCarInsuranceName(Optional.empty()));
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }
}
