
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps", "hooks"},
        tags = "@test",
        strict = false,
        dryRun = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE
)
public class RunnerTest {
}