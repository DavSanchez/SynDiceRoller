package es.ulpgc.eite.alu.diceroller.android.main_screen.view;

import android.annotation.TargetApi;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.TextView;
import es.ulpgc.eite.alu.diceroller.android.R;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class es.ulpgc.eite.alu.diceroller.android.main_screen.view.DiceRollerViewTest \
 * es.ulpgc.eite.alu.diceroller.android.tests/android.test.InstrumentationTestRunner
 */
@TargetApi(8)
public class DiceRollerViewTest extends ActivityInstrumentationTestCase2<DiceRollerView> {

    public DiceRollerViewTest() {
        super(DiceRollerView.class);
    }

    private DiceRollerView mVista;

    private Button mButtond2;
    private Button mButtond3;
    private Button mButtond4;
    private Button mButtond6;
    private Button mButtond8;
    private Button mButtond10;
    private Button mButtond12;
    private Button mButtond20;
    private Button mButtond24;
    private Button mButtond100;

    private Button mButtonListaTiradas;

    private TextView mDisplay;

    @Override
    protected void setUp() throws Exception {
        super.setUp(); // required by JUnit
		/*
		 * prepare to send key events to the app under test by turning off touch mode.
		 * Must be done before the first call to getActivity()
		 */

        setActivityInitialTouchMode(false);

		/*
		 * Start the app under test by starting its main activity. The test runner already knows
		 * which activity this is from the call to the super constructor, as mentioned
		 * previously. The tests can now use instrumentation to directly access the main
		 * activity through mActivity.
		 */
        mVista = getActivity();

        mButtond2 = (Button) mVista.findViewById(R.id.buttond2);
        mButtond3 = (Button) mVista.findViewById(R.id.buttond3);
        mButtond4 = (Button) mVista.findViewById(R.id.buttond4);
        mButtond6 = (Button) mVista.findViewById(R.id.buttond6);
        mButtond8 = (Button) mVista.findViewById(R.id.buttond8);
        mButtond10 = (Button) mVista.findViewById(R.id.buttond10);
        mButtond12 = (Button) mVista.findViewById(R.id.buttond12);
        mButtond20 = (Button) mVista.findViewById(R.id.buttond20);
        mButtond24 = (Button) mVista.findViewById(R.id.buttond24);
        mButtond100 = (Button) mVista.findViewById(R.id.buttond100);

        mButtonListaTiradas = (Button) mVista.findViewById(R.id.buttonListaTiradas);
        mDisplay = (TextView) mVista.findViewById(R.id.numberRolled);
    }

    @UiThreadTest
    public void testInicio() {
        assertEquals("", mDisplay.getText().toString());
    }

    @UiThreadTest
    public void testTiradad2() {
        mButtond2.performClick();
        int result = Integer.parseInt(mDisplay.getText().toString());
        assertTrue(result <= 2 && result >= 1);
    }

    @UiThreadTest
    public void testTiradad3() {
        mButtond3.performClick();
        int result = Integer.parseInt(mDisplay.getText().toString());
        assertTrue(result <= 3 && result >= 1);
    }

    @UiThreadTest
    public void testTiradad4() {
        mButtond4.performClick();
        int result = Integer.parseInt(mDisplay.getText().toString());
        assertTrue(result <= 4 && result >= 1);
    }

    @UiThreadTest
    public void testTiradad6() {
        mButtond6.performClick();
        int result = Integer.parseInt(mDisplay.getText().toString());
        assertTrue(result <= 6 && result >= 1);
    }

}

