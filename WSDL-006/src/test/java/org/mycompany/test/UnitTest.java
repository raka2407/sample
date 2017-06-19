package org.mycompany.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mortbay.jetty.testing.HttpTester;
import org.mortbay.jetty.testing.ServletTester;
import org.mortbay.jetty.servlet.ServletHolder;

public class UnitTest
{
    @Test
    public void doTest() throws Exception
    {
        String ep = "/";
        
        ServletTester servletTester = new ServletTester();
        ServletHolder sh = servletTester.addServlet(org.mycompany.servlet.VirtualServiceServlet.class, ep);
        sh.setInitParameter("webapp-name", "WSDL-006");
        sh.setInitParameter("wsdlUrl", "file:///C:\\Users\\AB62031\\Ostia Solutions\\apache-tomcat-8.0.36\\webapps\\dnb\\FinancialService.wsdl");
        sh.setInitParameter("virtualServiceImpl", "org.mycompany.generated.sv.impl.VirtualServiceImpl");
        servletTester.start();

        HttpTester request = new HttpTester();
        request.setMethod("GET");
        request.setHeader("Host", "http://localhost:8080/");
        request.setURI("/statsService");

        HttpTester response = new HttpTester();
        response.parse(servletTester.getResponses(request.generate()));

        String resp = response.getContent();

        assertTrue(resp != null);
        assertTrue(resp.length() > 0);
        assertTrue(!resp.contains("HTTP ERROR 500"));
        assertTrue(resp.contains("serviceExecutions"));
        servletTester.stop();

        System.out.println("DONE");
        System.out.println("DONE");
    }

}
