package test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import service.UserServices;

import javax.ejb.EJB;

/**
 * Created by papo on 5/31/14.
 */
@RunWith(Arquillian.class)
public class DemoArquillianTest {

    @EJB
    UserServices dummyService;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UserServices.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testSaysHello() {
        Assert.assertEquals("hello", dummyService.sayHello());
    }
}
