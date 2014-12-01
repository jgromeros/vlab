package co.jg.vlab.test.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.jg.vlab.model.entity.Labcase;
import co.jg.vlab.service.LabcaseService;

@RunWith(Arquillian.class)
public class LabcaseServiceIT {

    @Inject
    private LabcaseService labcaseService;

    @Deployment
    public static WebArchive createTestArchive() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "vlab.war");
        JavaArchive jar = ShrinkWrap.create(ZipImporter.class, "vlab-0.0.1-SNAPSHOT.jar")
                .importFrom(new File("target/vlab-0.0.1-SNAPSHOT.jar")).as(JavaArchive.class);
        war.addAsLibrary(jar);
        File log4j = new File("C:/EntornoSimon/repository/log4j/log4j/1.2.16/log4j-1.2.16.jar");
        JavaArchive log4jjar = ShrinkWrap.create(ZipImporter.class, "log4j.jar").importFrom(log4j)
                .as(JavaArchive.class);
        war.addAsLibrary(log4jjar);
        File hibcore = new File(
                "C:/EntornoSimon/repository/org/hibernate/hibernate-core/4.3.7.Final/hibernate-core-4.3.7.Final.jar");
        JavaArchive hibcorejar = ShrinkWrap.create(ZipImporter.class, "hibernate-core-4.3.7.Final.jar")
                .importFrom(hibcore).as(JavaArchive.class);
        war.addAsLibrary(hibcorejar);
        File hibem = new File(
                "C:/EntornoSimon/repository/org/hibernate/hibernate-entitymanager/4.3.7.Final/hibernate-entitymanager-4.3.7.Final.jar");
        JavaArchive hibemjar = ShrinkWrap.create(ZipImporter.class, "hibernate-entitymanager-4.3.7.Final.jar")
                .importFrom(hibem).as(JavaArchive.class);
        war.addAsLibrary(hibemjar);
        File postgresql = new File(
                "C:/EntornoSimon/repository/org/postgresql/postgresql/9.3-1100-jdbc41/postgresql-9.3-1100-jdbc41.jar");
        JavaArchive postgresqljar = ShrinkWrap.create(ZipImporter.class, "postgresql.jar")
                .importFrom(postgresql).as(JavaArchive.class);
        war.addAsLibrary(postgresqljar);
        war.addAsWebInfResource("web.xml");
        war.addAsWebInfResource("beans.xml");
        System.out.println(war.toString(true));
        return war;
    }

    @Test
    public void testGetLabcases() {
        Response response = labcaseService.getLabcases();
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testGetLabcase() {
        Response response = labcaseService.getLabcase(1932);
        assertEquals(200, response.getStatus());
        Labcase labcase = (Labcase) response.getEntity();
        assertEquals(new Integer(1932), labcase.getId());
    }

}
