package foo.bar;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import static org.junit.Assert.assertNotNull;


@RunWith(Arquillian.class)
public class ContextInjectionTest {


    @Deployment
    public static WebArchive deploy() throws Exception {
        return ShrinkWrap.create(WebArchive.class, "injection-test.war");
    }

    @Context
    private ServletContext sc;

    @Test
    public void test() {
        assertNotNull(sc);

        // TODO: This must not throw a NPE, but something meaningful
        sc.getClassLoader();
    }
}
