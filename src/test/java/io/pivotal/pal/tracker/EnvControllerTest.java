package io.pivotal.pal.tracker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;



public class EnvControllerTest {
    @Test
    public void getEnv() throws Exception {
        EnvController controller = new EnvController(
            "8675",
            "12G",
            "34",
            "123.sesame.street"
        );

        Map<String, String> env = controller.getEnv();

        Assertions.assertThat(env.get("PORT")).isEqualTo("8675");
        Assertions.assertThat(env.get("MEMORY_LIMIT")).isEqualTo("12G");
        Assertions.assertThat(env.get("CF_INSTANCE_INDEX")).isEqualTo("34");
        Assertions.assertThat(env.get("CF_INSTANCE_ADDR")).isEqualTo("123.sesame.street");
    }

}
