

public class User {
    private String name;
    private String companyName;
    private int yearOfJoin;
    private String email;
    private String password;

    public User(String name, String companyName, int yearOfJoin) {
        this.name = name;
        this.companyName = companyName;
        this.yearOfJoin = yearOfJoin;
        this.email = emailGenerator();
        this.password = passwordGenerator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearOfJoin() {
        return yearOfJoin;
    }

    public void setYearOfJoin(int yearOfJoin) {
        this.yearOfJoin = yearOfJoin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int generateRandomInteger(int limit) {
        return (int) (Math.random() * limit);
    }

    private char generateRandomChar() {
        return (char) ('a' + generateRandomInteger(26));
    }

    private String getFirst5CharactersFromUserName() {
        if (getName().length() < 5) {
            StringBuilder pass = new StringBuilder();
            int difference = 5 - getName().length();
            pass.append("0".repeat(Math.max(0, difference)));
            return pass.toString();
        } else {
            return getName().substring(0, 5);
        }
    }

    private char generateRandomSpecialSymbol() {
        char[] specialSymbol = {
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '[', ']', '{', '}', ';', ':', '|', '\\', '\'', '\"', '<', '>', ',', '.', '/'
        };
        int randomNumber = generateRandomInteger(specialSymbol.length);
        return specialSymbol[randomNumber];
    }

    public String emailGenerator() {
        return String.format("%s_%d%s.com", getName().toLowerCase(), getYearOfJoin(), getCompanyName());

    }

    public String passwordGenerator() {
        StringBuilder pass = new StringBuilder();
        pass.append(generateRandomChar());
        for (int i = 0; i < 4; i++) {
            pass.append(generateRandomInteger(10));
        }
        pass.append(getFirst5CharactersFromUserName());
        pass.append(generateRandomSpecialSymbol());


        return pass.toString();
    }
}

class Main {
    public static void main(String[] args) {
        User myobj = new User("ayush", "GLA", 2000);
        System.out.println(myobj.emailGenerator());
        System.out.println(myobj.passwordGenerator());
    }
}
