package alexhao.fun.Json;

import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import alexhao.fun.JavaBean.MainListBean;
import alexhao.fun.View.LoadListView;

/**
 * Created by Junqing on 2015/5/18.
 */
public class ParseMainList {

    SharedPreferences spf;
    SharedPreferences.Editor editor;
    private List<MainListBean> mlist;
    int id=0;
    String touxiang="";
    String name="";
    String time="";
    String word="";
    String img="";
    String tag1="";
    String tag2="";
    String tag3="";
    String zan="";
    String cai="";
    String pinglun="";
    String share="";
    int type=0;
    String video="";

    /**
     * 构造函数 需要传入相关的list<Bean>
     * @param list
     */
    public ParseMainList(List list) {
        this.mlist=list;

    }

    /**
     * 主要的解析函数 在解析处直接调用即可 注意参数
     * @param mtype  0:首次进入刷新  1：分页加载  2：下拉刷新
     * @param jarr
     * @return
     * @throws JSONException
     */
    public List<MainListBean> parseMainlist(int mtype,JSONArray jarr) throws JSONException {

        switch (mtype)
        {
            case 0:
                     getParse(jarr);
                     break;
            case 1:
                     getParse(jarr);
                     break;
            case 2:
                     mlist.clear();
                     getParse(jarr);
                     break;
        }
        Log.d("----onparsenum----", String.valueOf(mlist.size()));
        return mlist;
    }

    /**
     * 解析所需变量的函数
     * @param jarr
     * @throws JSONException
     */
    public void getParse(JSONArray jarr)throws JSONException
    {
        for(int i=0;i<jarr.length();i++) {
            JSONObject job = jarr.getJSONObject(i);
            id = job.getInt("fun_id");
            touxiang = job.getString("user_head");
            name = job.getString("user_name");
            time = job.getString("fun_time");
            word = job.getString("fun_content");
            img = job.getString("photo_name");
            tag1 = job.getString("sign1");
            tag2 = job.getString("sign2");
            tag3 = job.getString("sign3");
            zan = job.getString("praise_count");
            cai = job.getString("down_count");
            pinglun = job.getString("comment_count");
            share = job.getString("share_count");
            type = job.getInt("type");
            video=job.getString("video_name");
            mlist.add(new MainListBean(id,touxiang,name,time,word,img,tag1,tag2,tag3,zan,cai,pinglun,share,type,video));
            Log.d("AAAAAAAAAAAAAAAAA", id + touxiang + name + time + word + img + tag1 + tag2 + tag3 + zan + cai + pinglun + share + type+video);
        }

    }
}
