package ba.adnan.toasterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ba.adnan.toasterlibrary.ToasterMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToasterMessage.toastShortMessage(getApplicationContext(),"Library works fine!");
    }
}