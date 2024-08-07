package learn.designpattern.commanddesignpattern;

//3.RECEIVER
public class AirConditioner {
    boolean isON;
    int temperature;

    public void setOnAc() {
        isON = true;
        System.out.println("AC isON = " + isON);
    }

    public void setOffAc() {
        isON = false;
        System.out.println("AC isOff = " + isON);
    }

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Temperature changed to temp = " + temp);
    }
}
