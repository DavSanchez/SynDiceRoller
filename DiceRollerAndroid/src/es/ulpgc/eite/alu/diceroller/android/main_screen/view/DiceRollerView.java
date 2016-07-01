package es.ulpgc.eite.alu.diceroller.android.main_screen.view;

import android.view.View;
import android.widget.TextView;
import es.ulpgc.eite.alu.diceroller.android.R;
import es.ulpgc.eite.alu.diceroller.android.main_screen.presenter.I_DiceRollerPresenter;
import es.ulpgc.eite.framework.android.AndroidScreenView;

public class DiceRollerView extends AndroidScreenView implements I_DiceRollerView, View.OnClickListener {

    private I_DiceRollerPresenter getDiceRollerPresenter(){
        return (I_DiceRollerPresenter) getScreenPresenter();
    }

    /**
     * Obtiene el identificador del layout de la pantalla principal
     *
     * @return el identificador del layout de la pantalla principal
     */
    @Override
    public int getDiceRollerLayout() {
        return R.layout.diceroller_main_view;
    }

    /**
     * Inicia la pantalla principal cargando el layout y los listeners de los botones
     */
    @Override
    public void initDiceRoller() {
        debug("initDiceRoller");

        setContentView(getDiceRollerLayout());
        setDiceRollerButtons();
    }

    /**
     * Llama al registerListener para cada boton de la pantalla principal
     */
    private void setDiceRollerButtons() {

        registerListener(R.id.buttond2);
        registerListener(R.id.buttond3);
        registerListener(R.id.buttond4);
        registerListener(R.id.buttond6);
        registerListener(R.id.buttond8);
        registerListener(R.id.buttond10);
        registerListener(R.id.buttond12);
        registerListener(R.id.buttond20);
        registerListener(R.id.buttond24);
        registerListener(R.id.buttond100);

        registerListener(R.id.buttonListaTiradas);
    }

    /**
     * Habilita el listener para un boton determinado
     *
     * @param btnId el identificador del boton
     */
    private void registerListener(int btnId) {

        View btn = findViewById(btnId);

        if (btn != null) {
            btn.setOnClickListener(this);
        } else {
            debug("registerListener", "error", "resource not available");
        }
    }

    /**
     * Especifica la accion a realizar al pulsar cada boton
     * <p>
     *     Para los botones de dado llama al metodo getNumeroCaras() y usa
     *     el retorno de este metodo como parametro del metodo dicePressed()
     *     del presentador. Para el boton de Lista llama al metodo
     *     botonListaPressed() del presentador
     *
     * @param btn el boton pulsado
     */
    @Override
    public void onClick(View btn) {
        debug("onClick");

        int caras = btn.getId();

        switch (caras) {
            case R.id.buttond2:
            case R.id.buttond3:
            case R.id.buttond4:
            case R.id.buttond6:
            case R.id.buttond8:
            case R.id.buttond10:
            case R.id.buttond12:
            case R.id.buttond20:
            case R.id.buttond24:
            case R.id.buttond100:
                int carasDado = getNumeroCaras(btn);
                debug("onClick", "", carasDado);
                getDiceRollerPresenter().dicePressed(carasDado);
                break;

            case R.id.buttonListaTiradas:
                debug("onClick");
                getDiceRollerPresenter().botonListaPressed();
                break;
        }
    }

    /**
     * Obtiene el numero de caras de un boton de dado en forma de numero entero
     *
     * @param btn el identificador del boton del dado
     *
     * @return el numero entero correspondiente a las caras del dado
     */
    private int getNumeroCaras(View btn) {
        int caras = btn.getId();
        switch (caras) {
            case R.id.buttond2:
                caras=2;
                break;
            case R.id.buttond3:
                caras=3;
                break;
            case R.id.buttond4:
                caras=4;
                break;
            case R.id.buttond6:
                caras=6;
                break;
            case R.id.buttond8:
                caras=8;
                break;
            case R.id.buttond10:
                caras=10;
                break;
            case R.id.buttond12:
                caras=12;
                break;
            case R.id.buttond20:
                caras=20;
                break;
            case R.id.buttond24:
                caras=24;
                break;
            case R.id.buttond100:
                caras=100;
                break;
        }
        return caras;
    }

    /**
     * Muestra en la pantalla del dispositivo el numero indicado
     *
     * @param numeroPantalla el numero entero en una variable String
     */
    @Override
    public void display(String numeroPantalla) {
        debug ("display", "numeroPantalla", numeroPantalla);
        TextView display = (TextView) findViewById(R.id.numberRolled);
        display.setText(numeroPantalla);
    }
}
