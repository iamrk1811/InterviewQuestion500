package questions.Math;

public class BirthdayParadox {
    //    Q - https://www.geeksforgeeks.org/birthday-paradox/
    public double find(double p) {
        return Math.ceil(Math.sqrt(2 * 365 * Math.log(1 / (1 - p))));
    }
}
