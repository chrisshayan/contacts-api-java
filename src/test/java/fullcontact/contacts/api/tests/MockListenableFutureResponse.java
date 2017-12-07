package fullcontact.contacts.api.tests;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
    public void content(Response response) {

    }

    @Override
    public void touch() {

    }

    @Override
    public boolean getAndSetWriteHeaders(boolean writeHeader) {
        return false;
    }

    @Override
    public boolean getAndSetWriteBody(boolean writeBody) {
        return false;
    }

    @Override
    public ListenableFuture<Response> addListener(Runnable listener, Executor exec) {
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

        try {
            when(res.getResponseBody()).thenReturn(this.body);
        } catch(IOException ex) {

        }

        FluentCaseInsensitiveStringsMap h = new FluentCaseInsensitiveStringsMap();

        if(this.headers != null) {
            this.headers.forEach((k,v) -> {
                List<String> values = new ArrayList<String>();
                values.add(v);
                h.put(k, values);
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
