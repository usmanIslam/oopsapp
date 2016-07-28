package www.oshimygoshi.com.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    icon_manager obg;//this object of font owsum class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        font_owsum();

    }

    public void font_owsum()
    {
        obg=new icon_manager();
        ((Button)findViewById(R.id.fbbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.gmailbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.skypebtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.twitterbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.unibtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.cloudbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.yahoobtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.windowbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.soundcloudbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.instabtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.tumblrbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));
        ((Button)findViewById(R.id.plusbtn)).setTypeface(obg.get_icons("fonts/fontawesome-webfont.ttf",this));

    }
}
