package alexhao.fun.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

import alexhao.fun.Libs.photoview.PhotoView;
import alexhao.fun.Libs.photoview.PhotoViewAttacher;
import alexhao.fun.R;

public class BigPicActivity extends Activity {

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
    String picaddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //声明使用自定义标题
        setContentView(R.layout.activity_bigpic);
        picaddr=getIntent().getStringExtra("picaddr");
        setBigPic(picaddr);
        initViews();
        spf= getSharedPreferences("PicConfig", Context.MODE_PRIVATE);
        editor= spf.edit();

        if(spf.getString("init_success","0")=="0"){
            initPicConfig();}

        displayImageOptions();
        showBigPic();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        return super.onKeyDown(keyCode, event);
    }


    public void initViews()
    {
        img= (PhotoView)findViewById(R.id.bigpic1);
        bigpiclayout= (RelativeLayout)findViewById(R.id.bigpiclayout);
    }


    public void setBigPic(String url)
    {
        this.url=url;
    }

    public void showBigPic()
    {

        imageLoader.getInstance().displayImage(url,img,options);

        mAttacher = new PhotoViewAttacher(img);
        mAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        mAttacher.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                srcDir = imageLoader.getInstance().getDiscCache().get(url).getPath();
                srcFile = new File(srcDir);
                destFile = new File(Destdir);

                int n=spf.getInt("picid",0);
                newFileName=String.valueOf(n)+".jpg";
                editor.putInt("picid",n+1);
                editor.commit();
                copyFile(srcFile, destFile, newFileName);
                Toast toast = Toast.makeText(getApplicationContext(),"已保存图片", Toast.LENGTH_SHORT);
                toast.show();
                return true;

            }

        });

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

    public void initPicConfig() {

        editor.putString("init_success", "1"); //第一次执行 判断
        editor.putInt("picid",0);
        editor.commit();
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
