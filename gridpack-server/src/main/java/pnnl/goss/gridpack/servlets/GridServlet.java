package pnnl.goss.gridpack.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.Property;

import pnnl.goss.powergrid.datamodel.Powergrid;
import pnnl.goss.powergrid.server.PowergridService;

public class GridServlet extends HttpServlet {

    private PowergridService powergridService;

    public void setPowergridService(PowergridService service){
        powergridService = service;
    }

    public PowergridService getPowergridService(){
        return powergridService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.write(getHeader());
        out.write(getUploadForm());

        out.write("<ul>");
        for(Powergrid grids:powergridService.getPowergrids()){
            out.write("<li>Gridpack: "+ getGridpackLink(grids.getName(), grids.getMrid(), false) + "<br/>"
                    + "Gridpack + Schema: " + getGridpackLink(grids.getName(), grids.getMrid(), true) + "<br/>"
                    + "Powergrid: "+ getPowergridLink(grids.getName(), grids.getMrid())+"</li>\n");
        }
        out.write("</ul>");
        out.write(getFooter());
    }

    String getPowergridLink(String name, String mrid){
        if (name == null || name.isEmpty()){
            name = mrid;
        }

        return String.format("<a target=\"powergrid\" href=\"/cxf/powergrid/%s\">%s</a>\n", mrid, name);
    }

    String getGridpackLink(String name, String mrid, boolean withSchema){
        String ext = "";

        if (name == null || name.isEmpty()){
            name = mrid;
        }

        if (withSchema){
            ext = "full";
        }

        return String.format("<a target=\"gridpack\" href=\"/cxf/gridpack/%s/%s\">%s</a>\n", mrid, ext, name);
    }

    String getUploadForm(){
        return "<h3>Upload Psse 23 file</h3>\n" +
                "<form target=\"uploading\" action=\"/cxf/powergrid/create/\" method=\"post\" enctype=\'multipart/form-data\'>\n" +
                "Name: <input name=\"powergridName\" /><br/>\n" +
                "<input type=\"file\" name=\"file\" />\n" +
                "<input type=\"submit\" value=\"Upload\" />" +
                "</form>";
    }


    String getHeader(){
        return "<html><head><title>Powergrids</title></head><body>\n";
    }

    String getFooter(){
        return "</body></html>\n";
    }
}
