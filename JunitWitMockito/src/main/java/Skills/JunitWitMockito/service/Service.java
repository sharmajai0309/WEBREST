package Skills.JunitWitMockito.service;

import java.sql.SQLException; 
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Skills.JunitWitMockito.repo.Repository;

public class Service {
    private final Repository repo;

    public Service(Repository repo) {
        if (repo == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        this.repo = repo;
    }

    public List<String> getDataByLen() {
        try {
            return repo.getData().stream()
                       .filter(d -> d.length() <= 5)
                       .collect(Collectors.toList());	
        } catch (SQLException e) {
            System.err.println("Error fetching data from repository: " + e.getMessage());
            return Arrays.asList();
        }
    }
}
