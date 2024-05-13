import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Movie[] movies = readMovies("Titles.txt");

        Scanner sc = new Scanner(System.in);
        System.out.println("Available Movies:" + "\n");

        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }

        System.out.print("\nEnter movie title: ");
        String selectedTitle = sc.nextLine();

        Movie selectedMovie = findMovie(movies, selectedTitle);

        if (selectedMovie != null) {
            System.out.println("\nMovie Details:"+ "\n");
            System.out.println("Title: " + selectedMovie.getTitle());
            System.out.println("Duration: " + selectedMovie.getDuration() + " minutes");
            System.out.println("Genre: " + selectedMovie.getGenre());
            System.out.println("Ratings: " + selectedMovie.getRatings());
            System.out.println("Price in PHP: " + selectedMovie.getPrice()+ "\n");
        } else {
            System.out.println("Movie not found!");
        }
    }

    public static Movie[] readMovies(String filename) {
        Movie[] movies = new Movie[5];  
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextLine()) {
                String[] movieInfo = scanner.nextLine().split("\\|");
                String title = movieInfo[0];
                int duration = Integer.parseInt(movieInfo[1]);
                String genre = movieInfo[2];
                double ratings = Double.parseDouble(movieInfo[3]);
                double price = Double.parseDouble(movieInfo[4]);
                movies[index] = new Movie(title, duration, genre, ratings, price);
                index++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return movies;
    }

    public static Movie findMovie(Movie[] movies, String title) {
        for (Movie movie : movies) {
            if (movie != null && movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
}