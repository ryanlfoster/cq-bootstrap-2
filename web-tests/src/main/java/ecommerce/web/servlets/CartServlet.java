package ecommerce.web.servlets;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class CartServlet extends HttpServlet {


    private final HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();

    class PurchaseProduct {

        private List<Product> products = new ArrayList<Product>();

        PurchaseProduct(Product ... products) {
            this.products.addAll(Arrays.asList(products));
        }

        int getTotalCount(){
            return products.size();
        }

        double getTotalCost(){
            double d = 0.00;
            for (Product product : products) {
                d += product.getCost();
            }
            return d;
        }
        public void add(Product product) {
            products.add(product);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getSession(true).getId();

        ObjectMapper objectMapper = new ObjectMapper();


        Product product = objectMapper.readValue(request.getReader(), Product.class);

        Map<String, PurchaseProduct> cart = getCart(request);
        if(cart == null){
            cart = new HashMap<String, PurchaseProduct>();
        }

        if(cart.containsKey(product.getSku())){
            PurchaseProduct purchaseProduct = cart.get(product.getSku());
            purchaseProduct.add(product);
            cart.put(product.getSku(), purchaseProduct);
        }
        else{
            cart.put(product.getSku(), new PurchaseProduct(product));
        }

        request.getSession().setAttribute("cart" , cart);

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getSession(true).getId();

        Map<String, PurchaseProduct> cart = getCart(request);

        String s = generateJson(id,cart);
        response.setContentType("application/json");
        PrintWriter writer1 = response.getWriter();
        writer1.println(s);
        writer1.flush();
        writer1.close();

    }

    private Map<String, PurchaseProduct> getCart(HttpServletRequest request) {
        return (Map<String, PurchaseProduct>) request.getSession().getAttribute("cart");
    }


    private String generateJson(String id, Map<String, PurchaseProduct> cart)  {
        JsonGenerator jsonGenerator;
        try {
            StringWriter writer1 = new StringWriter();
            jsonGenerator = new JsonFactory().createJsonGenerator(writer1);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", id);
            jsonGenerator.writeStringField("email" , "ssmithstone@me.com");


            jsonGenerator.writeArrayFieldStart("products");

            if( null != cart ){

                for (Map.Entry<String, PurchaseProduct> next : cart.entrySet()) {
                    PurchaseProduct n = next.getValue();
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField("code", "SKU" + next.getKey());
                    jsonGenerator.writeNumberField("quantity", n.getTotalCount());
                    jsonGenerator.writeNumberField("totalItemCost", n.getTotalCost());
                    jsonGenerator.writeEndObject();
                }
            }

            jsonGenerator.writeEndArray();


            jsonGenerator.writeEndObject();
            jsonGenerator.flush();
            return writer1.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.format("{ id : %s , email : %s , products : [] }", "-" , "-");
    }
}

