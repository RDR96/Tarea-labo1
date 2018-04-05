package com.example.rodrigocorvera.clase3;

import android.content.res.XmlResourceParser;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public TextView firstElement;
    public TextView secondElement;
    public Puntaje puntajeA;
    public Puntaje puntajeB;
    public Puntaje partidos;
    public TextView thirdElement;
    public Puntaje juegoA;
    public Puntaje juegoB;
    public Puntaje set1A;
    public Puntaje set1B;
    public Puntaje set2A;
    public Puntaje set2B;
    public Puntaje set3A;
    public Puntaje set3B;
    public TextView totalA;
    public TextView totalB;
    public int counter;
    public int setsCounter;
    public TextView winner;
    public boolean deuce;
    public Button botonA;
    public Button botonB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstElement = findViewById(R.id.puntajeA);
        secondElement = findViewById(R.id.puntajeB);
        thirdElement = findViewById(R.id.contador_juegos);
        partidos = new Puntaje(thirdElement);
        puntajeB = new Puntaje(secondElement);
        puntajeA = new Puntaje(firstElement);
        juegoA = new Puntaje((TextView)findViewById(R.id.juegoA));
        juegoB = new Puntaje((TextView)findViewById(R.id.juegoB));
        set1A = new Puntaje((TextView)findViewById(R.id.set1A));
        set2A = new Puntaje((TextView)findViewById(R.id.set2A));
        set3A = new Puntaje((TextView)findViewById(R.id.set3A));
        set1B = new Puntaje((TextView)findViewById(R.id.set1B));
        set2B = new Puntaje((TextView)findViewById(R.id.set2B));
        set3B = new Puntaje((TextView)findViewById(R.id.set3B));
        totalA = findViewById(R.id.totalScoreA);
        totalB = findViewById(R.id.totalScoreB);
        winner = findViewById(R.id.winner);
        partidos.setTextoPuntaje("1");
        botonA = findViewById(R.id.botonA);
        botonB = findViewById(R.id.botonB);
        counter = 1;
        deuce = false;
        setsCounter = 0;
    }



    public void changeValue(View v){

        String value = v.getTag().toString();

        if(value.equals("1")){
            verificarPuntaje(value);
            //puntajeA.setText(String.valueOf(returnValue(counterA++)));
        }else{
            verificarPuntaje(value);
        }
    }


    public void verificarPuntaje(String value){

        if(value.equals("1")){
            puntajeA.increment();
            if( puntajeA.getCounter() < 4 ){
                puntajeA.setTextoPuntaje();
            }else if( puntajeA.getCounter() >= 4){
                if(!deuce){
                    if(Math.abs((puntajeA.getCounter()-1)-puntajeB.getCounter()) >= 1){
                        puntajeA.setTextoPuntajeToCero();
                        puntajeA.setCounter(0);
                        puntajeB.setTextoPuntajeToCero();
                        puntajeB.setCounter(0);
                        /*partidos.setTextoPuntaje(String.valueOf(++counter));
                        juegoA.setTextoPuntaje(String.valueOf(juegoA.incrementAux()));*/
                        if( partidos.getNumberPuntaje() < 6 ){
                            partidos.setTextoPuntaje(String.valueOf(++counter));
                            juegoA.setTextoPuntaje(String.valueOf(juegoA.incrementAux()));
                        }else{
                            juegoA.setTextoPuntaje(String.valueOf(juegoA.incrementAux()));
                            sets();
                            resetValues();
                        }
                    }else if(Math.abs((puntajeA.getCounter()-1) - puntajeB.getCounter()) == 0){
                        puntajeA.setAuxToCero();
                        puntajeB.setAuxToCero();
                        setExtra(value);
                        deuce = true;
                    }
                }else{
                       setExtra(value);
                }


            }
        }else{
            puntajeB.increment();
            if( puntajeB.getCounter() < 4 ){
                puntajeB.setTextoPuntaje();
            }else if( puntajeB.getCounter() >= 4){
                if(!deuce) {
                    if (Math.abs((puntajeB.getCounter() - 1) - puntajeA.getCounter()) >= 1) {
                        puntajeA.setTextoPuntajeToCero();
                        puntajeA.setCounter(0);
                        puntajeB.setTextoPuntajeToCero();
                        puntajeB.setCounter(0);
                        if (partidos.getNumberPuntaje() < 6) {
                            partidos.setTextoPuntaje(String.valueOf(++counter));
                            juegoB.setTextoPuntaje(String.valueOf(juegoB.incrementAux()));
                        } else {
                            juegoB.setTextoPuntaje(String.valueOf(juegoB.incrementAux()));
                            sets();
                            resetValues();
                        }

                    } else if (Math.abs((puntajeB.getCounter() - 1) - puntajeA.getCounter()) == 0) {
                        puntajeA.setAuxToCero();
                        puntajeB.setAuxToCero();
                        setExtra(value);
                        deuce = true;
                    }
                }else{
                    setExtra(value);
                }
            }
        }

    }


    public void setExtra(String value){

        System.out.println("El valor es: " + value);
        System.out.println(value.equals('1'));
        if(value.equals("1")){
            if( puntajeB.getExtraCounter() == 0 ){
                puntajeA.incrementExtra();
                if(puntajeA.getExtraCounter() == 1){
                    puntajeA.setTextoPuntaje(puntajeA.stringValue());
                }else{
                    puntajeB.setTextoPuntajeToCero();
                    puntajeA.setTextoPuntajeToCero();
                    puntajeA.setCounter(0);
                    puntajeB.setCounter(0);
                    puntajeA.setExtraCounter(0);
                    puntajeB.setExtraCounter(0);
                    //sets();
                    //resetValues();
                    deuce = false;
                    if (partidos.getNumberPuntaje() < 6) {
                        partidos.setTextoPuntaje(String.valueOf(++counter));
                        juegoA.setTextoPuntaje(String.valueOf(juegoA.incrementAux()));
                    } else {
                        juegoA.setTextoPuntaje(String.valueOf(juegoA.incrementAux()));
                        sets();
                        resetValues();
                    }
                }


            }else{
                puntajeB.setCounter(3);
                puntajeB.setTextoPuntaje();
                puntajeB.setExtraCounter(0);

            }
        }else{
            if( puntajeA.getExtraCounter() == 0 ){
                puntajeB.incrementExtra();

                if(puntajeB.getExtraCounter() == 1){
                    puntajeB.setTextoPuntaje(puntajeB.stringValue());
                }else{
                    puntajeB.setTextoPuntajeToCero();
                    puntajeA.setTextoPuntajeToCero();
                    puntajeA.setCounter(0);
                    puntajeB.setCounter(0);
                    puntajeA.setExtraCounter(0);
                    puntajeB.setExtraCounter(0);
                    //sets();
                    //resetValues();
                    deuce = false;
                    if (partidos.getNumberPuntaje() < 6) {
                        partidos.setTextoPuntaje(String.valueOf(++counter));
                        juegoB.setTextoPuntaje(String.valueOf(juegoB.incrementAux()));
                    } else {
                        juegoB.setTextoPuntaje(String.valueOf(juegoB.incrementAux()));
                        sets();
                        resetValues();
                    }
                }
            }else{
                puntajeA.setCounter(3);
                puntajeA.setTextoPuntaje();
                puntajeA.setExtraCounter(0);
            }
        }

    }

    public void sets(){

        switch (setsCounter){
            case 0:
                set1A.setTextoPuntaje(String.valueOf(juegoA.getNumberPuntaje()));
                set1B.setTextoPuntaje(String.valueOf(juegoB.getNumberPuntaje()));
                setsCounter++;
                break;

            case 1:
                set2A.setTextoPuntaje(String.valueOf(juegoA.getNumberPuntaje()));
                set2B.setTextoPuntaje(String.valueOf(juegoB.getNumberPuntaje()));
                setsCounter++;
                break;

            case 2:
                set3A.setTextoPuntaje(String.valueOf(juegoA.getNumberPuntaje()));
                set3B.setTextoPuntaje(String.valueOf(juegoB.getNumberPuntaje()));
                setWinner();
                setsCounter++;
                break;

        }
        totalSets();
    }

    public void resetValues(){
        partidos.setTextoPuntajeToCero();
        juegoB.setTextoPuntajeToCero();
        juegoA.setTextoPuntajeToCero();
        juegoB.setAuxToCero();
        juegoA.setAuxToCero();
        counter = 1;
    }

    public void totalSets(){
        totalA.setText(String.valueOf(set1A.getNumberPuntaje()+set2A.getNumberPuntaje()+set3A.getNumberPuntaje()));
        totalB.setText(String.valueOf(set1B.getNumberPuntaje()+set2B.getNumberPuntaje()+set3B.getNumberPuntaje()));
    }

    public void setWinner(){
        if( Integer.parseInt(totalA.getText().toString()) > Integer.parseInt(totalB.getText().toString())){
            winner.setText("A");
        }else{
            winner.setText("B");
        }
        botonA.setEnabled(false);
        botonB.setEnabled(false);
    }
}