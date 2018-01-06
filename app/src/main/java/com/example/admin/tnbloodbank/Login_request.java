package com.example.admin.tnbloodbank;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 05-01-2018.
 */

public class Login_request extends StringRequest {
    private static final String Login_request_url = "https://gokulsankar1626.000webhostapp.com/login.php";
    private Map<String,String> params;

    public Login_request(String email_id, String password, Response.Listener<String> listener){
        super(Method.POST, Login_request_url, listener, null);
        params = new HashMap<>();
        params.put("email_id", email_id);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
