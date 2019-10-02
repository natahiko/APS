package randomer.model;

public class ProxyRequest {
    private int start;
    private int end;

    public ProxyRequest(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public ProxyRequest(Request request) {
        this.start = request.getStart();
        this.end = request.getEnd();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
