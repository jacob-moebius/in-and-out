package cs134.miracosta.edu.jmoebius;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.jmoebius.model.Order;

/**
 * Summary Activity contains the information of the order: number of items purchased, the subtotal,
 * the taxed amount, and the total. Also has a Button to allow the user to go back to the Order
 * Activity to start a new order.
 *
 * @author Jacob Moebius
 */
public class SummaryActivity extends AppCompatActivity {

    // Instance variables to connect Controller with the View
    private Order order;
    private TextView orderTotalTextView;
    private TextView itemsOrderedTextView;
    private TextView subtotalTextView;
    private TextView taxRateTextView;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private NumberFormat percent = NumberFormat.getPercentInstance(Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Extract data from the OrderActivity via Intent
        int doubleDoubleQuantity,
                cheeseburgerQuantity,
                frenchFriesQuantity,
                shakesQuantity,
                smallDrinksQuantity,
                mediumDrinksQuantity,
                largeDrinksQuantity;

        // Create an intent by getting the OrderActivity Intent. Get OrderActivity data entries with
        // get<Type>Extra() calls
        Intent intent = getIntent();
        doubleDoubleQuantity = intent.getIntExtra("DoubleDoubleQuantity", 0);
        cheeseburgerQuantity = intent.getIntExtra("CheeseburgerQuantity", 0);
        frenchFriesQuantity = intent.getIntExtra("FrenchFriesQuantity", 0);
        shakesQuantity = intent.getIntExtra("ShakesQuantity", 0);
        smallDrinksQuantity = intent.getIntExtra("SmallDrinksQuantity", 0);
        mediumDrinksQuantity = intent.getIntExtra("MediumDrinksQuantity", 0);
        largeDrinksQuantity = intent.getIntExtra("LargeDrinksQuantity", 0);

        // Send data to the Model (Order)
        order = new Order();
        order.setDoubleDoubles(doubleDoubleQuantity);
        order.setCheeseburgers(cheeseburgerQuantity);
        order.setFrenchFries(frenchFriesQuantity);
        order.setShakes(shakesQuantity);
        order.setSmallDrinks(smallDrinksQuantity);
        order.setMediumDrinks(mediumDrinksQuantity);
        order.setLargeDrinks(largeDrinksQuantity);

        // Populate TextViews with data from Order model
        // Wire up Views
        orderTotalTextView = findViewById(R.id.orderTotalTextView);
        orderTotalTextView.setText(String.format("Order Total %s", currency.format(order.calculateTotal())));
        itemsOrderedTextView = findViewById(R.id.itemsOrderedTextView);
        itemsOrderedTextView.setText(
                String.format("Items Ordered: %s",
                        order.getDoubleDoubles()
                                + order.getCheeseburgers()
                                + order.getFrenchFries()
                                + order.getShakes()
                                + order.getSmallDrinks()
                                + order.getMediumDrinks()
                                + order.getLargeDrinks()));
        subtotalTextView = findViewById(R.id.subtotalTextView);
        subtotalTextView.setText(String.format("Subtotal: %s", currency.format(order.calculateSubtotal())));
        taxRateTextView = findViewById(R.id.taxRateTextView);
        taxRateTextView.setText(String.format("Tax (%s): %s", percent.format(Order.TAX_RATE), currency.format(order.calculateTax())));
    }

    /**
     * onClick method for startNewOrderButton that sends the user back to the Order Activity to
     * start a new order.
     *
     * @param v     View that was clicked
     */
    public void startNewOrder(View v) {
        // Done with SummaryActivity, so "finish" it
        finish();
    }
}
