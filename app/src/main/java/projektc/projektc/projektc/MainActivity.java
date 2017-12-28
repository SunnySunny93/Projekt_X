package projektc.projektc.projektc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    // private static final int BALL_ID = 212121;
    // Instanz-Variablen für Punkte, Runde und Countdown
    // TODO Ersetze countdown durch Anzahl der Bälle
    private int points, round, countdown;

    // Instanz von BallView
    private ImageView ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGame();
        showStartFragment();
    }

    // Starte das Spiel neu
    private void newGame() {
        points=0;
        round=1;
        initRound();
    }

    // Setze den Countdown auf 10
    // BrickView wird erzeugt und in den Layout-Container gepackt
    // BallView wird erzeugt und in den Layout-Container gepackt
    private void initRound() {
        countdown=10;
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        container.removeAllViews();
        // Zeichne Bricks
        BrickView bv = new BrickView(this);
        container.addView(bv, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        bv.setImageCount(8*(10+round));
        // Zeichne Ball
        BallView ball = new BallView(this);
        container.addView(ball, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        ball.move();
        // Test
        //ball = new BallView(this);
        //ball.setId(BALL_ID);
        update();
    }

    // Fülle die TextViews anhand der id mit Text
    private void fillTextView(int id, String text) {
        TextView tv = (TextView) findViewById(id);
        tv.setText(text);
    }

    // Fülle alle drei TextViews mit den Instanzvariablen
    // TODO nochmal: countdown wird durch die Anzahl der Bälle ersetzt
    private void update() {
        fillTextView(R.id.points, Integer.toString(points));
        fillTextView(R.id.round, Integer.toString(round));
        fillTextView(R.id.countdown, Integer.toString(countdown*1000));
    }

    // Rufe Main_Activity mit fragment_start.xml auf
    private void showStartFragment() {
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.fragment_start, null));
        container.findViewById(R.id.start).setOnClickListener(this);
    }

    // Rufe den GameOverscreen auf
    private void showGameOverFragment() {
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        container.removeAllViews();
        container.addView(getLayoutInflater().inflate(R.layout.fragment_gameover, null));
        container.findViewById(R.id.play_again).setOnClickListener(this);
    }

    // Verarbeitet das Fingertippen auf dem Bildschirm
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.start) {
            startGame();
        } else if(view.getId()==R.id.play_again) {
            showStartFragment();
        } if(view.getId()==R.id.play_again) {
            startGame();
        }
    }

    // Startet das Spiel
    private void startGame() {
        newGame();
    }

}
