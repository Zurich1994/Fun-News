package alexhao.fun.Utils;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.http.Header;

import java.io.IOException;

import alexhao.fun.Activity.BigPicActivity;
import alexhao.fun.Activity.PlayVideoActivity;
import alexhao.fun.Fragment.BigPicFragment;
import alexhao.fun.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

//import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Junqing on 2015/4/24.
 */
public class ViewHolder {

    private SparseArray<View> mViews;
    private Context context;
    private View mConvertView;
    private ImageLoader imgloader;
    private FragmentManager fm;
    private AsyncHttpClient asyncHttpClient;
    RequestQueue queue;

    private int  type;
    private int position;

    final int ONLY_WORD = 0;   //只有文字
    final int ONLY_PIC  = 1;   //只有图片
    final int WORD_PIC  = 2;   //文字+图片
    final int ONLY_VIDEO = 3;  //只有视频
    final int WORD_VIDEO = 4;  //文字+视频
    final int ONLY_SOUND = 5;  //只有声音
    final int WORD_SOUND = 6;  //文字+声音
    final int ONLY_GIF = 7;  //只有gif
    final int WORD_GIF = 8;  //文字+gif
    final int DRAWER = 9;      //侧边栏

    private int ONLY_WORD_LAYOUT = R.layout.item_only_word;
    private int ONLY_PIC_LAYOUT = R.layout.item_only_pic;
    private int WORD_PIC_LAYOUT = R.layout.item_word_pic;
    private int DRAWER_LAYOUT = R.layout.drawer_list_item;
    private int ONLY_VIDEO_LAYOUT = R.layout.item_only_video;
    private int ONLY_SOUND_LAYOUT = R.layout.item_only_sound;
    private int WORD_VIDEO_LAYOUT = R.layout.item_word_video;
    private int WORD_SOUND_LAYOUT = R.layout.item_word_sound;
    private int ONLY_GIF_LAYOUT = R.layout.item_only_gif;
    private int WORD_GIF_LAYOUT = R.layout.item_word_gif;

    private String des="http://funworks.duapp.com/Image/";
    private DisplayImageOptions options;
    BigPicFragment bigPicFragment=new BigPicFragment();
    BigPicActivity bigPicActivity=new BigPicActivity();

    public ViewHolder(Context context,ViewGroup parent,int position,int type,FragmentManager fm)
    {
            queue= Volley.newRequestQueue(context);
            this.position=position;
            this.mViews=new SparseArray<View>();
            this.type=type;
            this.context=context;


            switch(type){
                case ONLY_WORD :
                    mConvertView= LayoutInflater.from(context).inflate(ONLY_WORD_LAYOUT,parent,false);
                    break;
                case ONLY_PIC :
                    mConvertView= LayoutInflater.from(context).inflate(ONLY_PIC_LAYOUT,parent,false);
                    break;
                case WORD_PIC :
                    mConvertView= LayoutInflater.from(context).inflate(WORD_PIC_LAYOUT,parent,false);
                    break;
                case DRAWER :
                    mConvertView= LayoutInflater.from(context).inflate(DRAWER_LAYOUT,parent,false);
                    break;
                case ONLY_VIDEO :
                    mConvertView= LayoutInflater.from(context).inflate(ONLY_VIDEO_LAYOUT,parent,false);
                    break;
                case ONLY_SOUND :
                    mConvertView= LayoutInflater.from(context).inflate(ONLY_SOUND_LAYOUT,parent,false);
                    break;
                case WORD_VIDEO :
                    mConvertView= LayoutInflater.from(context).inflate(WORD_VIDEO_LAYOUT,parent,false);
                    break;
                case WORD_SOUND :
                    mConvertView= LayoutInflater.from(context).inflate(WORD_SOUND_LAYOUT,parent,false);
                    break;
                case ONLY_GIF :
                    mConvertView= LayoutInflater.from(context).inflate(ONLY_GIF_LAYOUT,parent,false);
                    break;
                case WORD_GIF :
                    mConvertView= LayoutInflater.from(context).inflate(WORD_GIF_LAYOUT,parent,false);
                    break;

            }
            mConvertView.setTag(this);
    }


    /**
* 入口方法 用于初始化viewHolder
*
* */
    public static ViewHolder get(Context context,View convertView
            ,ViewGroup parent,int position,int type,FragmentManager fm)
    {
        if(convertView==null) {
            return new ViewHolder(context, parent, position,type,fm);
        }else
        {
            ViewHolder viewHolder=(ViewHolder)convertView.getTag();
            viewHolder.position=position;
            viewHolder.type=type;
            viewHolder.context=context;
            viewHolder.fm=fm;
            return viewHolder;
        }
    }

    public View getConvertView()
    {
        return mConvertView;
    }

/**
 * 得到view id的方法
 *
 */
    public <T extends View> T getView(int viewId)  //T 泛型
    {
        View view=mViews.get(viewId);
        if(view==null)
        {
            view=mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
            return (T)view;
    }

/*---------------------------------------------------------------------*/

    public ViewHolder setText(int viewId,String text)
    {
        TextView tv=getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setImageResource(int viewId,int resId)
    {
        ImageView imageView=getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap)
    {
        GifImageView imageView= getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public ViewHolder setImageURL(int viewId,String imgUrl,int isgif)
    {
        if(isgif==0){
            GifImageView imageView= getView(viewId);
            asyncHttpClient = new AsyncHttpClient();
            showGif(imageView,des+imgUrl);
        }
       if(isgif==1)
       {
           ImageView imageView= getView(viewId);
           displayImageOptions();
           imgloader.getInstance().displayImage(des+imgUrl,imageView,options);
           Log.d("BBBBBBBBB", des + imgUrl);
       }
        return this;
    }


    public ViewHolder setImageClickListener(int viewId, final String url,int isgif)
    {
        if(isgif==0)
        {
            GifImageView imageView= getView(viewId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //bigPicFragment.setBigPic(des + url);
                    //bigPicActivity.setBigPic(des + url);
                    Intent intent = new Intent(context, BigPicActivity.class);
                    intent.putExtra("picaddr", des + url);
                    context.startActivity(intent);
                }
            });
        }
        if(isgif==1)
        {
            ImageView imageView= getView(viewId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //bigPicFragment.setBigPic(des + url);
                    //bigPicActivity.setBigPic(des + url);
                    Intent intent = new Intent(context, BigPicActivity.class);
                    intent.putExtra("picaddr", des + url);
                    context.startActivity(intent);
                }
            });
        }

        return this;
    }


    public ViewHolder setVideoClickListener(int viewId, final String url) {

            ImageView imageView = getView(viewId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, PlayVideoActivity.class);
                    intent.putExtra("videoaddr", des + url);
                    context.startActivity(intent);
                }
            });
        return  this;
    }

    public void displayImageOptions()
    {
         options = new DisplayImageOptions.Builder()
          .showImageOnLoading(R.drawable.morenpic) //设置图片在下载期间显示的图片
          .showImageForEmptyUri(R.drawable.morenpic)//设置图片Uri为空或是错误的时候显示的图片
         .showImageOnFail(R.drawable.morenpic)  //设置图片加载/解码过程中错误时候显示的图片
         .cacheInMemory(true)//设置下载的图片是否缓存在内存中
         .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
         .bitmapConfig(Bitmap.Config.ARGB_8888)
         .build();//构建完成
    }

    public void showGif(final GifImageView imageView,String url)
    {

        asyncHttpClient
                .get(url, new AsyncHttpResponseHandler() {

                            @Override
                            public void onSuccess(int arg0, Header[] arg1,
                                                  byte[] arg2) {
                                // TODO Auto-generated method stub

                                GifDrawable drawable = null;
                                try {
                                    drawable = new GifDrawable(arg2);
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                                imageView .setBackgroundDrawable(drawable);
                               // imageView.setVisibility(View.INVISIBLE);

                            }

                            @Override
                            public void onFailure(int arg0, Header[] arg1,
                                                  byte[] arg2, Throwable arg3) {
                                // TODO Auto-generated method stub

                            }
                        });
         }
}
