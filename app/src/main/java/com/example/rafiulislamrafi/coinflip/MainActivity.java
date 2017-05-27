package com.example.rafiulislamrafi.coinflip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends Activity {

    Button flip_button;
    ImageView coin_image;

    Random random;

    int coinSide; //heads = 0, tails = 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objCast();
        buttonClick();
    }

    public void objCast() {

        flip_button = (Button) findViewById(R.id.flipButton);
        coin_image = (ImageView) findViewById(R.id.coinImage);

        random = new Random();
    }

    public void buttonClick() {

        flip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coinSide = random.nextInt(2);

                if (coinSide == 0) {
                    coin_image.setImageResource(R.drawable.coin1);
                } else if (coinSide == 1) {
                    coin_image.setImageResource(R.drawable.coin2);
                }

                RotateAnimation rotateAnimation = new RotateAnimation(0, 1000, RotateAnimation.RELATIVE_TO_SELF, .5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotateAnimation.setDuration(3000);
                coin_image.startAnimation(rotateAnimation);

            }
        });


    }
}

