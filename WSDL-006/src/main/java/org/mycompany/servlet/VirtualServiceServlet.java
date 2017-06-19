package org.mycompany.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ostiasolutions.sv.handler.wsdl.VirtualServiceHandler;

public class VirtualServiceServlet extends HttpServlet
{
    private VirtualServiceHandler virtualServiceHandler;
    
    private static final long serialVersionUID = -6324554589838201574L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        try
        {
            virtualServiceHandler.handleGet(req, resp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            virtualServiceHandler.handlePost(req, resp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        
        virtualServiceHandler = new VirtualServiceHandler();

        try
        {
            virtualServiceHandler.init(config);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new ServletException(e.getMessage());
        }
    }
    
    @Override
    public void destroy()
    {
        if (virtualServiceHandler != null)
            virtualServiceHandler.destroy();

        super.destroy();
    }
}