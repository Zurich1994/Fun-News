package alexhao.fun.Fragment;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import alexhao.fun.Activity.MainActivity;
import alexhao.fun.Adapter.MainListAdapter;
import alexhao.fun.Adapter.WordListAdapter;
import alexhao.fun.JavaBean.MainListBean;
import alexhao.fun.Json.JsonArrayPostRequest;
import alexhao.fun.Json.ParseMainList;
import alexhao.fun.Json.ParseWordList;
import alexhao.fun.R;
import alexhao.fun.View.LoadListView;
import alexhao.fun.View.RefreshableView;

public class WordFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener,LoadListView.MyLoadListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SwipeRefreshLayout mswipelayout;
    private LoadListView listView;
    private WordListAdapter listAdapter;
    private MainActivity main;
    RequestQueue mQueue;
    FragmentManager fm;
    //请求数据地址
    final String mainAddr = "http://funworks.duapp.com/servlet/FunShowServlet";

    ParseWordList parse;

    List<MainListBean> data;

    BigPicFragment bpfrag = new BigPicFragment();

    SharedPreferences spf;
    SharedPreferences.Editor editor;
    String result; //保留的数据

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TODO: Rename and change types and number of parameters
    public static WordFragment newInstance(String param1, String param2) {
        WordFragment fragment = new WordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public WordFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fm = getActivity().getSupportFragmentManager();
        mQueue = Volley.newRequestQueue(getActivity());

        View v = inflater.inflate(R.layout.fragment_word, container, false);
        listView = (LoadListView) v.findViewById(R.id.loadlist1);
        mswipelayout= (SwipeRefreshLayout) v.findViewById(R.id.swipelayout1);
        data = new ArrayList<MainListBean>();
        parse = new ParseWordList(data);

        JsonArrayRequest req = new JsonArrayRequest(mainAddr, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast toast = Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT);
                toast.show();
                Log.d("----onfirst1---------", "chenggong!");
                Log.d("----onfirst1-----------", response.toString());
                try {
                    Log.d("dddddddddddd1",data.toString());
                    data = parse.parseWordlist(0,response);
                    Log.d("dddddddddddd",data.toString());
                    listAdapter = new WordListAdapter(getActivity(), data, fm);
                    listView.setAdapter(listAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(req);
        listView.setLoadInterface(this);
        mswipelayout.setOnRefreshListener(this);
        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.main = (MainActivity) activity;
    }


    /**
     * 上拉加载更多
     */
    @Override
    public void onLoad() {
        Map<String,String>mMap=new HashMap<String, String>();
        mMap.put("time",data.get(data.size()-1).getTime());
        JsonArrayPostRequest req2=new JsonArrayPostRequest(mainAddr, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    Log.d("------onloadtime------", data.get(data.size()-1).getTime());
                    Log.d("--------onload---------", "chenggong!");
                    Log.d("----onloaddata-----", response.toString());
                    data = parse.parseWordlist(1,response);
                    Log.d("------------------",data.get(0).getWord());
                    if (listAdapter != null){
                        listAdapter.DataChangedObserver(data);
                        listView.loadComplete();
                    }else
                    {
                        listAdapter = new WordListAdapter(getActivity(), data, fm);
                        listView.setAdapter(listAdapter);
                        listView.loadComplete();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listView.loadComplete();
            }
        },mMap);
        req2.setRetryPolicy(new DefaultRetryPolicy(4000,1,1.0f));
        mQueue.add(req2);
    }

    /**
     * 下拉刷新数据
     *
     */
    @Override
    public void onRefresh() {

        JsonArrayRequest req1 = new JsonArrayRequest(mainAddr, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast toast = Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT);
                toast.show();
                Log.d("----onrefresh1---------", "chenggong!");
                Log.d("----onrefrsh1--------", response.toString());
                try {
                    data = parse.parseWordlist(2,response);
                    Log.d("------------------",data.get(0).getWord());
                    if (listAdapter != null) {
                        listAdapter.DataChangedObserver(data);
                        mswipelayout.setRefreshing(false);
                    }else
                    {
                        listAdapter = new WordListAdapter(getActivity(), data, fm);
                        listView.setAdapter(listAdapter);
                        mswipelayout.setRefreshing(false);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mswipelayout.setRefreshing(false);
            }
        });
        req1.setRetryPolicy(new DefaultRetryPolicy(4000,1,1.0f));
        mQueue.add(req1);
    }

}
