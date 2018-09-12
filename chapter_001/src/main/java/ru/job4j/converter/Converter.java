package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {


    private final static int DOLLAR_PRICE = 60;
	private final static int EURO_PRICE = 70;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / EURO_PRICE;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / DOLLAR_PRICE;
    }
	
	/**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return value * EURO_PRICE;
    }
	
     /**
	 * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return value * DOLLAR_PRICE;
    }
		
}
