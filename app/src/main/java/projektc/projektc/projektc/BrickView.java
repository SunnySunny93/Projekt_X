package projektc.projektc.projektc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by naqibfaizy on 22.11.17.
 * Diese Klasse repräsentiert die Bricks, die vom Ball in der BallView-Klasse getroffen werden.
 * Die Bricks lösen sich auf, wenn die oft genug vom Ball getroffen werden.
 */

/**
 * TODO 1. Baue giffs in Android ein (siehe dropbox-ordner von Peter Oetker)
 * TODO 2. Prüfe, ob der Hilfetext, falls er zu lang wird, sich runterscrollen lässt
 * TODO 3. Erzeuge einen Fullscreen (titlebar und bestenfalls navbar sollen verschwinden)
 */

public class BrickView extends View {


    //
    private int imageCount;
    // Instanzvariable rnd wird gebraucht, um die Bricks an zufälligen Stellen zu erstellen
    // TODO Ersetze rnd durch den oberen Bereich des Screens
    private Random rnd;
    private long randomSeed = 8;
    private Paint paint = new Paint();

    // Die Bricksbilder werden in einem Array abgespeichert
    private static final int[] images = {R.drawable.brick1, R.drawable.brick2,
            R.drawable.brick3, R.drawable.brick4,
            R.drawable.brick5, R.drawable.brick6,
            R.drawable.brick7, R.drawable.brick8};

    // Die gleichen Bricksbilder nur weniger
    private static final int[] images1 = {R.drawable.brick3, R.drawable.brick1,
            R.drawable.brick6, R.drawable.brick4};

    // Ein Bricksbild
    private int brick = R.drawable.brick1;

    private static final int[] images2 = {R.drawable.brick3, R.drawable.black, R.drawable.brick1,
            R.drawable.black, R.drawable.brick6, R.drawable.black, R.drawable.brick4};

    // Setze Anzahl der Bricksbilder zufällig verteilt auf dem Screen
    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
        randomSeed = System.currentTimeMillis();
        invalidate();
    }

    // ...
    public BrickView(Context context) {
        super(context);
        paint.setAntiAlias(true);
    }

    // Zeichnet die vierfarbigen Bricks in Reihe mit Abstände dazwischen
    /* getWidth liefert die Breite des Bildschirms: 768 */
    /* bitmap.getWidth liefert die Breite eines Bricks 128 */
    @Override
    protected void onDraw(Canvas canvas) {
        for(int image : images1) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), image);
            for (int j = 0; j < 1; j++) {
                for (int i = 0; i < 4; i++) {
                    bitmap = BitmapFactory.decodeResource(getResources(), images1[i]);
                    float left = (float) i * (bitmap.getWidth()+85);
                    float top = (float) j * bitmap.getHeight()+90;
                    canvas.drawBitmap(bitmap, left, top, paint);
                    float left1 = (float) i * (bitmap.getWidth()+85);
                    float top1 = (float) j * bitmap.getHeight()+275;
                    canvas.drawBitmap(bitmap, left1, top1, paint);
                    float left2 = (float) i * (bitmap.getWidth()+85);
                    float top2 = (float) j * bitmap.getHeight()+450;
                    canvas.drawBitmap(bitmap, left2, top2, paint);
                }
            }
            bitmap.recycle();
        }
    }

}


