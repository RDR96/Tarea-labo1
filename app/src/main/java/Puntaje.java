import android.widget.TextView;

/**
 * Created by Rodrigo Corvera on 24/3/2018.
 */

public class Puntaje {

    private TextView textoPuntaje;
    private int numeroPuntaje;
    private int counter;
    private int auxC;

    public Puntaje(TextView texto){
        textoPuntaje = texto;
        numeroPuntaje = Integer.parseInt(textoPuntaje.getText().toString());
        counter = 0;
    }

    public TextView getTextoPuntaje(){
        return this.textoPuntaje;
    }

    public int getNumeroPuntaje(){

        return numeroPuntaje;
    }

    public int getCounter(){
        return counter;
    }

    public void setTextoPuntaje(){
        textoPuntaje.setText(String.valueOf(returningValue()));
    }

    public void setTextoPuntajeToCero(){
        textoPuntaje.setText(String.valueOf("0"));
    }

    public void increment(){
        counter++;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }



    public int returningValue(){
        if(counter == 1){
            return 15;
        }else if(counter == 2){
            return  30;
        }else if(counter == 3){
            return 40;
        }else if(counter == 4){
            return 0;
        }else{
            return 0;
        }
    }

    public int incrementAux(){
        return ++auxC;
    }

    public void setAuxToCero(){
        auxC = 0;
    }

}
