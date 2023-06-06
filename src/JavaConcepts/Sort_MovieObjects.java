package JavaConcepts;
import java.io.*;
import java.util.*;

/*
Comparable: A comparable object is capable of comparing itself with another object.
The class itself must implements the java.lang.Comparable interface to compare its instances.
Consider a Movie class that has members like, rating, name, year. Suppose we wish to sort a list of Movies based on year of release.
We can implement the Comparable interface with the Movie class, and we override the method compareTo() of Comparable interface.
 */

/*
Comparator: Unlike Comparable, Comparator is external to the element type we are comparing.
It’s a separate class. We create multiple separate classes (that implement Comparator) to compare by different members.
Collections class has a second sort() method and it takes Comparator. The sort() method invokes the compare() to sort objects.
 */
public class Sort_MovieObjects implements Comparable<Sort_MovieObjects>{
    private double rating;
    private String name;
    private int year;

    // Used to sort movies by year
    public int compareTo(Sort_MovieObjects m)
    {
        return Integer.compare(this.year, m.year); // return this.year < m.year? -1 : this.year > m.year? 1 : 0;
    }

    // Constructor
    public Sort_MovieObjects(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() {
        return rating;
    }
    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Sort_MovieObjects> {
    public int compare(Sort_MovieObjects m1, Sort_MovieObjects m2)
    {
        return Double.compare(m1.getRating(), m2.getRating()); //
    }
}

// Class to compare Movies by name
class NameCompare implements Comparator<Sort_MovieObjects> {
    public int compare(Sort_MovieObjects m1, Sort_MovieObjects m2)
    {
        return m1.getName().compareTo(m2.getName());
    }
}

// Driver class
class Main {
    public static void main(String[] args)
    {
        ArrayList<Sort_MovieObjects> list = new ArrayList<Sort_MovieObjects>();
        list.add(new Sort_MovieObjects("Force Awakens", 8.3, 2015));
        list.add(new Sort_MovieObjects("Star Wars", 8.7, 1977));
        list.add(
                new Sort_MovieObjects("Empire Strikes Back", 8.8, 1980));
        list.add(
                new Sort_MovieObjects("Return of the Jedi", 8.4, 1983));

        // Sort by rating : (1) Create an object of
        // ratingCompare
        //                  (2) Call Collections.sort
        //                  (3) Print Sorted list
        System.out.println("Sorted by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        for (Sort_MovieObjects movie : list)
            System.out.println(movie.getRating() + " "
                    + movie.getName() + " "
                    + movie.getYear());

        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);
        for (Sort_MovieObjects movie : list)
            System.out.println(movie.getName() + " "
                    + movie.getRating() + " "
                    + movie.getYear());

        // Uses Comparable to sort by year
        System.out.println("\nSorted by year");
        Collections.sort(list);
        for (Sort_MovieObjects movie : list)
            System.out.println(movie.getYear() + " "
                    + movie.getRating() + " "
                    + movie.getName() + " ");
    }
}

// Java 8 : Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
/*
 Java 8 stream : List<Employee> sortedList = employees.stream()
        .sorted(Comparator.comparingDouble(Employee::getSalary))
        .collect(Collectors.toList()); */