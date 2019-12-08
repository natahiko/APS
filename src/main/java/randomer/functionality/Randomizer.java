package randomer.functionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Randomizer {

    public ArrayList<Integer> generate(int start, int end) {
        ArrayList<Integer> randomList = (ArrayList<Integer>) IntStream.range(start, end + 1).boxed().collect(Collectors.toList());
        Collections.shuffle(randomList);
        System.out.println("done random succesfully "+start+" "+end);
        System.out.println(randomList.toString());
        return randomList;
    }
}
