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
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/renew")
public class RenewServlet extends HttpServlet {
    @Inject
    private MobileDao mobileDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            mobileDao.renewDatabase();
        } catch (SQLException throwables) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
