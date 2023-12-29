package IntermediateTopics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLearning extends BasicExcerices {

    @Override
    public void exercise() throws IOException {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mike", "Michealson", 5000.0, List.of("Project 1", "Project2")));
        employees.add(new Employee("John", "Johnson", 6000.0, List.of("Project 3", "Project4")));
        employees.add(new Employee("Son", "SonSon", 5500.0, List.of("Project 1", "Project4")));
        // Define the Stream

        // forEach method
        Stream.of(employees)
                .forEach(employee -> System.out.println(employee));
        ; // Antoher way to create the stream is employees.stream();

        // map method
        List<Employee> increasedSal = employees.stream()
                .map(
                        employee -> new Employee(employee.firstName, employee.lastName, employee.salary * 1.10,
                                employee.projects))
                // Collect the result in a List
                // (it is possibile to collect even in other iterables)
                .collect(Collectors.toList());

        Stream.of(increasedSal)
                .forEach(employee -> System.out.println(employee));

        // filter method
        List<Employee> filteredSal = employees.stream()
                .filter(employee -> employee.salary > 5000.0)
                .map(
                        employee -> new Employee(employee.firstName, employee.lastName, employee.salary * 1.10,
                                employee.projects))
                .collect(Collectors.toList());

        Stream.of(filteredSal).forEach(employee -> System.out.println(employee));

        // findFirst and orElse methods
        Employee firstEmployee = employees.stream()
                .filter(employee -> employee.salary > 5000.0)
                .map(
                        employee -> new Employee(employee.firstName, employee.lastName, employee.salary * 1.10,
                                employee.projects))
                // find first is optional, it can return null
                .findFirst()
                .orElse(null);

        System.out.println(firstEmployee);

        // flatMap method
        String projects = employees.stream()
                .map(employee -> employee.projects)
                .flatMap(project -> project.stream())
                .collect(Collectors.joining(","));

        System.out.println(projects);

        // short Circuit operations
        List<Employee> shortCircuiteEm = employees.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(shortCircuiteEm);

        // Finite Data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        // sorting
        List<Employee> sortedEmployees = employees.stream()
                .sorted((o1, o2) -> o1.firstName.compareToIgnoreCase(o2.firstName))
                .collect(Collectors.toList());
        sortedEmployees.stream()
                .forEach(System.out::println);

        // min and max
        Employee maxEm = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                // If no object available throw exception
                .orElseThrow(NoSuchElementException::new);
        System.out.println(maxEm);
        // reduce
        Double totalSal = employees.stream()
                .map(employee -> employee.getSalary())
                .reduce(0.0, Double::sum);
        System.out.println(totalSal);

        // parallel stream

    }

    class Employee {
        String firstName;
        String lastName;
        Double salary;
        List<String> projects;

        public Employee(String firstName, String lastName, Double salary, List<String> projects) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
            this.projects = projects;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", salary='" + salary + '\'' +
                    ", projects='" + projects + '\'';
        }

        public Double getSalary() {
            return this.salary;
        }

    }
}
