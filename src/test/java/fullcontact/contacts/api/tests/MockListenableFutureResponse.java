package fullcontact.contacts.api.tests;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockListenableFutureResponse implements ListenableFuture<Response> {

    private final Integer status;
    private final String body;
    private final HashMap<String, String> headers;

    public MockListenableFutureResponse() {
        this(200, "{}", null);
    }

    public MockListenableFutureResponse(Integer status, String body, HashMap<String, String> headers) {
        this.status = status;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public void done() {

    }

    @Override
    public void abort(Throwable t) {

    }

    @Override
    public void touch() {

    }

    @Override
    public ListenableFuture<Response> addListener(Runnable listener, Executor exec) {
        return null;
    }

    @Override
    public CompletableFuture<Response> toCompletableFuture() {
        return null;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Response get() throws InterruptedException, ExecutionException {
        Response res = mock(Response.class);
        when(res.getStatusCode()).thenReturn(this.status);

        when(res.getResponseBody()).thenReturn(this.body);

        HttpHeaders h = HttpHeaders.EMPTY_HEADERS;

        if(this.headers != null) {
            this.headers.forEach((k,v) -> {
                List<String> values = new ArrayList<String>();
                values.add(v);
                h.add(k, values);
            });
        }

        when(res.getHeaders()).thenReturn(h);
        return res;
    }

    @Override
    public Response get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
