package itupos.fit.cz.itupos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by oldo on 4.12.17.
 */


public class SwipeDetector extends GestureDetector.SimpleOnGestureListener {
    LoginActivity loginActivity;
    public SwipeDetector(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    private static final int MIN_DISTANCE = 100;
    private static final int MAX_OFF_PATH = 200;
    private static final int THRESHOLD_VELOCITY = 100;
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1 != null && e2 != null) {
            float dy = e1.getY() - e2.getY();
            float dx = e1.getX() - e2.getX();

            // Right to Left swipe
            if (dx > MIN_DISTANCE && Math.abs(dy) < MAX_OFF_PATH &&
                    Math.abs(velocityX) > THRESHOLD_VELOCITY) {
                // Add code to change activity
                return true;
            }

            // Left to right swipe
            else if (-dx > MIN_DISTANCE && Math.abs(dy) < MAX_OFF_PATH &&
                    Math.abs(velocityX) > THRESHOLD_VELOCITY) {
                // Below is sample code to show left to right swipe while launching next activity
                Intent intent = new Intent(loginActivity, TablesActivity.class);
                loginActivity.startActivity(intent);
                return true;
            }
        }
        return false;
    }
}