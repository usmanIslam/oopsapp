package www.oshimygoshi.com.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class signUp  extends Activity
{
    protected EditText name,pass;
    oopsDatabaseAdapter oopsDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        oopsDatabase=new oopsDatabaseAdapter(this);
        name=(EditText)findViewById(R.id.signUpName);
        pass=(EditText)findViewById(R.id.signUpPass);

    }

        public void addUser(View view)
        {
            String user,password;
            user=name.getText().toString();
            password=pass.getText().toString();
            if(user.isEmpty()||password.isEmpty())
            {
                Toast.makeText(this,"Please Enter Name & Password Carefully",Toast.LENGTH_LONG).show();
            }
            else
            {
                long id=oopsDatabase.insertData(user,password);
                if (id<0)
                {
                    Toast.makeText(this,"Please Enter Again Data",Toast.LENGTH_SHORT).show();
                    name.getText().clear();
                    pass.getText().clear();
                }
                else
                {
                    Toast.makeText(this, "You are resgisterd Now", Toast.LENGTH_SHORT).show();
                    name.getText().clear();
                    pass.getText().clear();
                    Intent i=new Intent(this,MainActivity.class);
                    startActivity(i);
                }


            }

        }

}
