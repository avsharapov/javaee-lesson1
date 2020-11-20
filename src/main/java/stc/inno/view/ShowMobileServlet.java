package stc.inno.view;

import stc.inno.dao.MobileDao;
import stc.inno.pojo.Mobile;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/showmobile")
public class ShowMobileServlet extends HttpServlet {
    @Inject
    private MobileDao mobileDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Long id = (Long) req.getAttribute("id");
        final Mobile mobileById = mobileDao.getMobileById(id);
        req.setAttribute("mobile", mobileById);
        req.getRequestDispatcher("WEB-INF/jsp/showmobile.jsp").forward(req,resp);
    }
}
