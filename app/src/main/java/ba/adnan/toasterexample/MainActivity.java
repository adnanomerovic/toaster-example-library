package ba.adnan.toasterexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ba.adnan.toasterlibrary.ToasterMessage;
import io.reactivex.Completable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToasterMessage.toastShortMessage(getApplicationContext(), "Library works fine!");

        ToasterMessage.delayToastMessage(
                MainActivity.this,
                "Delay toast",
                5,
                TimeUnit.SECONDS
        ).subscribe();

        Completable.complete().delay(3, TimeUnit.SECONDS).andThen(
                Completable.fromAction(() -> {
                    runOnUiThread(() -> ToasterMessage.toastShortMessage(getApplicationContext(), "message"));
                })).subscribe();

    }
}