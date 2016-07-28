package www.oshimygoshi.com.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends Activity
{

    EditText userpass;
    TextView forget_signup;
    oopsDatabaseAdapter obg;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        forget_signup=(TextView)findViewById(R.id.selectBothFS);
        userpass=(EditText)findViewById(R.id.loginet);
        obg=new oopsDatabaseAdapter(this);
        fs();
        }
    public  void fs()
    {
        String data=obg.getAllData();
        if(data.isEmpty())
        {

            forget_signup.setText("SignUP ?");

        }
        else
        {
            forget_signup.setText("Forget Password ?");
        }
    }
    public void SelectBoth(View view)
    {
       String checker;
        checker=forget_signup.getText().toString();
        String[] arr=checker.split("(?!^)");
        {
            if (arr[0]=="S")
            {
                Intent i=new Intent(this,signUp.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this,"heloo into forgte acitvity",Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void loginfun(View view)
    {
        String u_pass;
        u_pass=userpass.getText().toString();
        if(u_pass.isEmpty())
        {
            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            userpass.getText().clear();
        }
        else
        {
            String s1=userpass.getText().toString();
            obg.loginChecker(s1);
            Massage.massage(this, s1);
            Intent  intent=new Intent(this,MainActivity.class);
            startActivity(intent);


        }
    }
    public  void osh(View view)
    {
        String data=obg.getAllData();
        Massage.massage(this,data);
    }

}
