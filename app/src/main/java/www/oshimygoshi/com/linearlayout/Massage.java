package www.oshimygoshi.com.linearlayout;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by cyber on 7/3/2016.
 */
public class Massage
{
    public static void massage(Context context,String massage)

    {
        Toast.makeText(context,massage,Toast.LENGTH_LONG).show();
    }
}
