package alexhao.fun.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import java.util.List;

import alexhao.fun.JavaBean.MainListBean;
import alexhao.fun.R;
import alexhao.fun.Utils.ViewHolder;

/**
 * Created by ALexHao on 15/6/27.
 */
public class WordListAdapter extends CommonAdapter<MainListBean> {

    protected int typeCount=1;
    List<MainListBean> mlist;
    int mtype;
    FragmentManager fm;
    final int ONLY_WORD = 0;

    Context context;

    public WordListAdapter(Context context, List<MainListBean>datas,FragmentManager fm) {
        super(context, datas,fm);
        mlist=datas;
        this.context=context;
        this.fm=fm;
    }



    @Override
    public void convert(ViewHolder viewHolder, MainListBean mainListBean,int type) {

        /* 0:只有文字
        */
        switch (type)
        {
            case ONLY_WORD :
                viewHolder.setText(R.id.name,mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.time,mainListBean.getTime());
                viewHolder.setText(R.id.tag1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount,mainListBean.getZan());
                viewHolder.setText(R.id.caicount,mainListBean.getCai());
                viewHolder.setText(R.id.plcount,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount,mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.word,mainListBean.getWord());
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        mtype= mlist.get(position).getType();

            return ONLY_WORD;

    }

    @Override
    public int getViewTypeCount() {
        return typeCount;
    }


    public void DataChangedObserver(List<MainListBean> list) {

        this.mlist=list;
        this.notifyDataSetChanged();
    }

}

