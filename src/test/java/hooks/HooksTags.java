package hooks;

import io.cucumber.java.Before;

public class HooksTags {

    @Before("@SmokeTest")
    public void soloParaSmoke() {
        System.out.println("🚀 Este hook SOLO se ejecuta en escenarios con @SmokeTest");
    }
}
