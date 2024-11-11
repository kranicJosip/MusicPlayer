public class Songs {
    String title;
    double duration;

    public Songs(double duration, String title) {
        this.duration = duration;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
