package BuilderPattern;

import java.time.LocalDate;
import java.util.UUID;

public class BuilderPattern3 {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        SomeComplexObject obj = new SomeComplexObject.Builder(1,uuid)
                .name("Steven")
                .birthDay(LocalDate.now().minusYears(31))
                .age(31)
                .build();
        System.out.println(obj);
    }
}

class SomeComplexObject {
    private final Integer id;
    private final UUID uuid;
    private final String name;
    private final Integer age;
    private final LocalDate birthDay;
    private final String address;
    private final String number;

    public static class Builder {
        private final Integer id;
        private final UUID uuid;

        private String name = "";
        private Integer age = 0;
        private LocalDate birthDay = LocalDate.MAX;
        private String address = "";
        private String number = "";

        public Builder(Integer id, UUID uuid) {
            this.id = id;
            this.uuid = uuid;
        }

        public Builder name(String val){
            name = val;
            return this;
        }

        public Builder age(Integer val){
            age = val;
            return this;
        }

        public Builder birthDay(LocalDate val){
            birthDay = val;
            return this;
        }

        public Builder address(String val){
            address = val;
            return this;
        }

        public Builder number(String val){
            number = val;
            return this;
        }

        public SomeComplexObject build(){
            return new SomeComplexObject(this);
        }
    }

    private SomeComplexObject(Builder builder) {
        id = builder.id;
        uuid = builder.uuid;
        name = builder.name;
        age = builder.age;
        birthDay = builder.birthDay;
        address = builder.address;
        number = builder.number;
    }

    @Override
    public String toString() {
        return "SomeComplexObject{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}