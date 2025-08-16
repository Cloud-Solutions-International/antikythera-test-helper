package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

public class Queries {
    @Autowired
    FakeRepository fakeRepository;

    void getById(int id) {
        FakeEntity entity = fakeRepository.findById(id).orElse(null);
        if (entity != null) {
            System.out.println("Entity found: " + entity.getName());
        } else {
            System.out.println("Entity not found");
        }
    }
}
