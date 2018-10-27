package alexhao.fun.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import alexhao.fun.Activity.MainActivity;
import alexhao.fun.Libs.photoview.PhotoView;
import alexhao.fun.Libs.photoview.PhotoViewAttacher;
import alexhao.fun.R;

public class BigPicFragment extends DialogFragment {

    private DisplayImageOptions options;
    private ImageLoader imageLoader;
    PhotoView img;
    RelativeLayout bigpiclayout;
    String url;
    private PhotoViewAttacher mAttacher;
    private String srcDir;
    private String Destdir= Environment.getExternalStorageDirectory()+"/FUN";
    String newFileName ;
    private File srcFile,destFile;
    SharedPreferences spf ;
    SharedPreferences.Editor editor;
    MainActivity main;

    public BigPicFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        spf= getActivity().getSharedPreferences("userConfig", Context.MODE_PRIVATE);
        editor= spf.edit();
        View view= inflater.inflate(R.layout.fragment_bigpic, container, false);
        img= (PhotoView) view.findViewById(R.id.bigpic);
        bigpiclayout= (RelativeLayout) view.findViewById(R.id.bigpiclayout);
        displayImageOptions();
        showBigPic();

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.main= (MainActivity) activity;
    }

    public void setBigPic(String url)
    {
        this.url=url;
      /* *//* int m=spf.getInt("picid",0)+1;
        newFileName=String.valueOf(m)+".jpg";
        editor.putInt("picid",m);
        editor.commit();*/
//        Log.d("666666666",spf.getString("user_name","x"));
    }

    public void showBigPic()
    {

        imageLoader.getInstance().displayImage(url,img,options);

        mAttacher = new PhotoViewAttacher(img);
        mAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                dismiss();
            }
        });
        mAttacher.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                srcDir = imageLoader.getInstance().getDiscCache().get(url).getPath();
                srcFile = new File(srcDir);
                destFile = new File(Destdir);
                copyFile(srcFile, destFile, newFileName);
                Toast toast = Toast.makeText(getActivity(), "已保存图片", Toast.LENGTH_SHORT);
                toast.show();
                return true;

            }

        });

    }
    public void displayImageOptions()
    {
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.max90) //设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.drawable.max90)//设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.max90)  //设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .build();//构建完成
    }

    /**
     * 保存图片到本地
     * @param srcFile
     * @param destDir
     * @param newFileName
     * @return
     */
    public long copyFile(File srcFile, File destDir, String newFileName) {
        long copySizes = 0;

        if (!destDir.exists()) {
                destDir.mkdir();
        }
            try
            {
                BufferedInputStream bin = new BufferedInputStream(
                        new FileInputStream(srcFile));
                BufferedOutputStream bout = new BufferedOutputStream(
                        new FileOutputStream(new File(destDir, newFileName)));
                int b = 0, i = 0;
                while ((b = bin.read()) != -1) {
                    bout.write(b);
                    i++;
                }
                bout.flush();
                bin.close();
                bout.close();
                copySizes = i;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return copySizes;
    }

}
