package co.damace.floatingactionbuttonmenudesplegable;

import android.animation.Animator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButtonContenedor, floatingActionButton1, floatingActionButton2, floatingActionButton3;
    private boolean floatingActionButtonContenedorAbierto = false;
    private LinearLayout linearLayoutFloating1, linearLayoutFloating2, linearLayoutFloating3;
    private View viewTransparenteBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutFloating1 = (LinearLayout) findViewById(R.id.linearLayoutFloating1);
        linearLayoutFloating2 = (LinearLayout) findViewById(R.id.linearLayoutFloating2);
        linearLayoutFloating3 = (LinearLayout) findViewById(R.id.linearLayoutFloating3);

        floatingActionButtonContenedor = (FloatingActionButton) findViewById(R.id.floatingActionButtonContenedor);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.floatingActionButton1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        viewTransparenteBackground = findViewById(R.id.viewTransparenteBackground);

        floatingActionButtonContenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!floatingActionButtonContenedorAbierto) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }
            }
        });

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Opción correo", Toast.LENGTH_LONG).show();
                closeFABMenu();
            }
        });

        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Opción cámara", Toast.LENGTH_LONG).show();
                closeFABMenu();
            }
        });

        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Opción microfono", Toast.LENGTH_LONG).show();
                closeFABMenu();

            }
        });

        viewTransparenteBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });

    }

    private void showFABMenu() {
        floatingActionButtonContenedorAbierto = true;
        linearLayoutFloating1.setVisibility(View.VISIBLE);
        linearLayoutFloating2.setVisibility(View.VISIBLE);
        linearLayoutFloating3.setVisibility(View.VISIBLE);
        viewTransparenteBackground.setVisibility(View.VISIBLE);

        floatingActionButtonContenedor.animate().rotationBy(180).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (floatingActionButtonContenedor.getRotation() != 180) {
                    floatingActionButtonContenedor.setRotation(180);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        linearLayoutFloating1.animate().translationY(-getResources().getDimension(R.dimen.distancia_fab1));
        linearLayoutFloating2.animate().translationY(-getResources().getDimension(R.dimen.distancia_fab2));
        linearLayoutFloating3.animate().translationY(-getResources().getDimension(R.dimen.distancia_fab3));
    }

    private void closeFABMenu() {
        floatingActionButtonContenedorAbierto = false;
        viewTransparenteBackground.setVisibility(View.GONE);
        floatingActionButtonContenedor.animate().rotationBy(-180);
        linearLayoutFloating1.animate().translationY(0);
        linearLayoutFloating2.animate().translationY(0);
        linearLayoutFloating3.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!floatingActionButtonContenedorAbierto) {
                    linearLayoutFloating1.setVisibility(View.GONE);
                    linearLayoutFloating2.setVisibility(View.GONE);
                    linearLayoutFloating3.setVisibility(View.GONE);
                }
                if (floatingActionButtonContenedor.getRotation() != -180) {
                    floatingActionButtonContenedor.setRotation(-180);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (floatingActionButtonContenedorAbierto) {
            closeFABMenu();
        } else {
            super.onBackPressed();
        }
    }
}
