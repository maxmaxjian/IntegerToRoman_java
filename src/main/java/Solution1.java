import java.util.ArrayList;
import java.util.List;

public class Solution1 implements Solution {
    @Override
    public String intToRoman(int num) {

        List<Integer> digits = new ArrayList<>();
        List<Unit> units = new ArrayList<>();

        int i = 1;
        while (num > 0) {
            int d = num%10;
            if (d != 0) {
                digits.add(d);
                switch(i) {
                    case 1:
                        units.add(Unit.ONES);
                        break;
                    case 2:
                        units.add(Unit.TENS);
                        break;
                    case 3:
                        units.add(Unit.HUNDREDS);
                        break;
                    default:
                        units.add(Unit.THOUSANDS);
                        break;
                }
            }
            num /= 10;
            i++;
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < digits.size(); j++) {
            result.insert(0, digitToRoman(digits.get(j), units.get(j)));
        }

        return result.toString();
    }

    private String digitToRoman(int digit, Unit unit) {
        StringBuilder stringBuilder = new StringBuilder();
        switch(digit) {
            case 3:
                stringBuilder.append(unit.one());
            case 2:
                stringBuilder.append(unit.one());
            case 1:
                stringBuilder.append(unit.one());
                break;
            case 4:
                stringBuilder.append(unit.one()).append(unit.five());
                break;
            case 8:
                stringBuilder.append(unit.one());
            case 7:
                stringBuilder.append(unit.one());
            case 6:
                stringBuilder.append(unit.one());
            case 5:
                stringBuilder.append(unit.five()).reverse();
                break;
            default:
                stringBuilder.append(unit.one()).append(unit.ten());
                break;
        }
        return stringBuilder.toString();
    }
}
