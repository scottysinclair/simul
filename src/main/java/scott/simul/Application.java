package scott.simul;

import static spark.Spark.*;

public class Application {

    public static void main(String args[]) {
        port(8080);
        get("/hello", (req, res) -> "Hello World " + req.queryParams("who"));

    }
}
