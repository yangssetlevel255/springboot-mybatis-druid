import com.dhu.love.grade.mapper.GradeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NormalTest extends BaseTest {

    @Autowired
    GradeMapper gradeMapper;

    @Test
    public void testDemo(){
        gradeMapper.queryAllAddress();
        System.out.println("测试样例就这样写");
    }
}
