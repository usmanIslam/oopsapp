package www.oshimygoshi.com.linearlayout;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Type;
import java.util.Hashtable;

/**
 * Created by cyber on 6/23/2016.
 */
public class icon_manager
{
    private static Hashtable<String,Typeface> chached_icon=new Hashtable<>();

    public static Typeface get_icons(String path,Context context)
    {

        Typeface icon=chached_icon.get(path);
        if (icon==null)
        {
            icon=Typeface.createFromAsset(context.getAssets(),path);
            chached_icon.put(path,icon);

        }
        return icon;
    }
}
