package stc.inno.view;

import com.sun.net.httpserver.HttpServer;
import stc.inno.dao.MobileDao;
import stc.inno.pojo.Mobile;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class AllMobileServlet extends HttpServlet {
    @Inject
    private MobileDao mobileDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Mobile> allMobile = mobileDao.getAllMobile();
        req.setAttribute("mobiles", allMobile);

        req.getRequestDispatcher("WEB-INF/jsp/allmobiles.jsp").forward(req, resp);
    }
}
