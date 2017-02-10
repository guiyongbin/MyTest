package test.mytest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int MSG_UPDATE_SYSTEM_TIME = 1;
    private TextView mTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTime = (TextView) findViewById(R.id.time);
        startUpdateSystemTime();

        Toast.makeText(MainActivity.this,"修改",Toast.LENGTH_SHORT).show();


    }
 private Handler mHandler = new Handler(){
     @Override
     public void handleMessage(Message msg) {
         super.handleMessage(msg);
         switch(msg.what){
             case MSG_UPDATE_SYSTEM_TIME:
                    startUpdateSystemTime();
                 break;



         }
     }
 };

    private void startUpdateSystemTime() {
//        logE("VideoPlayerActivity.startUpdateSystemTime,time="+System.currentTimeMillis());
        mTime.setText(formatSystemTime());

        // 发送延迟消息
        mHandler.sendEmptyMessageDelayed(MSG_UPDATE_SYSTEM_TIME,500);
    }

        // 将系统时间转换为 01:02:03
        public static String formatSystemTime(){
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            return format.format(new Date());
        }






}