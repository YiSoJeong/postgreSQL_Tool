import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/project_movie", "postgres", "cse3207");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        /*
         * 0. Check connection
         */
        System.out.println(connection);
        System.out.println("You made it, take control your database now!");

        /*
         * 1. Create the tables and insert the proper data based on the provided data.
         *    You should make the movie, actor, director, and customer tables first and insert data into other related tables.
         */

        Statement stat = connection.createStatement();
        ResultSet rs = null;
        String movieID;
        String movieName;
        String releaseYear;
        String releaseMonth;
        String releaseDate;
        String publisherName;
        float avgRate;
        String actorID;
        String actorName;
        String dateOfBirth;
        String dateOfDeath;
        String gender;
        String directorID;
        String directorName;
        String customerID;
        String customerName;
        String awardID;
        String awardName;
        String genreName;
        String year;
        String role;
        float rate;

        /*
         * Create movie table and insert initial data
         */
        stat.executeUpdate("CREATE TABLE movie(\"movieID\" VARCHAR (4) PRIMARY KEY, \"movieName\" VARCHAR (30) NOT NULL, \"releaseYear\" VARCHAR (4), \"releaseMonth\" VARCHAR (2), \"releaseDate\" VARCHAR (2), \"publisherName\" VARCHAR (50), \"avgRate\" NUMERIC )");
        stat.executeUpdate("INSERT INTO movie(\"movieID\", \"movieName\", \"releaseYear\", \"releaseMonth\", \"releaseDate\", \"publisherName\") values ('1', 'Edward Scissorhands', '1991', '06', '29', '20th Century Fox Presents')");
        stat.executeUpdate("INSERT INTO movie(\"movieID\", \"movieName\", \"releaseYear\", \"releaseMonth\", \"releaseDate\", \"publisherName\") values ('2', 'Alice In Wonderland', '2010', '03', '04', 'Korea Sony Pictures')");
        stat.executeUpdate("INSERT INTO movie(\"movieID\", \"movieName\", \"releaseYear\", \"releaseMonth\", \"releaseDate\", \"publisherName\") values ('3', 'The Social Network', '2010', '11', '18', 'Korea Sony Pictures')");
        stat.executeUpdate("INSERT INTO movie(\"movieID\", \"movieName\", \"releaseYear\", \"releaseMonth\", \"releaseDate\", \"publisherName\") values ('4', 'The Dark Knight', '2008', '08', '06', 'Warner Brothers Korea')");
        stat.executeUpdate("INSERT INTO movie(\"movieID\", \"movieName\", \"releaseYear\", \"releaseMonth\", \"releaseDate\", \"publisherName\") values ('5', 'Dunkirk', '2017', '07', '13', 'Warner Brothers Korea')");

        /*
         * Create actor table and insert initial data
         */
        stat.executeUpdate("create table actor(\"actorID\" VARCHAR (4) PRIMARY KEY, \"actorName\" VARCHAR (20) NOT NULL, \"dateOfBirth\" VARCHAR (10), \"dateOfDeath\" VARCHAR (10) DEFAULT NULL, \"gender\" VARCHAR (10))");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('1', 'Johnny Depp', '1963.6.9', 'Male')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('2', 'Winona Ryder', '1971.10.29', 'Female')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('3', 'Anne Hathaway', '1982.11.12', 'Female')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('4', 'Christian Bale', '1974.1.30', 'Male')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"dateOfDeath\", \"gender\") values ('5', 'Heath Ledger', '1979.4.4', '2008.1.22', 'Male')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('6', 'Jesse Eisenberg', '1983.10.5', 'Male')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('7', 'Andrew Garfield', '1983.8.20', 'Male')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('8', 'Fionn Whitehead', '1997.7.18', 'Male')");
        stat.executeUpdate("INSERT INTO actor(\"actorID\", \"actorName\", \"dateOfBirth\", \"gender\") values ('9', 'Tom Hardy', '1977.9.15', 'Male')");

        /*
         * Create director table and insert initial data
         */
        stat.executeUpdate("create table director(\"directorID\" VARCHAR (4) PRIMARY KEY, \"directorName\" VARCHAR (20) NOT NULL, \"dateOfBirth\" VARCHAR (10) NOT NULL, \"dateOfDeath\" VARCHAR (10))");
        stat.executeUpdate("INSERT INTO director(\"directorID\", \"directorName\", \"dateOfBirth\") values ('1', 'Tim Burton', '1958.8.25')");
        stat.executeUpdate("INSERT INTO director(\"directorID\", \"directorName\", \"dateOfBirth\") values ('2', 'David Fincher', '1962.8.28')");
        stat.executeUpdate("INSERT INTO director(\"directorID\", \"directorName\", \"dateOfBirth\") values ('3', 'Christopher Nolan', '1970.7.30')");

        /*
         * Create customer table and insert initial data
         */
        stat.executeUpdate("create table customer(\"customerID\" VARCHAR (4) PRIMARY KEY, \"customerName\" VARCHAR (50), \"dateOfBirth\" VARCHAR (10), \"gender\" VARCHAR (10))");
        stat.executeUpdate("INSERT INTO customer(\"customerID\", \"customerName\", \"dateOfBirth\", \"gender\") values ('1', 'Bob', '1997.11.14', 'Male')");
        stat.executeUpdate("INSERT INTO customer(\"customerID\", \"customerName\", \"dateOfBirth\", \"gender\") values ('2', 'John', '1978.01.23', 'Male')");
        stat.executeUpdate("INSERT INTO customer(\"customerID\", \"customerName\", \"dateOfBirth\", \"gender\") values ('3', 'Jack', '1980.05.04', 'Male')");
        stat.executeUpdate("INSERT INTO customer(\"customerID\", \"customerName\", \"dateOfBirth\", \"gender\") values ('4', 'Jill', '1981.04.17', 'Female')");
        stat.executeUpdate("INSERT INTO customer(\"customerID\", \"customerName\", \"dateOfBirth\", \"gender\") values ('5', 'Bell', '1990.05.14', 'Female')");

        /*
         * Create award table
         */
        stat.executeUpdate("create table award(\"awardID\" VARCHAR (4) PRIMARY KEY, \"awardName\" VARCHAR (30) NOT NULL)");

        /*
         * Create genre table and insert initial data
         */
        stat.executeUpdate("create table genre(\"genreName\" VARCHAR (20) PRIMARY KEY)");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Fantasy')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Romance')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Adventure')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Family')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Drama')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Action')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Mystery')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('Thriller')");
        stat.executeUpdate("INSERT INTO genre(\"genreName\") values ('War')");

        /*
         * Create movieGenre table and insert initial data
         */
        stat.executeUpdate("create table \"movieGenre\"(\"movieID\" VARCHAR (4), \"genreName\" VARCHAR (20), PRIMARY KEY (\"movieID\", \"genreName\"), FOREIGN KEY (\"movieID\") REFERENCES movie ON DELETE CASCADE, FOREIGN KEY (\"genreName\") REFERENCES genre ON DELETE CASCADE)");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('1', 'Fantasy')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('1', 'Romance')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('2', 'Fantasy')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('2', 'Adventure')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('2', 'Family')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('3', 'Drama')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('4', 'Action')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('4', 'Drama')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('4', 'Mystery')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('4', 'Thriller')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('5', 'Action')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('5', 'Drama')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('5', 'Thriller')");
        stat.executeUpdate("INSERT INTO \"movieGenre\"(\"movieID\", \"genreName\") values ('5', 'War')");

        /*
         * Create movieObtain table
         */
        stat.executeUpdate("create table \"movieObtain\"(\"movieID\" VARCHAR (4), \"awardID\" VARCHAR (4), \"year\" VARCHAR (4), PRIMARY KEY (\"movieID\", \"awardID\"), FOREIGN KEY (\"movieID\") REFERENCES movie ON DELETE CASCADE, FOREIGN KEY (\"awardID\") REFERENCES award ON DELETE CASCADE)");

        /*
         * Create actorObtain table
         */
        stat.executeUpdate("create table \"actorObtain\"(\"actorID\" VARCHAR (4), \"awardID\" VARCHAR (4), \"year\" VARCHAR (4), PRIMARY KEY (\"actorID\", \"awardID\"), FOREIGN KEY (\"actorID\") REFERENCES actor ON DELETE CASCADE, FOREIGN KEY (\"awardID\") REFERENCES award ON DELETE CASCADE)");

        /*
         * Create directorObtain table
         */
        stat.executeUpdate("create table \"directorObtain\"(\"directorID\" VARCHAR (4), \"awardID\" VARCHAR (4), \"year\" VARCHAR (4), PRIMARY KEY (\"directorID\", \"awardID\"), FOREIGN KEY (\"directorID\") REFERENCES director ON DELETE CASCADE, FOREIGN KEY (\"awardID\") REFERENCES award ON DELETE CASCADE)");

        /*
         * Create casting table and insert initial data
         */
        stat.executeUpdate("create table casting(\"movieID\" VARCHAR (4), \"actorID\" VARCHAR (4), \"role\" VARCHAR (20), PRIMARY KEY (\"movieID\", \"actorID\"), FOREIGN KEY (\"movieID\") REFERENCES movie ON DELETE CASCADE, FOREIGN KEY (\"actorID\") REFERENCES actor ON DELETE CASCADE)");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('1', '1', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('1', '2', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('2', '1', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('2', '3', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('3', '6', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('3', '7', 'Supporting Actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('4', '4', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('4', '5', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('5', '8', 'Main actor')");
        stat.executeUpdate("INSERT INTO \"casting\"(\"movieID\", \"actorID\", role) values ('5', '9', 'Main actor')");

        /*
         * Create make table and insert initial data
         */
        stat.executeUpdate("create table make(\"movieID\" VARCHAR (4), \"directorID\" VARCHAR (4), PRIMARY KEY (\"movieID\", \"directorID\"), FOREIGN KEY (\"movieID\") REFERENCES movie ON DELETE CASCADE, FOREIGN KEY (\"directorID\") REFERENCES director ON DELETE CASCADE)");
        stat.executeUpdate("INSERT INTO make(\"movieID\", \"directorID\") values ('1', '1')");
        stat.executeUpdate("INSERT INTO make(\"movieID\", \"directorID\") values ('2', '1')");
        stat.executeUpdate("INSERT INTO make(\"movieID\", \"directorID\") values ('3', '2')");
        stat.executeUpdate("INSERT INTO make(\"movieID\", \"directorID\") values ('4', '3')");
        stat.executeUpdate("INSERT INTO make(\"movieID\", \"directorID\") values ('5', '3')");

        /*
         * Create customerRate table
         */
        stat.executeUpdate("create table \"customerRate\"(\"customerID\" VARCHAR (4), \"movieID\" VARCHAR (4),  rate FLOAT , PRIMARY KEY (\"customerID\", \"movieID\"), FOREIGN KEY (\"customerID\") REFERENCES customer ON DELETE CASCADE, FOREIGN KEY (\"movieID\") REFERENCES movie ON DELETE CASCADE)");

        System.out.println("\nTable created!");
        System.out.println("Initial data inserted!");

        /*
         * 2. Insert the proper data from the following statements.
         */

//        2.1. Winona Ryder won the 􏰁Bes􏰂t 'supporting ac􏰂tor􏰃' award in 1994
        System.out.println("\nStatement : Winona Ryder won the 'Best supporting actor' award in 1994");
        System.out.println("Translated SQL : insert into award values ('1', 'Best supporting actor')");
        System.out.println("Translated SQL : insert into actorObtain (actorID, awardID, year)");
        System.out.println("Translated SQL : select actorID, awardID, '1994'");
        System.out.println("Translated SQL : from actor join award on actorName = 'Winona Ryder' and awardName = 'Best supporting actor'");
        stat.executeUpdate("insert into award values ('1', 'Best supporting actor')");
        stat.executeUpdate("insert into \"actorObtain\"(\"actorID\", \"awardID\", year) \n" +
                "select \"actorID\", \"awardID\", '1994' \n" +
                "from actor join award on \"actorName\" = 'Winona Ryder' and \"awardName\" = 'Best supporting actor'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"actorObtain\"");
        System.out.println("\n< actorObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "actorID", "awardID", "year");
        while(rs.next()){
            actorID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", actorID, awardID, year);
        }

//        2.2. Andrew Garfield won the 􏰍Bes􏰁t supporting ac􏰁tor􏰎 award in 2011
        System.out.println("\nStatement : Andrew Garfield won the Best supporting actor award in 2011");
        System.out.println("Translated SQL : insert into actorObtain (actorID, awardID, year)");
        System.out.println("Translated SQL : select actorID, awardID, '2011'");
        System.out.println("Translated SQL : from actor join award on actorName = 'Andrew Garfield' and awardName = 'Best supporting actor'");
        stat.executeUpdate("insert into \"actorObtain\"(\"actorID\", \"awardID\", year) \n" +
                "select \"actorID\", \"awardID\", '2011' \n" +
                "from actor join award on \"actorName\" = 'Andrew Garfield' and \"awardName\" = 'Best supporting actor'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"actorObtain\"");
        System.out.println("\n< actorObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "actorID", "awardID", "year");
        while(rs.next()){
            actorID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", actorID, awardID, year);
        }

//        2.3. Jesse Eisenberg won the Best main actor award in 2011
        System.out.println("\nStatement : Jesse Eisenberg won the Best main actor award in 2011");
        System.out.println("Translated SQL : insert into award values ('2', 'Best main actor')");
        System.out.println("Translated SQL : insert into actorObtain(actorID, awardID, year)");
        System.out.println("Translated SQL : select actorID, awardID, '2011'");
        System.out.println("Translated SQL : from actor join award on actorName = 'Jesse Eisenberg' and awardName = 'Best main actor'");
        stat.executeUpdate("insert into award values ('2', 'Best main actor')");
        stat.executeUpdate("insert into \"actorObtain\"(\"actorID\", \"awardID\", year) \n" +
                "select \"actorID\", \"awardID\", '2011' \n" +
                "from actor join award on \"actorName\" = 'Jesse Eisenberg' and \"awardName\" = 'Best main actor'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"actorObtain\"");
        System.out.println("\n< actorObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "actorID", "awardID", "year");
        while(rs.next()){
            actorID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", actorID, awardID, year);
        }

//        2.4. Johnny Depp won the 􏰍Bes􏰁t villain a􏰎ctor award in 2011
        System.out.println("\nStatement : Johnny Depp won the Best villain actor award in 2011");
        System.out.println("Translated SQL : insert into award values ('3', 'Best villain actor')");
        System.out.println("Translated SQL : insert into actorObtain(actorID, awardID, year)");
        System.out.println("Translated SQL : select actorID, awardID, '2011'");
        System.out.println("Translated SQL : from actor join award on actorName = 'Johnny Depp' and awardName = 'Best villain actor'");
        stat.executeUpdate("insert into award values ('3', 'Best villain actor')");
        stat.executeUpdate("insert into \"actorObtain\"(\"actorID\", \"awardID\", year) \n" +
                "select \"actorID\", \"awardID\", '2011' \n" +
                "from actor join award on \"actorName\" = 'Johnny Depp' and \"awardName\" = 'Best villain actor'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"actorObtain\"");
        System.out.println("\n< actorObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "actorID", "awardID", "year");
        while(rs.next()){
            actorID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", actorID, awardID, year);
        }

//        2.5. Edward Scissorhands won the 􏰍Bes􏰁t fantasy movie award in 1991
        System.out.println("\nStatement : Edward Scissorhands won the Best fantasy movie award in 1991");
        System.out.println("Translated SQL : insert into award values ('4', 'Best fantasy movie')");
        System.out.println("Translated SQL : insert into movieObtain(movieID, awardID, year)");
        System.out.println("Translated SQL : select movieID, awardID, '1991'");
        System.out.println("Translated SQL : from movie join award on movieName = 'Edward Scissorhands' and awardName = 'Best fantasy movie'");
        stat.executeUpdate("INSERT INTO award VALUES ('4', 'Best fantasy movie')");
        stat.executeUpdate("insert into \"movieObtain\"(\"movieID\", \"awardID\", year) \n" +
                "select \"movieID\", \"awardID\", '1991' \n" +
                "from movie join award on \"movieName\" = 'Edward Scissorhands' and \"awardName\" = 'Best fantasy movie'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"movieObtain\"");
        System.out.println("\n< movieObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "movieID", "awardID", "year");
        while(rs.next()){
            movieID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", movieID, awardID, year);
        }

//        2.6. The Dark Knight won the Best picture award in 2009
        System.out.println("\nStatement : The Dark Knight won the Best picture award in 2009");
        System.out.println("Translated SQL : insert into award values ('5', 'Best picture')");
        System.out.println("Translated SQL : insert into movieObtain(movieID, awardID, year)");
        System.out.println("Translated SQL : select movieID, awardID, '2009'");
        System.out.println("Translated SQL : from movie join award on movieName = 'The Dark Knight' and awardName = 'Best picture'");
        stat.executeUpdate("insert into award values ('5', 'Best picture')");
        stat.executeUpdate("insert into \"movieObtain\"(\"movieID\", \"awardID\", year) \n" +
                "select \"movieID\", \"awardID\", '2009' \n" +
                "from movie join award on \"movieName\" = 'The Dark Knight' and \"awardName\" = 'Best picture'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"movieObtain\"");
        System.out.println("\n< movieObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "movieID", "awardID", "year");
        while(rs.next()){
            movieID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", movieID, awardID, year);
        }

//        2.7. Alice In Wonderland won the Best fantasy movie award in 2011
        System.out.println("\nStatement : Alice In Wonderland won the Best fantasy movie award in 2011");
        System.out.println("Translated SQL : insert into movieObtain(movieID, awardID, year)");
        System.out.println("Translated SQL : select movieID, awardID, '2011'");
        System.out.println("Translated SQL : from movie join award on movieName = 'Alice In Wonderland' and awardName = 'Best fantasy movie'");
        stat.executeUpdate("insert into \"movieObtain\"(\"movieID\", \"awardID\", year) \n" +
                "select \"movieID\", \"awardID\", '2011' \n" +
                "from movie join award on \"movieName\" = 'Alice In Wonderland' and \"awardName\" = 'Best fantasy movie'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"movieObtain\"");
        System.out.println("\n< movieObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "movieID", "awardID", "year");
        while(rs.next()){
            movieID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", movieID, awardID, year);
        }

//        2.8. David Fincher won the Best director award in 2011
        System.out.println("\nStatement : David Fincher won the Best director award in 2011");
        System.out.println("Translated SQL : insert into award VALUES ('6', 'Best director')");
        System.out.println("Translated SQL : insert into directorObtain(directorID, awardID, year)");
        System.out.println("Translated SQL : select directorID, awardID, '2011'");
        System.out.println("Translated SQL : from director join award on directorName = 'David Fincher' and awardName = 'Best director'");
        stat.executeUpdate("INSERT INTO award VALUES ('6', 'Best director')");
        stat.executeUpdate("insert into \"directorObtain\"(\"directorID\", \"awardID\", year) \n" +
                "select \"directorID\", \"awardID\", '2011' \n" +
                "from director join award on \"directorName\" = 'David Fincher' and \"awardName\" = 'Best director'");

        rs = stat.executeQuery("select * from award");
        System.out.println("\n< award >");
        System.out.printf("%-10s %-20s \n", "awardID", "awardName");
        while(rs.next()){
            awardID = rs.getString(1);
            awardName = rs.getString("awardName");
            System.out.printf("%-10s %-20s \n", awardID, awardName);
        }

        rs = stat.executeQuery("select * from \"directorObtain\"");
        System.out.println("\n< directorObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "directorID", "awardID", "year");
        while(rs.next()){
            directorID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", directorID, awardID, year);
        }

        /*
         * 3. Insert data to the proper tables based on the following statements and update avgRate if necessary.
         */
//        3.1 Bob rates 5 to 􏰁The Dark Knigh􏰂􏰃t.
        System.out.println("\nStatement : Bob rates 5 to The Dark Knight.");
        System.out.println("Translated SQL : insert into customerRate (customerID, movieID, rate)");
        System.out.println("Translated SQL : select customerID, movieID, 5");
        System.out.println("Translated SQL : from customer join movie on customerName = 'Bob' and movieName = 'The Dark Knight'");
        System.out.println("Translated SQL : update movie");
        System.out.println("Translated SQL : set avgRate = (select avg(rate) from customerRate where customerRate.movieID = movie.movieID group by movieID)");
        System.out.println("Translated SQL : from customerRate where movie.movieID = customerRate.movieID");
        stat.executeUpdate("insert into \"customerRate\" (\"customerID\", \"movieID\", rate) " +
                "select \"customerID\", \"movieID\", 5 " +
                "from customer join movie on \"customerName\" = 'Bob' and \"movieName\" = 'The Dark Knight'");
        stat.executeUpdate("update movie " +
                "set \"avgRate\" = (select avg(rate) from \"customerRate\" where \"customerRate\".\"movieID\" = movie.\"movieID\" group by \"movieID\") " +
                "from \"customerRate\" " +
                "where movie.\"movieID\" = \"customerRate\".\"movieID\"");

        rs = stat.executeQuery("select * from \"customerRate\"");
        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

//        3.2 Bell rates 5 to the movies whose director is 􏰁Tim B􏰅urton.
        System.out.println("\nStatement : Bell rates 5 to the movies whose director is Tim Burton.");
        System.out.println("Translated SQL : insert into customerRate (customerID, movieID, rate)");
        System.out.println("Translated SQL : select customerID, movieID, 5");
        System.out.println("Translated SQL : from customer join make");
        System.out.println("Translated SQL : on customerName = 'Bell' and  directorID = (select directorID from director where directorName = 'Tim Burton')");
        System.out.println("Translated SQL : update movie");
        System.out.println("Translated SQL : set avgRate = (select avg(rate) from customerRate where customerRate.movieID = movie.movieID group by movieID)");
        System.out.println("Translated SQL : from customerRate where movie.movieID = customerRate.movieID");
        stat.executeUpdate("insert into \"customerRate\"(\"customerID\", \"movieID\", rate) " +
                "select \"customerID\", \"movieID\", 5 " +
                "from customer join make " +
                "on \"customerName\" = 'Bell' and \"directorID\" = (select \"directorID\" from director where \"directorName\" = 'Tim Burton')");
        stat.executeUpdate("update movie " +
                "set \"avgRate\" = (select avg(rate) from \"customerRate\" where \"customerRate\".\"movieID\" = movie.\"movieID\" group by \"movieID\") " +
                "from \"customerRate\" " +
                "where movie.\"movieID\" = \"customerRate\".\"movieID\"");

        rs = stat.executeQuery("select * from \"customerRate\"");
        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

//        3.3 Jill rates 4 to the movies whose main actor is female.
        System.out.println("\nStatement : Jill rates 4 to the movies whose main actor is female.");
        System.out.println("Translated SQL : insert into customerRate (customerID, movieID, rate)");
        System.out.println("Translated SQL : select customerID, movieID, 4");
        System.out.println("Translated SQL : from (casting natural join actor) join customer");
        System.out.println("Translated SQL : on customerName = 'Jill' and  casting.role = 'Main actor' and actor.gender = 'Female' and actor.actorID = casting.actorID");
        System.out.println("Translated SQL : update movie");
        System.out.println("Translated SQL : set avgRate = (select avg(rate) from customerRate where customerRate.movieID = movie.movieID group by movieID)");
        System.out.println("Translated SQL : from customerRate where movie.movieID = customerRate.movieID");
        stat.executeUpdate("insert into \"customerRate\"(\"customerID\", \"movieID\", rate) " +
                "select \"customerID\", \"movieID\", 4 " +
                "from (casting natural join actor) join customer " +
                "on \"customerName\" = 'Jill' and  casting.role = 'Main actor' and actor.gender = 'Female' and actor.\"actorID\" = casting.\"actorID\"");
        stat.executeUpdate("update movie " +
                "set \"avgRate\" = (select avg(rate) from \"customerRate\" where \"customerRate\".\"movieID\" = movie.\"movieID\" group by \"movieID\") " +
                "from \"customerRate\" " +
                "where movie.\"movieID\" = \"customerRate\".\"movieID\"");

        rs = stat.executeQuery("select * from \"customerRate\"");
        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

//        3.4 Jack rates 4 to the fantasy movies.
        System.out.println("\nStatement : Jack rates 4 to the fantasy movies.");
        System.out.println("Translated SQL : insert into customerRate(customerID, movieID, rate)");
        System.out.println("Translated SQL : select customerID, movieID, 4");
        System.out.println("Translated SQL : from customer join movieGenre");
        System.out.println("Translated SQL : on customerName = 'Jack' and genreName = 'Fantasy'");
        System.out.println("Translated SQL : update movie");
        System.out.println("Translated SQL : set avgRate = (select avg(rate) from customerRate where customerRate.movieID = movie.movieID group by movieID)");
        System.out.println("Translated SQL : from customerRate where movie.movieID = customerRate.movieID");
        stat.executeUpdate("insert into \"customerRate\"(\"customerID\", \"movieID\", rate)\n" +
                "select \"customerID\", \"movieID\", 4\n" +
                "from customer join \"movieGenre\" \n" +
                "on \"customerName\" = 'Jack' and \"genreName\" = 'Fantasy'");
        stat.executeUpdate("update movie " +
                "set \"avgRate\" = (select avg(rate) from \"customerRate\" where \"customerRate\".\"movieID\" = movie.\"movieID\" group by \"movieID\") " +
                "from \"customerRate\" " +
                "where movie.\"movieID\" = \"customerRate\".\"movieID\"");

        rs = stat.executeQuery("select * from \"customerRate\"");
        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

//        3.5 John rates 5 to the movies whose director won the 􏰁Bes􏰂t director award.
        System.out.println("\nStatement : John rates 5 to the movies whose director won the Best director award.");
        System.out.println("Translated SQL : insert into customerRate(customerID, movieID, rate)");
        System.out.println("Translated SQL : select customerID, movieID, 5");
        System.out.println("Translated SQL : from customer join make");
        System.out.println("Translated SQL : on customerName = 'Jack' and directorID = ( select directorID");
        System.out.println("Translated SQL :                                             from directorObtain natural join award");
        System.out.println("Translated SQL :                                             where awardName = 'Best director' )");
        System.out.println("Translated SQL : update movie");
        System.out.println("Translated SQL : set avgRate = (select avg(rate) from customerRate where customerRate.movieID = movie.movieID group by movieID)");
        System.out.println("Translated SQL : from customerRate where movie.movieID = customerRate.movieID");
        stat.executeUpdate("insert into \"customerRate\"(\"customerID\", \"movieID\", rate)\n" +
                "select \"customerID\", \"movieID\", 5\n" +
                "from customer join make \n" +
                "on \"customerName\" = 'Jack' and \"directorID\" = (\n" +
                "select \"directorID\"\n" +
                "from \"directorObtain\" natural join award\n" +
                "where \"awardName\" = 'Best director'\n" +
                ")");
        stat.executeUpdate("update movie " +
                "set \"avgRate\" = (select avg(rate) from \"customerRate\" where \"customerRate\".\"movieID\" = movie.\"movieID\" group by \"movieID\") " +
                "from \"customerRate\" " +
                "where movie.\"movieID\" = \"customerRate\".\"movieID\"");

        rs = stat.executeQuery("select * from \"customerRate\"");
        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

        /*
         * 4. Select the names of the movies whose actor are dead.
         */
        System.out.println("\nStatement : Select the names of the movies whose actor are dead.");
        System.out.println("Translated SQL : select movieName");
        System.out.println("Translated SQL : from (movie join casting on movie.movieID = casting.movieID) natural join actor");
        System.out.println("Translated SQL : where actor.dateOfDeath is not null");
        rs = stat.executeQuery("select \"movieName\" \n" +
                "from (movie join casting on movie.\"movieID\" = casting.\"movieID\") natural join actor\n" +
                "where actor.\"dateOfDeath\" is not null;");
        System.out.println("\n< movieName >");
        while(rs.next()){
            movieName = rs.getString(1);
            System.out.printf("%-10s \n", movieName);
        }

        /*
         * 5. Select the names of the directors who cast the same actor more than once.
         */
        System.out.println("\nStatement : Select the names of the directors who cast the same actor more than once.");
        System.out.println("Translated SQL : select directorName");
        System.out.println("Translated SQL : from director");
        System.out.println("Translated SQL : where directorID in (select directorID");
        System.out.println("Translated SQL :                      from make natural join casting");
        System.out.println("Translated SQL :                      group by directorID, actorID");
        System.out.println("Translated SQL :                      having count(movieID) > 1)");
        rs = stat.executeQuery("select \"directorName\" " +
                "from director " +
                "where \"directorID\" in (select \"directorID\" from make natural join casting group by \"directorID\",\"actorID\" having count(\"movieID\") > 1)");
        System.out.println("\n< directorName >");
        while(rs.next()){
            directorName = rs.getString(1);
            System.out.printf("%-10s \n", directorName);
        }

        /*
         * 6. Select the names of the movies and the genres, where movies have the common genre.
         */
        System.out.println("\nStatement : Select the names of the movies and the genres, where movies have the common genre.");
        System.out.println("Translated SQL : select movieName, genreName");
        System.out.println("Translated SQL : from movie natural join movieGenre");
        System.out.println("Translated SQL : where genreName in ( select genreName");
        System.out.println("Translated SQL :                      from movie natural join movieGenre");
        System.out.println("Translated SQL :                      group by genreName");
        System.out.println("Translated SQL :                      having count(movieID) > 1)");
        rs = stat.executeQuery("select \"movieName\", \"genreName\" " +
                "from movie natural join \"movieGenre\" " +
                "where \"genreName\" in (select \"genreName\" from movie natural join \"movieGenre\" group by \"genreName\" having count(\"movieID\") > 1)");
        System.out.println("\n< movieName , genreName >");
        while(rs.next()){
            movieName = rs.getString(1);
            genreName = rs.getString(2);
            System.out.printf("%-20s %-20s\n", movieName, genreName);
        }

        /*
         * 7. Delete the movies which did not get any award (including all directors and actors) and delete data from related tables.
         */
        System.out.println("\nStatement : Delete the movies which did not get any award (including all directors and actors) and delete data from related tables.");
        System.out.println("Translated SQL : delete from movie");
        System.out.println("Translated SQL : where movieID not in (select movieID from movie where movieID in (select movieID from casting natural join actorObtain)");
        System.out.println("Translated SQL : or movieID in (select movieID from make natural join directorObtain)");
        System.out.println("Translated SQL : or movieID in (select movieID from movieObtain))");
        stat.executeUpdate("delete from movie\n" +
                "where \"movieID\" not in (select \"movieID\" from movie where \"movieID\" in (select \"movieID\" from casting natural join \"actorObtain\") " +
                "or \"movieID\" in (select \"movieID\" from make natural join \"directorObtain\") " +
                "or \"movieID\" in (select \"movieID\" from \"movieObtain\"))");

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

        rs = stat.executeQuery("select * from \"movieObtain\"");
        System.out.println("\n< movieObtain >");
        System.out.printf("%-10s %-20s %-4s \n", "movieID", "awardID", "year");
        while(rs.next()){
            movieID = rs.getString(1);
            awardID = rs.getString("awardID");
            year = rs.getString("year");
            System.out.printf("%-10s %-20s %-4s \n", movieID, awardID, year);
        }

        rs = stat.executeQuery("select * from make");
        System.out.println("\n< make >");
        System.out.printf("%-10s %-10s \n", "movieID", "directorID");
        while(rs.next()){
            movieID = rs.getString(1);
            directorID = rs.getString("directorID");
            System.out.printf("%-10s %-10s \n", movieID, directorID);
        }

        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from \"movieGenre\"");
        System.out.println("\n< movieGenre >");
        System.out.printf("%-10s %-20s \n", "movieID", "genreName");
        while(rs.next()){
            movieID = rs.getString(1);
            genreName = rs.getString("genreName");
            System.out.printf("%-10s %-20s \n", movieID, genreName);
        }

        rs = stat.executeQuery("select * from casting");
        System.out.println("\n< casting >");
        System.out.printf("%-10s %-10s %-15s \n", "movieID", "actorID", "role");
        while(rs.next()){
            movieID = rs.getString(1);
            actorID = rs.getString("actorID");
            role = rs.getString("role");
            System.out.printf("%-10s %-10s %-15s \n", movieID, actorID, role);
        }

        /*
         * 8. Delete all customers and delete data from related tables.
         */
        System.out.println("\nStatement : Delete all customers and delete data from related tables.");
        System.out.println("Translated SQL : delete from customer");
        System.out.println("Translated SQL : update movie set avgRate = null");
        stat.executeUpdate("delete from customer");
        stat.executeUpdate("update movie set \"avgRate\" = null");

        rs = stat.executeQuery("select * from customer");
        System.out.println("\n< customer >");
        System.out.printf("%-10s %-12s %-12s %-6s \n", "customerID", "customerName", "dateOfBirth", "gender");
        while(rs.next()){
            customerID = rs.getString(1);
            customerName = rs.getString("customerName");
            dateOfBirth= rs.getString("dateOfBirth");
            gender= rs.getString("gender");
            System.out.printf("%-10s %-12s %-12s %-6s \n", customerID, customerName, dateOfBirth, gender);
        }

        rs = stat.executeQuery("select * from \"customerRate\"");
        System.out.println("\n< customerRate >");
        System.out.printf("%-10s %-10s %-5s \n", "customerID", "movieID", "rate");
        while(rs.next()){
            customerID = rs.getString(1);
            movieID = rs.getString("movieID");
            rate = rs.getInt("rate");
            System.out.printf("%-10s %-10s %-5s \n", customerID, movieID, rate);
        }

        rs = stat.executeQuery("select * from movie");
        System.out.println("\n< movie >");
        System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", "movieID", "movieName", "releaseYear", "releaseMonth", "releaseDate", "publisherName", "avgRate");
        while(rs.next()){
            movieID = rs.getString(1);
            movieName = rs.getString("movieName");
            releaseYear= rs.getString("releaseYear");
            releaseMonth= rs.getString("releaseMonth");
            releaseDate= rs.getString("releaseDate");
            publisherName= rs.getString("publisherName");
            avgRate= rs.getFloat("avgRate");
            System.out.printf("%-10s %-20s %-12s %-12s %-12s %-25s %-10s \n", movieID, movieName, releaseYear, releaseMonth, releaseDate, publisherName, avgRate);
        }

        /*
         * 9. Delete all data and tables.
         */
        System.out.println("\nStatement : Delete all data and tables.");
        System.out.println("Translated SQL : drop table actor, actorObtain, award, casting,");
        System.out.println("Translated SQL : customer, customerRate, director, directorObtain,");
        System.out.println("Translated SQL : genre, make,movie, movieGenre, movieObtain CASCADE");
        stat.executeUpdate("DROP TABLE actor, \"actorObtain\", award, casting, customer, \"customerRate\", director, \"directorObtain\", genre, make, movie, \"movieGenre\", \"movieObtain\" CASCADE ");

        System.out.println("All table deleted!");

        connection.close();
    }
}