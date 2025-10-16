package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings({"java:S106","unused"})
public class ConvertValue {
    public static class Source {
        private String name;
        @JsonIgnore
        private int age;

        public Source() {}

        public Source(String name, int i) {
            this.name = name;
            this.age = i;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static class Target {
        private String name;
        private int yearsOld;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getYearsOld() {
            return yearsOld;
        }
        public void setYearsOld(int yearsOld) {
            this.yearsOld = yearsOld;
        }
    }

    public static void main(String[] args) {
        System.out.println("convert");
        convert();
        System.out.println("map");
        map();
        System.out.println("mapPerson");
        mapPerson();
    }

    private static void map() {
        // Create source object
        Source source = new Source();
        source.name = "Alice";
        source.age = 30;

        ModelMapper mapper = new ModelMapper();
        Target target = mapper.map(source, Target.class);
        System.out.println("Source: Name: " + source.name + "; Age: " + source.age);
        System.out.println("Target: Name: " + target.name + "; Years Old: " + target.yearsOld);
    }

    private static void mapPerson() {
        Source p = new Source("Alice",30);
        ModelMapper mapper = new ModelMapper();
        Target target = mapper.map(p, Target.class);
        System.out.println("Source: Name: " + p.name + "; Age: " + p.age);
        System.out.println("Target: Name: " + target.name + "; Years Old: " + target.yearsOld);
    }
    private static void convert() {
        ObjectMapper objectMapper = new ObjectMapper();

        Source source = new Source();
        source.name = "Alice";
        source.age = 30;

        // Convert SourceObject to TargetObject
        Target target = objectMapper.convertValue(source, Target.class);

        System.out.println("Source: Name: " + source.name + "; Age: " + source.age);
        System.out.println("Target: Name: " + target.name + "; Years Old: " + target.yearsOld);
    }
}
