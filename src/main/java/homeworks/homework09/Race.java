package homeworks.homework09;


import java.util.List;
import java.util.Objects;

public class Race {
    private int length;
    private String route;
    private int prizeFund;
    private List<Car> participants;

    public Race(int length, String route, int prizeFund, List<Car> participants) {
        this.length = length;
        this.route = route;
        this.prizeFund = prizeFund;
        this.participants = participants;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        this.prizeFund = prizeFund;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Car> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prizeFund=" + prizeFund +
                ", participants=" + participants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length && prizeFund == race.prizeFund && Objects.equals(route, race.route) && Objects.equals(participants, race.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prizeFund, participants);
    }

    static class CasualRace extends Race {
        public CasualRace(int length, String route, int prizeFund, List<Car> participants) {
            super(length, route, prizeFund, participants);
        }
    }

    class DragRace extends Race {
        public DragRace(int length, String route, int prizeFund, List<Car> participants) {
            super(length, route, prizeFund, participants);
        }
    }

    class DriftRace extends Race {
        public DriftRace(int length, String route, int prizeFund, List<Car> participants) {
            super(length, route, prizeFund, participants);
        }
    }
}
