package alexhao.fun.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import alexhao.fun.R;

/**
 * Created by Junqing on 2015/4/24.
 */
public class LoadListView extends ListView implements AbsListView.OnScrollListener {

    View footer;
    int totalCount; //当前总数量
    int firstVisbleItem; //当前第一个可见的item
    int lastVisbleItem; //最后一个可见的item
    int scollState;//当前滚动状态

    Boolean isLoading=false; //正在加载
    MyLoadListener mLoadListener;

    public LoadListView(Context context) {
        super(context);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater=LayoutInflater.from(context);
        footer=inflater.inflate(R.layout.footer,null);
        //footer.findViewById(R.id.loadmore).setVisibility(View.GONE);
        this.addFooterView(footer);
        this.setOnScrollListener(this);
    }


    @Override
    public void onScrollStateChanged(AbsListView absListView, int scollState) {

        this.scollState=scollState;
        if(totalCount==lastVisbleItem&&scollState==SCROLL_STATE_IDLE)
        {
            //加载更多
            if(!isLoading)
            {
                isLoading=true;
                footer.findViewById(R.id.loadmore).setVisibility(View.VISIBLE);
                mLoadListener.onLoad();
            }

        }

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisbleItem, int VisbleItemCount, int totalItemCount) {
        this.lastVisbleItem=firstVisbleItem+VisbleItemCount;
        this.totalCount=totalItemCount;
        this.firstVisbleItem=firstVisbleItem;
        footer.findViewById(R.id.loadmore).setVisibility(View.VISIBLE);
    }


    public void loadComplete() //加载完毕
    {
        isLoading=false;
        footer.findViewById(R.id.loadmore).setVisibility(View.GONE);
    }

    /**
     * 回调接口（下拉刷新 、 加载更多）
     * @param mLoadListener
     */
    public void setLoadInterface(MyLoadListener mLoadListener)
    {
        this.mLoadListener=mLoadListener;
    }

    //加载更多数据的回调接口
    public interface MyLoadListener
    {
        public void onLoad();
    }

}
