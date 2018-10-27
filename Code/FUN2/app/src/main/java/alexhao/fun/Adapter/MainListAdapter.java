package alexhao.fun.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import alexhao.fun.JavaBean.MainListBean;
import alexhao.fun.R;
import alexhao.fun.Utils.ViewHolder;

/**
 * Created by Junqing on 2015/4/25.
 */

public class MainListAdapter extends CommonAdapter<MainListBean> {

    protected int typeCount=9;
    List<MainListBean> mlist;
    int mtype;
    FragmentManager fm;
    final int ONLY_WORD = 0;
    final int ONLY_PIC  = 1;
    final int WORD_PIC  = 2;
    final int ONLY_VIDEO = 3;
    final int WORD_VIDEO = 4;
    final int ONLY_SOUND = 5;
    final int WORD_SOUND = 6;
    final int ONLY_GIF = 7;
    final int WORD_GIF =8;
    Context context;

    public MainListAdapter(Context context, List<MainListBean>datas,FragmentManager fm) {
        super(context, datas,fm);
        mlist=datas;
        this.context=context;
        this.fm=fm;
    }



    @Override
    public void convert(ViewHolder viewHolder, MainListBean mainListBean,int type) {

        /* 0:只有文字    1:只有图片    2:文字+图片   3:只有视频
           4：文字+视频  5：只有声音   6：文字+声音 7:gif 8: 文字+gif
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
            case ONLY_PIC:
                viewHolder.setText(R.id.name1,mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang1,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.time1,mainListBean.getTime());
                viewHolder.setText(R.id.tag1_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag1_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag1_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount1,mainListBean.getZan());
                viewHolder.setText(R.id.caicount1,mainListBean.getCai());
                viewHolder.setText(R.id.plcount1,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount1,mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang1,mainListBean.getTouxiang(),1);
                viewHolder.setImageURL(R.id.img1,mainListBean.getImg(),1);
                viewHolder.setImageClickListener(R.id.img1,mainListBean.getImg(),1);

                break;
            case WORD_PIC:

                viewHolder.setText(R.id.name4,mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang4,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.time4,mainListBean.getTime());
                viewHolder.setText(R.id.tag4_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag4_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag4_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount4,mainListBean.getZan());
                viewHolder.setText(R.id.caicount4,mainListBean.getCai());
                viewHolder.setText(R.id.plcount4,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount4,mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang4,mainListBean.getTouxiang(),1);
                viewHolder.setImageURL(R.id.img4,mainListBean.getImg(),1);
                viewHolder.setText(R.id.word4,mainListBean.getWord());
                viewHolder.setImageClickListener(R.id.img4,mainListBean.getImg(),1);
                break;

            case ONLY_VIDEO:
                viewHolder.setText(R.id.name5,mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang5,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.time5,mainListBean.getTime());
                viewHolder.setText(R.id.tag5_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag5_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag5_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount5,mainListBean.getZan());
                viewHolder.setText(R.id.caicount5,mainListBean.getCai());
                viewHolder.setText(R.id.plcount5,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount5,mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang5,mainListBean.getTouxiang(),1);
                viewHolder.setImageURL(R.id.img5,mainListBean.getImg(),1);
                viewHolder.setVideoClickListener(R.id.img5,mainListBean.getVideo());
                break;

            case WORD_VIDEO:
                viewHolder.setText(R.id.name6, mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang6, mainListBean.getTouxiang(), 1);
                viewHolder.setText(R.id.time6,mainListBean.getTime());
                viewHolder.setText(R.id.tag6_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag6_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag6_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount6,mainListBean.getZan());
                viewHolder.setText(R.id.caicount6,mainListBean.getCai());
                viewHolder.setText(R.id.plcount6,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount6, mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang6, mainListBean.getTouxiang(), 1);
                //             viewHolder.setImageResource(R.id.touxiang4,mainListBean.getTouxiang());
                viewHolder.setImageURL(R.id.img6, mainListBean.getImg(), 1);
                 viewHolder.setText(R.id.word6, mainListBean.getWord());
                viewHolder.setVideoClickListener(R.id.img6, mainListBean.getVideo());
                break;

            case ONLY_SOUND:
                viewHolder.setText(R.id.name7,mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang7,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.time7,mainListBean.getTime());
                viewHolder.setText(R.id.tag7_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag7_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag7_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount7,mainListBean.getZan());
                viewHolder.setText(R.id.caicount7,mainListBean.getCai());
                viewHolder.setText(R.id.plcount7,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount7,mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang7,mainListBean.getTouxiang(),1);
                //             viewHolder.setImageResource(R.id.touxiang4,mainListBean.getTouxiang());
                viewHolder.setImageURL(R.id.img7,mainListBean.getImg(),1);
                // viewHolder.setText(R.id.word4,mainListBean.getWord());
                viewHolder.setImageClickListener(R.id.img7,mainListBean.getImg(),1);
                break;

            case WORD_SOUND:
                viewHolder.setText(R.id.name8,mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang8,mainListBean.getTouxiang(),1);
                viewHolder.setText(R.id.time8,mainListBean.getTime());
                viewHolder.setText(R.id.tag8_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag8_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag8_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount8,mainListBean.getZan());
                viewHolder.setText(R.id.caicount8,mainListBean.getCai());
                viewHolder.setText(R.id.plcount8,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount8,mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang8,mainListBean.getTouxiang(),1);
                //             viewHolder.setImageResource(R.id.touxiang4,mainListBean.getTouxiang());
                viewHolder.setImageURL(R.id.img8,mainListBean.getImg(),1);
                // viewHolder.setText(R.id.word4,mainListBean.getWord());
                viewHolder.setImageClickListener(R.id.img8,mainListBean.getImg(),1);
                break;

            case ONLY_GIF:
                viewHolder.setText(R.id.name9, mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang9, mainListBean.getTouxiang(), 1);
                viewHolder.setText(R.id.time9,mainListBean.getTime());
                viewHolder.setText(R.id.tag9_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag9_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag9_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount9,mainListBean.getZan());
                viewHolder.setText(R.id.caicount9,mainListBean.getCai());
                viewHolder.setText(R.id.plcount9,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount9, mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang9, mainListBean.getTouxiang(), 1);
                viewHolder.setImageURL(R.id.img9, mainListBean.getImg(), 0);
              //  viewHolder.setImageClickListener(R.id.img9,mainListBean.getImg(),0);

                break;
            case WORD_GIF:

                viewHolder.setText(R.id.name10, mainListBean.getName());
                viewHolder.setImageURL(R.id.touxiang10, mainListBean.getTouxiang(), 1);
                viewHolder.setText(R.id.time10,mainListBean.getTime());
                viewHolder.setText(R.id.tag10_1,mainListBean.getTag1());
                viewHolder.setText(R.id.tag10_2,mainListBean.getTag2());
                viewHolder.setText(R.id.tag10_3,mainListBean.getTag3());
                viewHolder.setText(R.id.zancount10,mainListBean.getZan());
                viewHolder.setText(R.id.caicount10,mainListBean.getCai());
                viewHolder.setText(R.id.plcount10,mainListBean.getPinglun());
                viewHolder.setText(R.id.sharecount10, mainListBean.getShare());
                viewHolder.setImageClickListener(R.id.touxiang10, mainListBean.getTouxiang(), 1);
                viewHolder.setImageURL(R.id.img10, mainListBean.getImg(), 0);
                viewHolder.setText(R.id.word10, mainListBean.getWord());
               // viewHolder.setImageClickListener(R.id.img10,mainListBean.getImg(),0);
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        mtype= mlist.get(position).getType();
           if(mtype==0)
               return ONLY_WORD;
                else if(mtype==1)
                    return ONLY_PIC;
                        else if(mtype==2)
                         return WORD_PIC;
                           else if(mtype==3)
                            return ONLY_VIDEO;
                           else if(mtype==4)
                            return WORD_VIDEO;
                       else if(mtype==5)
                       return ONLY_SOUND;
              else if(mtype==6)
               return WORD_SOUND;
             else  if(mtype==7)
               return ONLY_GIF;
        else
               return WORD_GIF;

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
