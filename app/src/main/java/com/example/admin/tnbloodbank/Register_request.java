package com.example.admin.tnbloodbank;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 03-01-2018.
 */

public class Register_request extends StringRequest {
    private static final String Register_request_url = "https://gokulsankar1626.000webhostapp.com/register.php";
    private Map<String,String> params;

    public Register_request(String name, String sex, String bloodgroup, String phone_whatsapp_no, String email_id, String password, String address, String district, String previous_donationn, Response.Listener<String> listener){
        super(Method.POST, Register_request_url, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("sex", sex);
        params.put("bloodgroup", bloodgroup);
        params.put("phone_whatsapp_no", phone_whatsapp_no);
        params.put("email_id", email_id);
        params.put("password", password);
        params.put("address", address);
        params.put("district", district);
        params.put("previous_donationn", previous_donationn);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
