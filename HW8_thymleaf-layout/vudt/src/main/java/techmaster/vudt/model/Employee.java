package techmaster.vudt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Employee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @JsonIgnore  //Bỏ qua id khi nạp từ CSV
    int id;
    String firstName;
    String lastName;
    String email;
    String passportNumber;
    @JsonIgnore
    String fullName;

    public void provideFullName() {
        this.fullName = String.join(" ", this.firstName, this.lastName);
    }
    
    public boolean matchWithKeyword(String keyWord){
        String keyWordLowerCase = keyWord.toLowerCase();
        return firstName.toLowerCase().contains(keyWordLowerCase) ||
        lastName.toLowerCase().contains(keyWordLowerCase) ||
        email.toLowerCase().contains(keyWordLowerCase) ||
        fullName.toLowerCase().contains(keyWordLowerCase);
    }
}