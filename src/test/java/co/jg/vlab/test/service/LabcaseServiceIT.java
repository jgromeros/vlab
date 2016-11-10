package co.jg.vlab.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.jg.vlab.model.entity.Labcase;
import co.jg.vlab.model.entity.Place;
import co.jg.vlab.service.PlaceService;
import co.jg.vlab.service.rest.LabcaseServiceREST;

@RunWith(Arquillian.class)
public class LabcaseServiceIT {

    private static final String CODE_FOR_TEST = "99999";
    @Inject
    private LabcaseServiceREST labcaseService;

    @Inject
    private PlaceService placeService;

    @Deployment
    public static WebArchive createTestArchive() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "vlab.war");
        JavaArchive jar = ShrinkWrap.create(ZipImporter.class, "vlab-0.0.1-SNAPSHOT.jar")
                .importFrom(new File("target/vlab-0.0.1-SNAPSHOT.jar")).as(JavaArchive.class);
        war.addAsLibrary(jar);
        File log4j = new File("/home/jgromero/.m2/repository/log4j/log4j/1.2.16/log4j-1.2.16.jar");
        JavaArchive log4jjar = ShrinkWrap.create(ZipImporter.class, "log4j.jar").importFrom(log4j)
                .as(JavaArchive.class);
        war.addAsLibrary(log4jjar);
        File hibcore = new File(
                "/home/jgromero/.m2/repository/org/hibernate/hibernate-core/4.3.7.Final/hibernate-core-4.3.7.Final.jar");
        JavaArchive hibcorejar = ShrinkWrap.create(ZipImporter.class, "hibernate-core-4.3.7.Final.jar")
                .importFrom(hibcore).as(JavaArchive.class);
        war.addAsLibrary(hibcorejar);
        File hibem = new File(
                "/home/jgromero/.m2/repository/org/hibernate/hibernate-entitymanager/4.3.7.Final/hibernate-entitymanager-4.3.7.Final.jar");
        JavaArchive hibemjar = ShrinkWrap.create(ZipImporter.class, "hibernate-entitymanager-4.3.7.Final.jar")
                .importFrom(hibem).as(JavaArchive.class);
        war.addAsLibrary(hibemjar);
        File postgresql = new File(
                "/home/jgromero/.m2/repository/org/postgresql/postgresql/9.3-1100-jdbc41/postgresql-9.3-1100-jdbc41.jar");
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

    @Test
    public void testPersistLabcase() {
        Labcase labcase = new Labcase();
        labcase.setReceptionDate(new Date());
        labcase.setCode(CODE_FOR_TEST);
        Response resp = placeService.getPlace(202);
        labcase.setPlace((Place) resp.getEntity());
        labcase.setState("R");
        Response response = labcaseService.persistLabcase(labcase);
        assertNotNull(response.getEntity());
    }

    public void testRemoveLabcase(@PathParam("id") Long id) {
    }

    public void testUpdateLabcase(Labcase labcase) {
    }

    @After
    public void afterTest() {
        Response response = labcaseService.getLabcaseByCode(CODE_FOR_TEST);
        if (response != null) {
            Labcase labcase = (Labcase) response.getEntity();
            labcaseService.removeLabcase(labcase.getId());
        }
    }

}
