package Controlador;

import Modelo.Cliente;
import Modelo.ClienteABM;
import Modelo.Producto;
import Modelo.ProductoABM;
import Modelo.Pedido;
import Modelo.PedidoABM;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian Englert - Septiembre 2.023
 */
public class Controlador extends HttpServlet {

    Cliente cl = new Cliente();
    ClienteABM cAbm = new ClienteABM();
    Producto pr = new Producto();
    ProductoABM pAbm = new ProductoABM();
    Pedido pe = new Pedido();
    PedidoABM peAbm = new PedidoABM();
    int idc;
    int idp;
    int idpe;

    Pedido p = new Pedido();
    List<Pedido> lista = new ArrayList<>();
    int item, cod;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double total;

    String numeroFactura;
    Calendar c = new GregorianCalendar();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List lista = cAbm.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String apellido = request.getParameter("txtApellido");
                    String nombre = request.getParameter("txtNombre");
                    cl.setDni(dni);
                    cl.setApellido(apellido);
                    cl.setNombre(nombre);
                    cAbm.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cAbm.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String apellido1 = request.getParameter("txtApellido");
                    String nombre1 = request.getParameter("txtNombre");
                    cl.setDni(dni1);
                    cl.setApellido(apellido1);
                    cl.setNombre(nombre1);
                    cl.setId_cliente(idc);
                    cAbm.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cAbm.eliminar(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = pAbm.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String producto = request.getParameter("txtProducto");
                    String precio = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    pr.setProducto(producto);
                    pr.setPrecio(Double.parseDouble(precio));
                    pr.setStock(Integer.parseInt(stock));
                    pAbm.agregar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto p = pAbm.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String producto1 = request.getParameter("txtProducto");
                    String precio1 = request.getParameter("txtPrecio");
                    String stock1 = request.getParameter("txtStock");
                    pr.setProducto(producto1);
                    pr.setPrecio(Double.parseDouble(precio1));
                    pr.setStock(Integer.parseInt(stock1));
                    pr.setId_producto(idp);
                    pAbm.actualizar(pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pAbm.eliminar(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("NuevoPedido")) {
            String fecha = ("" + c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH));
            request.setAttribute("fecha", fecha);
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    cl.setDni(dni);
                    cl = cAbm.buscar(dni);
                    request.setAttribute("cl", cl);
                    request.setAttribute("numerofactura", numeroFactura);
                    request.setAttribute("fecha", fecha);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pr = pAbm.listarId(id);
                    request.setAttribute("cl", cl);
                    request.setAttribute("producto", pr);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", total);
                    request.setAttribute("numerofactura", numeroFactura);
                    request.setAttribute("fecha", fecha);
                    break;
                case "Agregar":
                    if (Integer.parseInt(request.getParameter("cantidad")) <= Integer.parseInt(request.getParameter("stock"))) {
                        request.setAttribute("cl", cl);
                        total = 0.0;
                        item = item + 1;
                        cod = pr.getId_producto();
                        descripcion = request.getParameter("nombreproducto");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cantidad = Integer.parseInt(request.getParameter("cantidad"));
                        subtotal = precio * cantidad;
                        p = new Pedido();
                        p.setItem(item);
                        p.setId_producto(cod);
                        p.setDescripcion_p(descripcion);
                        p.setPrecio(precio);
                        p.setCantidad(cantidad);
                        p.setSubtotal(subtotal);
                        lista.add(p);
                        for (int i = 0; i < lista.size(); i++) {
                            total = total + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("totalpagar", total);
                        request.setAttribute("lista", lista);
                        request.setAttribute("numerofactura", numeroFactura);
                        request.setAttribute("fecha", fecha);
                    } else {
                        String insuficiente = "Sin Stock";
                        request.setAttribute("insuficiente", insuficiente);
                        request.setAttribute("totalpagar", total);
                        request.setAttribute("lista", lista);
                        request.setAttribute("numerofactura", numeroFactura);
                        request.setAttribute("fecha", fecha);
                    }
                    break;
                case "GenerarPedido":
                    //Actualizar Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad = lista.get(i).getCantidad();
                        int id_producto = lista.get(i).getId_producto();
                        ProductoABM prAbm = new ProductoABM();
                        pr = prAbm.buscar(id_producto);
                        int stockA = pr.getStock() - cantidad;
                        prAbm.actualizarStock(id_producto, stockA);
                    }
                    //Guardar Pedido
                    p.setId_cliente(cl.getId_cliente());
                    p.setNro_factura(numeroFactura);
                    p.setFecha(fecha);
                    p.setTotal(total);
                    peAbm.guardarPedido(p);
                    //Guardar DetallePedido
                    int idpe = Integer.parseInt(peAbm.idPedido());
                    for (int i = 0; i < lista.size(); i++) {
                        p = new Pedido();
                        p.setId(idpe);
                        p.setId_producto(lista.get(i).getId_producto());
                        p.setCantidad(lista.get(i).getCantidad());
                        p.setSubtotal(lista.get(i).getSubtotal());
                        peAbm.guardarDetallePedido(p);
                    }
                    break;
                default:
                    p = new Pedido();
                    lista = new ArrayList<>();
                    item = 0;
                    total = 0.0;

                    numeroFactura = peAbm.GenerarFactura();
                    if (numeroFactura == null) {
                        numeroFactura = "00000001";
                        request.setAttribute("numerofactura", numeroFactura);
                    } else {
                        int incrementar = Integer.parseInt(numeroFactura);
                        GenerarFactura gf = new GenerarFactura();
                        numeroFactura = gf.NumeroFactura(incrementar);
                        request.setAttribute("numerofactura", numeroFactura);
                    }
                    request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
