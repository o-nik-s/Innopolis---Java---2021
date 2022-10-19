import java.util.Scanner;

class Program2 {
	public static void main(String[] args) {
		// объявляю объект для считывания чисел с консоли
		Scanner scanner = new Scanner(System.in);
		// считываю первое число
		int a = scanner.nextInt();
		// объявляю переменные и задаю им начальные значения
		int digitsSum = 0; // сумма цифр текущего числа
		int minDigitsSum = 37; // минимальная сумма цифр
		// пока не встретили -1
		while (a != -1) {
			// указываем, что сумма цифр должна изначально быть равна нулю
			digitsSum = 0;
			// проверяем, является ли число четным?
			if (a % 2 == 0) {
				// пока число не равно нулю
				while (a != 0) {
					// запоминаем последную цифру
					int lastDigit = a % 10;
					// кладем цифру в сумму цифр текущего числа
					digitsSum = digitsSum + lastDigit;
					// отбрасываем от исходного числа последнюю цифру
					a = a / 10;
				}
				// если полученная сумма цифр меньше той, что была до этого
				if (digitsSum < minDigitsSum) {
					// забываем про старую минимальную сумму и запоминаем новую
					minDigitsSum = digitsSum;
				}
			}
			// на каждом шаге цикла считываем новое число из консоли
			a = scanner.nextInt();
		}
		// выводим результат
		System.out.println("Result - " + minDigitsSum);
	}
}