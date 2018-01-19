package main.java.clientCom;



import javax.ws.rs.core.Response;
import java.util.concurrent.Callable;

/**
 * Created by Malte on 17-12-2017.
 */
public class RunResponse implements Callable<Response> {

    //private final ResponseBuilder resp;
    private final Response response;

    public RunResponse(Response response) {
        //this.resp = resp;

        this.response = response;
    }



    @Override
    public Response call() throws Exception {

        return response;
    }
}
