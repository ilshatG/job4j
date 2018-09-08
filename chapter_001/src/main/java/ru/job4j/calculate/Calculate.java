package ru.job4j.calculate;

/**
* Calculate.
* Данный класс предназначен для запуска программы.
* @author Ilshat Gaifutdinov (ilshatrashidovich@rambler.ru)
* @since 07/09/2018
* @version 0.1
*/
public class Calculate {
	
	/**
	* main
	* С данного метода начинается выполнение программы.
	* Выводит на экран текст приветствия
	* @param args - args
	*/
	public static void main(String[] args) {
		System.out.println("Hello new brave world!");
	}

	/**
	* Method echo.
	* @param name Your name.
	* @return Echo, echo, echo :  plus your name.
	*/
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}	
}