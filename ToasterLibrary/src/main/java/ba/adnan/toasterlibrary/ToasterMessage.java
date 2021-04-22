package ba.adnan.toasterlibrary;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;


public class ToasterMessage {
    public static void toastShortMessage(Context c, String message) {
        Toast.makeText(c, message, Toast.LENGTH_SHORT).show();
    }

    public static void toastLongMessage(Context c, String message) {
        Toast.makeText(c, message, Toast.LENGTH_LONG).show();
    }

    public static Completable delayToastMessage(Activity activity, String message, long delay, TimeUnit timeunit) {
        return Completable.complete().delay(delay, timeunit).andThen(
                Completable.fromAction(() -> {
                    activity.runOnUiThread(() -> ToasterMessage.toastShortMessage(activity, message));
                })
        );

    }
}
