public class Main {

    public static void main(String[] args) {
        System.out.println("Здравствуйте, на сколько человек делим счёт? (введите число):");
        Positions.addPeople(); // Изменено название функции на глагол
        Positions.addPositionAndPrice();
        Positions.continueAddPositions();
        Positions.cheque();
        Positions.conclusion();
    }
}