package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Restaurante;
import models.ItemRestaurante;
import models.Productos;
import service.ProductoService;
import service.ProductoServiceJdbcImplement;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/agregar-restaurante")
public class AgregarRestauranteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idProducto = Long.parseLong(req.getParameter("idProducto"));
        //ProductoService service = new ProductoServiceImplement();
        Connection conn=(Connection) req.getAttribute("conn");
        ProductoService service=new ProductoServiceJdbcImplement(conn);
        Optional<Productos> producto=service.agregarPorId(idProducto);
        if(producto.isPresent()) {
            ItemRestaurante item = new ItemRestaurante(1,producto.get());
            HttpSession session = req.getSession();
            Restaurante carro;
            if(session.getAttribute("restaurante") == null) {
                carro = new Restaurante();
                session.setAttribute("restaurante", carro);
            }else{
                carro = (Restaurante)session.getAttribute("restaurante");
            }
            carro.addItemRestaurante(item);
        }
        resp.sendRedirect(req.getContextPath()+"/ver-restaurante");
    }
}
