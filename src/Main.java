//git test용 주석
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hundreds = 0;
        int tens = 0;
        int units = 0;
        // 랜덤값 생성
        List<String> permutations = new ArrayList<>();

        for (int i = 1; i <= 987; i++) {
            hundreds = i / 100; // 백의 자리의 수
            tens = (i / 10) % 10; // 십의 자리의 수1
            units = i % 10; // 1의 자리의 수
            String str2 = "" + hundreds + tens + units;

            if (hundreds != tens && hundreds != units && tens != units) {
                permutations.add(str2);
            }
        }
        Random random = new Random();
        int randomIndex = random.nextInt(permutations.size());
        String randomValue = permutations.get(randomIndex);
        System.out.println(randomValue);

        System.out.println("컴퓨터가 랜덤값을 생성했습니다!! 맞춰보세요!!");
        System.out.println("포기하시려면 '끝'이라고 입력하세요");

        int chance = 1;
        while (true){
            System.out.print(chance + "번째 기회입니다. 값을 입력해 주세요 :" );
            String text = sc.nextLine();
            chance = chance +1 ;
            if(text.length()!=3){
                System.out.println("3자리 수를 입력하세요");
                continue;
            }

            if (text.charAt(0) == text.charAt(1) || text.charAt(0) == text.charAt(2) || text.charAt(1) == text.charAt(2)) {
                System.out.println("중복된 값입니다. 다른 값을 입력해주세요");
                continue;
            }


            int strike = 0;
            int ball = 0;
            for (int i = 0; i < randomValue.length(); i++) {
                for (int j = 0; j < text.length(); j++) {//if 수정
                    if ( i == j && randomValue.charAt(i) == text.charAt(j)) {
                        strike++;
                    } else if (i != j && randomValue.charAt(i) == text.charAt(j)) {
                        ball++;
                    }
                }
            }
            if(text.isEmpty()){
                System.out.println("값을 입력하지 않았습니다.");
            }
            System.out.println(ball+"B"+strike+"S");

            if (Objects.equals(text, "끝")){
                break;
            }else if(strike == 3){
                System.out.println("strike입니다!!");
                break;
            }
        }
    }
}
