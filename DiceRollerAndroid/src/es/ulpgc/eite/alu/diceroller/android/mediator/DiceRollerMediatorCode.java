package es.ulpgc.eite.alu.diceroller.android.mediator;

import es.ulpgc.eite.framework.core.mediator.MediatorCode;

/**
 * Clase que contiene los codigos de los que hace uso la aplicacion para varias operaciones
 */
public class DiceRollerMediatorCode extends MediatorCode{
    /**
     * Codigo para un clic de la pantalla principal. Sin transicion asociada
     */
    public final static int CLICK = 900;
    /**
     * Codigo para pasar de pantalla principal a vista maestro
     */
    public final static int LISTA = 901;
    /**
     * Codigo para pasar de la vista maestro a una vista detalle determinada
     */
    public final static int SELECT = 800;
    /**
     * Codigo para eliminar la vista detalle de un elemento y a dicho elemento de la lista maestro
     */
    public static final int DELETE = 801;
}
