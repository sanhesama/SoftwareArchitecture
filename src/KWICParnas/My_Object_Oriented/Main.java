package KWICParnas.My_Object_Oriented;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("D:\\Development\\Code\\IDEA\\SoftwareArchitecture\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\Development\\Code\\IDEA\\SoftwareArchitecture\\output.txt","TEXT");

    }
}

