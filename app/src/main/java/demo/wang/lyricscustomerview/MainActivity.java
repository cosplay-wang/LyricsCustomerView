package demo.wang.lyricscustomerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> stringList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LyricsView lyricsView = new LyricsView(this);
        setData();
        lyricsView.setData(stringList);
        setContentView(lyricsView);
    }
    private void setData(){
            stringList.add("故事的小黄花 ");
            stringList.add("从出生那飘着 ");
            stringList.add("童年的荡秋千   ");
            stringList.add("随记忆一直晃到现在 ");
            stringList.add("rui sou sou xi dou xi la \n" +
                    "sou la xi xi xi xi la xi la sou \n" +
                    "吹着前奏望着天空 \n" +
                    "我想起花瓣试着掉落 \n" +
                    "为你翘课的那一天 \n" +
                    "花落的那一天 ");
            stringList.add("教室的那一间  ");

    }
}
