package alexhao.fun.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import java.io.IOException;
import java.util.HashMap;

import alexhao.fun.R;

public class PlayVideoActivity extends Activity implements SurfaceHolder.Callback

    {
        private String addr;
        private MediaPlayer mp;
        private SurfaceView sv;
        private ImageView img;
        private SurfaceHolder mSurfaceHolder;
        private Button btn;
        private Bitmap bitmap;
        private Handler handler;
        private ProgressBar progressBar;
        private SeekBar seekBar;
        private static int current;
        private int barMax,videoMax;
        private delayThread th1;
        private VideoThumbnailThread th;
        private PlayVideoThread th2;

        public void setVideoAddr(String addr)
        {
            this.addr=addr;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.requestWindowFeature(Window.FEATURE_NO_TITLE); //声明使用自定义标题
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            setContentView(R.layout.activity_playvideo);

        img = (ImageView) findViewById(R.id.imgpre);
        sv = (SurfaceView) findViewById(R.id.surface);
        btn = (Button) findViewById(R.id.btnplay);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
            addr=getIntent().getStringExtra("videoaddr");
            setVideoAddr(addr);
        mSurfaceHolder = sv.getHolder();
        mSurfaceHolder.addCallback(this);

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==1)
                    img.setImageBitmap(bitmap);
                if(msg.what==2)
                    seekBar.setProgress(current);
                if(msg.what==3)
                {
                    progressBar.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.GONE);
                    //    img.setVisibility(View.GONE);
                }
            }
        };

        th=new VideoThumbnailThread();
      //  th.start();

/*---------------------------播放视频按钮------------------------------*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //playVideo();
                th2=new PlayVideoThread();
                th2.start();
            }
        });


/*---------------------------seekbar----------------------------*/

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress=seekBar.getProgress();
                if(mp!=null)
                    mp.seekTo(progress);
            }
        });
    }
/*---------------------------surfaceview----------------------------*/
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

        @Override
        protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(th2);
        handler.removeCallbacks(th1);
        handler.removeCallbacks(th);
        if(mp!=null) {
            if (mp.isPlaying()) {
                mp.stop();
            }
            mp.release();
        }

    }


    /*---------------------------play播放---------------------------------*/
    public void playVideo()
    {
        mp=new MediaPlayer();
        mp.reset();
        try {
            Log.d("video",addr);
            mp.setDataSource(getApplicationContext(), Uri.parse(addr));
            mp.setDisplay(mSurfaceHolder);
            mp.prepare();
            mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mp.start();
                    progressBar.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.GONE);
                    seekBar.setMax(mp.getDuration());
                    barMax=seekBar.getMax();
                    videoMax=mp.getDuration();

                }
            });

         /*   mp.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                @Override
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                    if(mp.isPlaying())
                    progressBar.setVisibility(View.INVISIBLE);
                    else
                        progressBar.setVisibility(View.VISIBLE);
                }
            });*/

            th1=new delayThread();
            th1.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*---------------------------获取视频缩略图----------------------------*/
    private Bitmap createVideoThumbnail(String url, int width, int height) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else {
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime(2000);
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }
        if (kind == MediaStore.Images.Thumbnails.MICRO_KIND && bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, bitmap.getWidth(),
                    bitmap.getHeight(),
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
            return super.onKeyDown(keyCode, event);
        }

    public class delayThread extends Thread
    {
        @Override
        public void run() {
            super.run();
            while (mp!=null) {
                try {

                    sleep(500);
                    current = mp.getCurrentPosition();
                    Message msg = handler.obtainMessage(2);
                    msg.sendToTarget();

                }catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (IllegalStateException e)
                {
                    e.printStackTrace();
                }

            }
        }
    }

    public class VideoThumbnailThread extends Thread
    {
        @Override
        public void run() {
            super.run();
            bitmap=createVideoThumbnail(addr,300,200);
            Message msg= handler.obtainMessage(1);
            msg.sendToTarget();
        }
    }

    public class PlayVideoThread extends Thread
    {
        @Override
        public void run() {
            super.run();
            Message msg = handler.obtainMessage(3);
            msg.sendToTarget();
            playVideo();
        }
    }

}

