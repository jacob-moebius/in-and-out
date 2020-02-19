package cs134.miracosta.edu.jmoebius.model;

/**
 * Data model for an In and Out order, including information about the burger prices, tax rate, and
 * total cost of the order.
 *
 * @author Jacob Moebius
 */
public class Order {
    // Fields
    // Constants
    public static final double PRICE_CHEESEBURGER = 2.15;
    public static final double PRICE_DOUBLE_DOUBLE = 3.60;
    public static final double PRICE_FRENCH_FRIES = 1.65;
    public static final double PRICE_DRINK_LARGE = 1.75;
    public static final double PRICE_DRINK_MEDIUM = 1.55;
    public static final double PRICE_SHAKES = 2.20;
    public static final double PRICE_DRINK_SMALL = 1.45;
    public static final double TAX_RATE = 0.08;

    // Member variables
    private int mCheeseburgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mShakes;
    private int mSmallDrinks;

    /**
     * Calculates the subtotal of the order by summing the products of each item and their
     * quantities.
     * @return      The subtotal of the order.
     */
    public double calculateSubtotal() {
        return
                (PRICE_CHEESEBURGER * mCheeseburgers
                + PRICE_DOUBLE_DOUBLE * mDoubleDoubles
                + PRICE_FRENCH_FRIES * mFrenchFries
                + PRICE_DRINK_LARGE * mLargeDrinks
                + PRICE_DRINK_MEDIUM * mMediumDrinks
                + PRICE_DRINK_SMALL * mSmallDrinks
                + PRICE_SHAKES * mShakes);
    }

    /**
     * Calculates the amount of tax of the order by multiplying the subtotal by the tax rate.
     * @return      The amount of tax of the order
     */
    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    /**
     * Calculates the total of the order by summing the subtotal and the amount of tax of the order.
     * @return      The total of the order.
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    /**
     * Setters and Getters for member variables
     */
    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }

    public void setDoubleDoubles(int doubleDoubles) {
        mDoubleDoubles = doubleDoubles;
    }

    public int getFrenchFries() {
        return mFrenchFries;
    }

    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    public int getShakes() {
        return mShakes;
    }

    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }
}
