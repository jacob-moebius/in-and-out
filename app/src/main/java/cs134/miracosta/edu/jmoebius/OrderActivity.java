package cs134.miracosta.edu.jmoebius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.jmoebius.model.Order;

/**
 * Main Activity that is launched when the app launches. Contains the menu and editText fields for
 * ordering items off the menu as well as a Button to submit the order.
 *
 * @author Jacob Moebius
 */
public class OrderActivity extends AppCompatActivity {

    // Instance variables to connect Controller with the View
    private EditText doubleDoubleQuantityEditText;
    private EditText cheeseburgerQuantityEditText;
    private EditText frenchFriesQuantityEditText;
    private EditText shakesQuantityEditText;
    private EditText smallDrinksQuantityEditText;
    private EditText mediumDrinksQuantityEditText;
    private EditText largeDrinksQuantityEditText;
    private TextView doubleDoublePriceTextView;
    private TextView cheeseburgerPriceTextView;
    private TextView frenchFriesPriceTextView;
    private TextView shakesPriceTextView;
    private TextView smallDrinksPriceTextView;
    private TextView mediumDrinksPriceTextView;
    private TextView largeDrinksPriceTextView;
    private Order order;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Wire up Views
        doubleDoubleQuantityEditText = findViewById(R.id.doubleDoubleQuantityEditText);
        cheeseburgerQuantityEditText = findViewById(R.id.cheeseburgerQuantityEditText);
        frenchFriesQuantityEditText = findViewById(R.id.frenchFriesQuantityEditText);
        shakesQuantityEditText = findViewById(R.id.shakesQuantityEditText);
        smallDrinksQuantityEditText = findViewById(R.id.smallDrinksQuantityEditText);
        mediumDrinksQuantityEditText = findViewById(R.id.mediumDrinksQuantityEditText);
        largeDrinksQuantityEditText = findViewById(R.id.largeDrinksQuantityEditText);

        doubleDoublePriceTextView = findViewById(R.id.doubleDoublePriceTextView);
        cheeseburgerPriceTextView = findViewById(R.id.cheeseburgerPriceTextView);
        frenchFriesPriceTextView = findViewById(R.id.frenchFriesPriceTextView);
        shakesPriceTextView = findViewById(R.id.shakesPriceTextView);
        smallDrinksPriceTextView = findViewById(R.id.smallDrinksPriceTextView);
        mediumDrinksPriceTextView = findViewById(R.id.mediumDrinksPriceTextView);
        largeDrinksPriceTextView = findViewById(R.id.largeDrinksPriceTextView);

        order = new Order();
        doubleDoublePriceTextView.setText(currency.format(Order.PRICE_DOUBLE_DOUBLE));
        cheeseburgerPriceTextView.setText(currency.format(Order.PRICE_CHEESEBURGER));
        frenchFriesPriceTextView.setText(currency.format(Order.PRICE_FRENCH_FRIES));
        shakesPriceTextView.setText(currency.format(Order.PRICE_SHAKES));
        smallDrinksPriceTextView.setText(currency.format(Order.PRICE_DRINK_SMALL));
        mediumDrinksPriceTextView.setText(currency.format(Order.PRICE_DRINK_MEDIUM));
        largeDrinksPriceTextView.setText(currency.format(Order.PRICE_DRINK_LARGE));
    }

    /**
     * onClick() method for placeOrderButton. Builds an Intent and fires it to start the
     * SummaryActivity, which will show the cost of the order.
     *
     * @param v     View that was clicked
     */
    public void placeOrder(View v) {

        int doubleDoubleQuantity,
            cheeseburgerQuantity,
            frenchFriesQuantity,
            shakesQuantity,
            smallDrinksQuantity,
            mediumDrinksQuantity,
            largeDrinksQuantity;

        // Use try-catch blocks to handle empty editText entries where the user did not order items
        try {
            doubleDoubleQuantity =
                    Integer.parseInt(doubleDoubleQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            doubleDoubleQuantity = 0;
        }
        try {
            cheeseburgerQuantity =
                    Integer.parseInt(cheeseburgerQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            cheeseburgerQuantity = 0;
        }
        try {
            frenchFriesQuantity =
                    Integer.parseInt(frenchFriesQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            frenchFriesQuantity = 0;
        }
        try {
            shakesQuantity =
                    Integer.parseInt(shakesQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            shakesQuantity = 0;
        }
        try {
            smallDrinksQuantity =
                    Integer.parseInt(smallDrinksQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            smallDrinksQuantity = 0;
        }
        try {
            mediumDrinksQuantity =
                    Integer.parseInt(mediumDrinksQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            mediumDrinksQuantity = 0;
        }
        try {
            largeDrinksQuantity =
                    Integer.parseInt(largeDrinksQuantityEditText.getText().toString());
        } catch (NumberFormatException e) {
            largeDrinksQuantity = 0;
        }

        // Initiate intent and navigate to order summary activity
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("DoubleDoubleQuantity", doubleDoubleQuantity);
        intent.putExtra("CheeseburgerQuantity", cheeseburgerQuantity);
        intent.putExtra("FrenchFriesQuantity", frenchFriesQuantity);
        intent.putExtra("ShakesQuantity", shakesQuantity);
        intent.putExtra("SmallDrinksQuantity", smallDrinksQuantity);
        intent.putExtra("MediumDrinksQuantity", mediumDrinksQuantity);
        intent.putExtra("LargeDrinksQuantity", largeDrinksQuantity);

        // Fire Intent
        startActivity(intent);
    }
}
