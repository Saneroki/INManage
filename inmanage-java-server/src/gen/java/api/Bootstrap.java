package gen.java.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;
import main.java.databaseCom.SQLCommands;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.sql.SQLException;

public class Bootstrap extends HttpServlet {

  public static SQLCommands sql;

  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("INManage")
      .description("Simple API for InManage")
      .termsOfService("")
      .contact(new Contact()
        .email(""))
      .license(new License()
        .name("Apache 2.0")
        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    try {
      sql = SQLCommands.getInstance();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }

  public static SQLCommands getSql(){
      return sql;
  }
}
