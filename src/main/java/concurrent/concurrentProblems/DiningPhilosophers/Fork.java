package concurrent.concurrentProblems.diningPhilosophers;

/**
 * Created by user on 05.03.15.
 */
public class Fork {

    private int id;
    private int feed;

    public Fork(int id, int feed) {
        this.id = id;
        this.feed = feed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeed() {
        return feed;
    }

    public void setFeed(int feed) {
        this.feed = feed;
    }
}
