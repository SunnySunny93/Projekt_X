package projektc.projektc.projektc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by naqibfaizy on 13.12.17.
 * Diese Klasse repräsentiert den Ball.
 * Der Ball fliegt nach oben und soll von den Wänden abprallen.
 * Der Ball zerstört zudem die Bridges.
 */

public class BallView extends View implements View.OnClickListener{

    // Ballrichtung in x und y
    private float xdir;
    private float ydir;

    //
    float x;
    float y;

    //
    float i_width;

    //
    public static final float INIT_BALL_X = 230f;
    public static final float INIT_BALL_Y = 355f;

    //
    public static final int WIDTH = 300;
    //public static final int HEIGTH = 400;

    // Ball wird geladen
    private int ballImage = R.drawable.ball3;

    private Paint paint = new Paint();

    private Bitmap bitmap;

    // Prüft ob Ball mit den Fingern berührt wird
    private boolean isBallTouched = false;

    public BallView(Context context) {
        super(context);
    }

    /*public Ball() {

        xdir = 1;
        ydir = -1;

        ImageIcon ii = new ImageIcon("ball.png");
        image = ii.getImage();

        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);

        resetState();
    }*/

    private void resetState() {

        x = INIT_BALL_X;
        y = INIT_BALL_Y;
    }

    public void setXDir(float x) {
        xdir = x;
    }

    public void setYDir(float y) {
        ydir = y;
    }

    public float getYDir() {
        return ydir;
    }

    /*public void move() {

        x += xdir;
        y += ydir;

        if (x == 0) {
            setXDir(1);
        }

        if (x == WIDTH - i_width) {
            setXDir(-1);
        }

        if (y == 0) {
            setYDir(1);
        }
    }*/

    // Zeichnet den Ball unten mittig
    @Override
    protected void onDraw(Canvas canvas) {
            bitmap = BitmapFactory.decodeResource(getResources(), ballImage);
            float left = (float) bitmap.getWidth()+300;
            float top = (float) bitmap.getHeight()+1040;
            canvas.drawBitmap(bitmap, left, top, paint);
            bitmap.recycle();
    }

    // Lässt den Ball moven
    public void move() {
        x += xdir;
        y += ydir;

        if (x == 0) {
            setXDir(1);
        }

        if (x == WIDTH - i_width) {
            setXDir(-1);
        }

        if (y == 0) {
            setYDir(1);
        }
    }

    // Prüft das Fingertippen auf dem Screen
    @Override
    public void onClick(View view) {
        if(true) {
            move();
        }
    }

    // neuer Code

}
