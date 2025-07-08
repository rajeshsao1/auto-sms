package com.autosms.myapplicationcallevent.Helper;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class VolleyMultipartRequest extends Request<NetworkResponse> {
    private final String boundary = ("apiclient-" + System.currentTimeMillis());
    private final String lineEnd = "\r\n";
    private Response.ErrorListener mErrorListener;
    private Map<String, String> mHeaders;
    private Response.Listener<NetworkResponse> mListener;
    private final String twoHyphens = "--";

    public VolleyMultipartRequest(int method, String url, Response.Listener<NetworkResponse> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> map = this.mHeaders;
        return map != null ? map : super.getHeaders();
    }

    public String getBodyContentType() {
        return "multipart/form-data;boundary=" + this.boundary;
    }

    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);
        try {
            Map<String, String> params = getParams();
            if (params != null && params.size() > 0) {
                textParse(dos, params, getParamsEncoding());
            }
            Map<String, DataPart> data = getByteData();
            if (data != null && data.size() > 0) {
                dataParse(dos, data);
            }
            dos.writeBytes("--" + this.boundary + "--" + "\r\n");
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, DataPart> getByteData() throws AuthFailureError {
        return null;
    }

    /* access modifiers changed from: protected */
    public Response<NetworkResponse> parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(response, HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new ParseError((Throwable) e));
        }
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(NetworkResponse response) {
        this.mListener.onResponse(response);
    }

    public void deliverError(VolleyError error) {
        this.mErrorListener.onErrorResponse(error);
    }

    private void textParse(DataOutputStream dataOutputStream, Map<String, String> params, String encoding) throws IOException {
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                buildTextPart(dataOutputStream, entry.getKey(), entry.getValue());
            }
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + encoding, uee);
        }
    }

    private void dataParse(DataOutputStream dataOutputStream, Map<String, DataPart> data) throws IOException {
        for (Map.Entry<String, DataPart> entry : data.entrySet()) {
            buildDataPart(dataOutputStream, entry.getValue(), entry.getKey());
        }
    }

    private void buildTextPart(DataOutputStream dataOutputStream, String parameterName, String parameterValue) throws IOException {
        dataOutputStream.writeBytes("--" + this.boundary + "\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + parameterName + "\"" + "\r\n");
        dataOutputStream.writeBytes("\r\n");
        StringBuilder sb = new StringBuilder();
        sb.append(parameterValue);
        sb.append("\r\n");
        dataOutputStream.writeBytes(sb.toString());
    }

    private void buildDataPart(DataOutputStream dataOutputStream, DataPart dataFile, String inputName) throws IOException {
        dataOutputStream.writeBytes("--" + this.boundary + "\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + dataFile.getFileName() + "\"" + "\r\n");
        if (dataFile.getType() != null && !dataFile.getType().trim().isEmpty()) {
            dataOutputStream.writeBytes("Content-Type: " + dataFile.getType() + "\r\n");
        }
        dataOutputStream.writeBytes("\r\n");
        ByteArrayInputStream fileInputStream = new ByteArrayInputStream(dataFile.getContent());
        int bufferSize = Math.min(fileInputStream.available(), 1048576);
        byte[] buffer = new byte[bufferSize];
        int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        while (bytesRead > 0) {
            dataOutputStream.write(buffer, 0, bufferSize);
            bufferSize = Math.min(fileInputStream.available(), 1048576);
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
        }
        dataOutputStream.writeBytes("\r\n");
    }

    public class DataPart {
        private byte[] content;
        private String fileName;
        private String type;

        public DataPart() {
        }

        public DataPart(String name, byte[] data) {
            this.fileName = name;
            this.content = data;
        }

        /* access modifiers changed from: package-private */
        public String getFileName() {
            return this.fileName;
        }

        /* access modifiers changed from: package-private */
        public byte[] getContent() {
            return this.content;
        }

        /* access modifiers changed from: package-private */
        public String getType() {
            return this.type;
        }
    }
}
