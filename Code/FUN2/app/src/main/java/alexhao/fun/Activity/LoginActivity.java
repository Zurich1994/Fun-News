package alexhao.fun.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import alexhao.fun.R;
import alexhao.fun.View.CircleButton;
import alexhao.fun.View.RoundImgView;
import pl.droidsonroids.gif.GifImageView;

public class LoginActivity extends Activity {

    private LinearLayout linear;
    private Intent intent;

    private RoundImgView head;
   // private GifImageView head;
    private EditText username,password;
    private RequestQueue mQueue;
    private CircleButton committologin,canceltologin;
    SharedPreferences spf;
    SharedPreferences.Editor editor ;
    private static final String loginAddr = "http://funworks.duapp.com/servlet/CheckLoginServlet";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
                username.setText(data.getStringExtra("userid"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        mQueue= Volley.newRequestQueue(this);
        initViews();
        spf= getSharedPreferences("userConfig", MODE_PRIVATE);
        editor= spf.edit();
        intent=new Intent(this,RegisActivity.class);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intent, 1);
            }
        });

        canceltologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        committologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }

    public void initViews()
    {
        linear= (LinearLayout) findViewById(R.id.login_linear3);
        head= (RoundImgView) findViewById(R.id.login_head);
       // head= (GifImageView) findViewById(R.id.login_head);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        committologin= (CircleButton) findViewById(R.id.committologin);
        canceltologin= (CircleButton) findViewById(R.id.canceltologin);
    }


    public void userLogin()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, loginAddr, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("xxxxxx",s);
                if(s.equals("false"))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "登录失败~", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "登录成功~", Toast.LENGTH_SHORT);
                    toast.show();
                    Log.d("ccc", s);
                    Intent intent=new Intent();
                    intent.putExtra("username",spf.getString("user_name",""));
                    Log.d("sssssssssssss",spf.getString("user_name",""));
                    setResult(RESULT_OK,intent);
                    finish();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast toast = Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT);
                toast.show();
                Log.d("ddd", "-----------------onerrorresponse------------------");
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();

                map.put("user_id", username.getText().toString());
               map.put("user_password", password.getText().toString());

                return map;
            }
        };
        mQueue.add(stringRequest);
    }
}
