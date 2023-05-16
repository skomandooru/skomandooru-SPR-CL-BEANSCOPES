import Lab.Application;
import Lab.Beans.ScopedBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopedBeanTest {
    /**
     * will pass when requesting the "labBean" multiple times returns differently objects, due to the proper use
     * of one of the bean scopes.
     */
    @Test
    public void scopedBeanTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        ScopedBean b1 = (ScopedBean) applicationContext.getBean("labBean");
        ScopedBean b2 = (ScopedBean) applicationContext.getBean("labBean");
        Assertions.assertTrue(b1!=b2);
    }
}
