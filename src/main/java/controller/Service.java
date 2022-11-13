package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> createTotalLottoNumber(int lottoCount) {
        List<Lotto> totalLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            totalLottoNumbers.add(new Lotto(createLottoNumber()));
        }
        return totalLottoNumbers;
    }

    public List<Integer> inputLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputWinning = (Console.readLine()).split(",");
        List<Integer> inputWinningNumbers = Arrays.stream(inputWinning).map(Integer::parseInt).collect(Collectors.toList());
        return inputWinningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
    }

    public int inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputUser = Console.readLine();
        return Integer.parseInt(inputUser);
    }

    public int compareWinningNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        List<Integer> sameNumbers = new ArrayList<>();
        sameNumbers.addAll(lottoNumbers);
        sameNumbers.retainAll(winningNumbers);
        return sameNumbers.size();
    }

    public boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber, int winningNumbers){
        if(winningNumbers == 5)
            return lottoNumbers.contains(bonusNumber);
        return false;
    }
}
