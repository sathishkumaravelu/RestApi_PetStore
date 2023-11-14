package utils;

import org.aeonbits.owner.Config;

@Config.Sources({"file:./src/main/resources/prop/environment.property"})
public interface AppProperties extends Config {
    String endpoint();

    String version();

    String storeModule();

    String userModule();

    String petModule();
}
