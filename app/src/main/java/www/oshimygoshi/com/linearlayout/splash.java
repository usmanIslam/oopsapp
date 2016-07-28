package www.oshimygoshi.com.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        final ImageView imageView=(ImageView)findViewById(R.id.simg);
        final Animation obg= AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade);

        imageView.startAnimation(obg);
        obg.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent i=new Intent(splash.this,Login_Activity.class);
                startActivity(i);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}

