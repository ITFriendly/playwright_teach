import core.BasePlayWrightTest;
import lombok.extern.slf4j.Slf4j;
import org.itfriendly.Lombokeeting;
import org.itfriendly.Main;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class LogAddTest extends BasePlayWrightTest {
    @Test
    public void addLogs() {
        log.info("Just info message");
        log.error("Error + this is errroooooor");
        log.debug("Debug of  " + Main.class.getName().toLowerCase());
        log.trace("trace");
        Lombokeeting show = new Lombokeeting();
        log.info(show.getStr());
        log.info("a is - " + show.getA());
    }

    }
