package com.zcc.zqtdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.zcc.zqtdemo.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_username)
    EditText mUsername;

    @BindView(R.id.edt_password)
    EditText mPassword;

    @BindView(R.id.tv_textarea)
    TextView mTextArea;

    private static final String TAG = "hello";


    @OnClick(R.id.button)
    void click() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest json = new JsonObjectRequest(Request.Method.POST, "http://route.showapi.com/9-7",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this, "连接网络", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onResponse: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: " + "连接失败" + error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("showapi_appid", "22455");
                map.put("areaid", "101010100");
                map.put("month", "201611");
                map.put("showapi_sign", "a23624424414443081dfd587547cf70b");
                return map;
            }
        };
        requestQueue.add(json);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
