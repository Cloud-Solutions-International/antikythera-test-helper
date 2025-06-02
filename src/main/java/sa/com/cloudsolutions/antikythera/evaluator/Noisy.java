package sa.com.cloudsolutions.antikythera.evaluator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Noisy {
    public void noisyMethod() {
        log.info("This is a noisy method!");
        System.out.println("This is a noisy method!");
    }

    public void anotherNoisyMethod() {
        log.warn("This is another noisy method!");
        System.out.println("This is another noisy method!");
    }

    public static void main(String[] args) {
        Noisy noisy = new Noisy();
        noisy.noisyMethod();
        noisy.anotherNoisyMethod();
    }
}
