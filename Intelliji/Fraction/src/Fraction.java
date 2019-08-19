import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Fraction {
    private int integer;
    private int dividend;
    private int divider;
    private String fraction;
    private double number;
    private Map<String, Double> fractionMap;

    public Fraction(double number) {
        this.integer = (int) number;
        this.number = number - this.integer;
        this.dividend = 0;
        this.divider = 0;
        this.fractionMap = new HashMap<>();
        getFMap();
        calculation();
    }

    public Fraction() {
        this.integer = 0;
        this.number = 0;
        this.dividend = 0;
        this.divider = 0;
        this.fractionMap = new HashMap<>();
        getFMap();
    }

    private void calculation() {
        double div = 1 / 8.0;

        double min =1.0;
        for (Map.Entry<String,Double> el:this.fractionMap.entrySet()){
            double val = el.getValue();
            double res= Math.abs(el.getValue()-this.number);
            if(min>res){
                min=res;
                this.fraction = el.getKey();
            }
        }


        String[] strArr = this.fraction.split("/");
        int len = strArr.length;
        if (len > 0) {
            this.dividend = Integer.parseInt(strArr[0]);
        }
        if (len > 1) {
            this.divider = Integer.parseInt(strArr[1]);
        }

        if(integer>0){
            this.fraction=String.format("%d %s",this.integer,this.fraction);
        }
    }

    private void getFMap() {
        fractionMap.put("0", 0.0);
        fractionMap.put("1/8", 1 / 8.0);
        fractionMap.put("1/4", 1 / 4.0);
        fractionMap.put("3/8", 3 / 8.0);
        fractionMap.put("1/2", 1 / 2.0);
        fractionMap.put("5/8", 5 / 8.0);
        fractionMap.put("3/4", 3 / 4.0);
        fractionMap.put("7/8", 7 / 8.0);
        fractionMap.put("1", 1.0);
    }

    public int getInteger() {
        return integer;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivider() {
        return divider;
    }

    public String getFraction() {
        return fraction;
    }

    public void setNumber(double number) {
        this.integer = (int) number;
        this.number = number - this.integer;
        this.dividend = 0;
        this.divider = 0;
        calculation();
    }

    public double getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "integer=" + integer +
                ", dividend=" + dividend +
                ", divider=" + divider +
                ", fraction='" + fraction + '\'' +
                ", number=" + number +
                '}';
    }
}
