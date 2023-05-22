package Lab;

import Lab.Beans.ScopedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * The @Configuration class is where the beans of your Spring project will be defined.
 */
@Configuration
public class Application {


    /**
     * The scopes of a bean define how the bean behaves when it is drawn from the Application context - Spring
     * could be instructed to either provide a newly-instantiated object or reuse an existing object. They are listed
     * here:
     *
     * singleton - the default scope, any time a specific bean is requested, the existing object is reused.
     * prototype - any time a bean is requested, a new object is instantiated.
     * request - only used in web applications. a new object is instantiated once per web request.
     * session - only used in web applications. a new object is instantiated once per web session.
     * application - only used in web applications. a new object is instantiated once per web servlet.
     * websocket - only used in web applications. a new object is instantiated once per websocket.
     *
     * the singleton annotation here is redundant as it is the default, but it shows that the scope may be
     * manually be set to one of the others.
     * @return
     */
    @Bean
    @Scope("singleton")
    public ScopedBean sampleBean(){
        return new ScopedBean();
    }

    /**
     * TODO: correct the following code so that a new ScopedBean is instantiated every time the labBean is requested.
     */
    @Bean
    public ScopedBean labBean(){
        return new ScopedBean();
    }

    /**
     * main method for manual testing of your code
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        ScopedBean b1 = (ScopedBean) applicationContext.getBean("sampleBean");
        ScopedBean b2 = (ScopedBean) applicationContext.getBean("sampleBean");

        System.out.println("sampleBean is singleton-scoped, so any sampleBean retrieved from the app context ");
        System.out.println("should be the same object. Let's test it with ==, are b1 and b2 the same object?");
//      remember that == performs a shallow comparison, and can only check if two objects are literally the same
//      object in memory. This came in useful here!
        if(b1 == b2){
            System.out.println("b1 and b2 are the same object.");
        }else{
            System.out.println("b1 and b2 are not the same object.");
        }
        ScopedBean b3 = (ScopedBean) applicationContext.getBean("labBean");
        ScopedBean b4 = (ScopedBean) applicationContext.getBean("labBean");

        System.out.println("You'll need to scope labBean such that b3 and b4 are different objects.");
        System.out.println("Let's test it with ==, are b1 and b2 the same object?");
        if(b3 == b4){
            System.out.println("failure: b3 and b4 are the same object.");
        }else{
            System.out.println("success: b3 and b4 are not the same object.");
        }
    }

}
