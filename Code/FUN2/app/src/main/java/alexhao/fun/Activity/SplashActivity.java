package alexhao.fun.Activity;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
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

public class SplashActivity extends Activity {

    private static final int SHOW_TIME_MIN = 2000;
    private static final String loginAddr = "http://funworks.duapp.com/servlet/CheckLoginServlet";
    public BroadcastReceiver connectionReceiver;
    SharedPreferences spf,spf1 ;
    SharedPreferences.Editor editor,editor1 ;
    RequestQueue mQueue ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connectionReceiver != null) {
            unregisterReceiver(connectionReceiver);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        
        mQueue= Volley.newRequestQueue(this);

        checkNetState();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectionReceiver, intentFilter);
        spf= getSharedPreferences("userConfig", MODE_PRIVATE);
        editor= spf.edit();
        spf1= getSharedPreferences("lastData", MODE_PRIVATE);
        editor1= spf1.edit();


        new AsyncTask<Void, Void, Integer>() {

            long startTime = System.currentTimeMillis(); //程序开始时间
            @Override
            protected Integer doInBackground(Void... voids) {


                if(spf.getString("init_success","0")=="0")
                    initUserConfig();
                if(spf1.getString("init_success","0")=="0")
                    initLastData();

                Log.d("aaa", "-----------------用户配置完成------------------"+spf.getString("user_name","x"));
                userLogin();
                Log.d("bbb", "-----------------登录完成------------------");
                long loadingTime = System.currentTimeMillis() - startTime; //加载时间
                if (loadingTime < SHOW_TIME_MIN) {
                    try {
                        Thread.sleep(SHOW_TIME_MIN - loadingTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }.execute(new Void[]{});

    }

    /**
     * 用户配置信息
     */
    public void initUserConfig() {

        editor.putString("init_success", "1"); //第一次执行 判断
        editor.putString("user_id","");
        editor.putString("user_name", "");
        editor.putString("user_password", "");
        editor.putString("user_info", "暂无简介");
        editor.putString("user_sex","");
        editor.putString("user_avatar", "");
        editor.commit();
    }

    /**
     * 初始化最后一次退出的数据
     */
    public void initLastData()
    {
        editor1.putString("init_success", "1"); //第一次执行 判断
        editor1.putString("last_mainlist","");
        editor1.putString("last_wordlist","");
        editor1.putString("last_piclist","");
        editor1.putString("last_videolist","");
        editor1.putString("last_soundlist","");
        editor1.commit();
    }

    /**
     * 广播检测网络情况
     */
    public void checkNetState() {

        connectionReceiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                ConnectivityManager connectMgr = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo mobNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                NetworkInfo wifiNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "当前无网络连接~", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (mobNetInfo.isConnected()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "正在使用移动数据~", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        };

    }

    /**
     * 用户登录
     */
    public void userLogin()
    {
        if(spf.getString("user_name","").equals(""))
        {

        }else{
            StringRequest stringRequest = new StringRequest(Request.Method.POST, loginAddr, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    if(s.equals("false")){
                        Toast toast = Toast.makeText(getApplicationContext(), "登录失败~", Toast.LENGTH_SHORT);
                        toast.show();
                    }else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(), "登录成功~", Toast.LENGTH_SHORT);
                        toast.show();
                        Log.d("ccc", "-----------------onresponse------------------");
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

                    map.put("user_id", spf.getString("user_id",""));
                    map.put("user_password", spf.getString("user_password",""));
                    return map;
                }
            };
            mQueue.add(stringRequest);

        }

    }

}
