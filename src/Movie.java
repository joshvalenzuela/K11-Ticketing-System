class Movie {
    private String title;
    private int duration;
    private String genre;
    private double ratings;
    private double price;

    public Movie(String title, int duration, String genre, double ratings, double price) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.ratings = ratings;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public double getRatings() {
        return ratings;
    }

    public double getPrice() {
        return price;
    }
}