package alexhao.fun.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import alexhao.fun.R;
import alexhao.fun.View.CircleButton;

/**
 * Created by ALexHao on 15/6/25.
 * 注册成功弹出的界面
 */
public class RegisDialog extends Dialog {

    private TextView userid;
    private CircleButton okregis;
    private dialogClickListener dcl;
    private String s;

    public RegisDialog(Context context,String s) {
        super(context);
        this.s=s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regis_dialog);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = getContext().getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.8); // 高度设置为屏幕的0.5
        dialogWindow.setAttributes(lp);
        initViews();
        initEvents();

    }

    public void initViews()
    {
        userid= (TextView) findViewById(R.id.userid);
        okregis= (CircleButton) findViewById(R.id.okregis);
    }

    public void initEvents()
    {
        okregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dcl.confirm();
            }
        });

        this.userid.setText(s);
    }

    public interface dialogClickListener
    {
        public void confirm();
    }

    public void setOnDialogClickListener(dialogClickListener dcl)
    {
        this.dcl=dcl;
    }
}
