import lombok.*;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Race {
    private int length;
    private String route;
    private int prizeFund;
    private List<Car> participants;

    static class CasualRace extends Race {
        public CasualRace(int length, String route, int prizeFund, List<Car> participants) {
            super(length, route, prizeFund, participants);
        }
    }

    static class DragRace extends Race {
        public DragRace(int length, String route, int prizeFund, List<Car> participants) {
            super(length, route, prizeFund, participants);
        }
    }

    static class DriftRace extends Race {
        public DriftRace(int length, String route, int prizeFund, List<Car> participants) {
            super(length, route, prizeFund, participants);
        }
    }
}