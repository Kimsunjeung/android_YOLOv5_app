package org.pytorch.demo.objectdetection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

//class SplashActivity : AppCompatActivity() {
//    var handler: Handler = Handler()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState);
//        handler.postDelayed(Runnable{
//var intent: Intent = Intent(applicationContext, MainActivity::class.java)
//        startActivity(intent)
//        finish();
//}, 1000)
//    }
//}

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
