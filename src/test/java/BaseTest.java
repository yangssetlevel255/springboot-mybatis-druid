import com.dhu.love.yangzyProviderRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = yangzyProviderRunner.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@DirtiesContext
public class BaseTest {

}
