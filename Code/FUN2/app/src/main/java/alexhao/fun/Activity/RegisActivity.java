package alexhao.fun.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

import alexhao.fun.Dialog.RegisDialog;
import alexhao.fun.R;
import alexhao.fun.View.CircleButton;
import alexhao.fun.View.RoundImgView;

public class RegisActivity extends Activity implements View.OnClickListener {


    private EditText set_username,set_password,ensurepassword;
    private CircleButton committoregis,canceltoregis,okregis;
    RequestQueue mQueue ;
    String name,pass1,pass2=null;
    RegisDialog regisDialog;
    SharedPreferences spf;
    SharedPreferences.Editor editor ;

    private static final String RegisAddr = "http://funworks.duapp.com/servlet/Register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regis);
        mQueue= Volley.newRequestQueue(this);
        initViews();
        initEvents();
        spf= getSharedPreferences("userConfig", MODE_PRIVATE);
        editor= spf.edit();
    }

    public void initViews()
    {
        set_username= (EditText) findViewById(R.id.set_username);
        set_password= (EditText) findViewById(R.id.set_password);
        ensurepassword=(EditText)findViewById(R.id.ensurepassword);
        committoregis= (CircleButton) findViewById(R.id.committoregis);
        canceltoregis= (CircleButton) findViewById(R.id.canceltoregis);
        okregis= (CircleButton) findViewById(R.id.okregis);

    }

    public void initEvents()
    {
        committoregis.setOnClickListener(this);
        canceltoregis.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {

            case R.id.committoregis:
            {
                name=set_username.getText().toString().trim();
                pass1=set_password.getText().toString().trim();
                pass2=ensurepassword.getText().toString().trim();
                Log.d("dddddd",name+pass1+pass2);
                if("".equals(name))
                {
                    Toast toast=Toast.makeText(this,"昵称不能为空",Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
                if("".equals(pass1))
                {
                    Toast toast1=Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT);
                    toast1.show();
                    break;
                }
                if("".equals(pass2))
                {
                    Toast toast2=Toast.makeText(this,"请确认密码",Toast.LENGTH_SHORT);
                    toast2.show();
                    break;
                }
                if(!(pass1.equals(pass2)))
                {
                    Toast toast3=Toast.makeText(this,"请确认两次密码输入一致",Toast.LENGTH_SHORT);
                    toast3.show();
                    break;
                }
                userRegis();
                break;
            }

            case R.id.canceltoregis:
                finish();
                break;
            case R.id.okregis:

                break;
        }
    }

    public void userRegis()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, RegisAddr, new Response.Listener<String>() {
            @Override
            public void onResponse(final String s) {
                Toast toast = Toast.makeText(getApplicationContext(), "注册成功~", Toast.LENGTH_SHORT);
                toast.show();
                Log.d("ididid", s);
                regisDialog=new RegisDialog(RegisActivity.this,s);
                regisDialog.setTitle("恭喜，注册成功！");
                regisDialog.show();

                editor.putString("user_id",s);
                editor.putString("user_name",name);
                editor.putString("user_password",pass2);
                editor.commit();

                regisDialog.setOnDialogClickListener(new RegisDialog.dialogClickListener() {
                    @Override
                    public void confirm() {
                        Intent intent = new Intent();
                        intent.putExtra("userid",s);
                        setResult(RESULT_OK, intent);
                        regisDialog.dismiss();
                        RegisActivity.this.finish();
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast toast = Toast.makeText(getApplicationContext(), "注册失败，请重新尝试~", Toast.LENGTH_SHORT);
                toast.show();
                Log.d("ddd", "-----------------onerrorresponse------------------");
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("user_name",name);
                map.put("password",pass2);
                return map;
            }
        };
        mQueue.add(stringRequest);
    }

}
