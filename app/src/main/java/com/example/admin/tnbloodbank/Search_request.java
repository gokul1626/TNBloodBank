package com.example.admin.tnbloodbank;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 05-01-2018.
 */

public class Search_request extends StringRequest {
    private static final String Search_request_url = "https://gokulsankar1626.000webhostapp.com/search.php";
    private Map<String,String> params;

    public Search_request(String district, String bloodgroup, Response.Listener<String> listener){
        super(Method.POST, Search_request_url, listener, null);
        params = new HashMap<>();
        params.put("district", district);
        params.put("bloodgroup", bloodgroup);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
