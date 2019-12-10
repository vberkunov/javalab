import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Records extends Date {

    private String firstName;
    private String secondName;
    private String lastName;
    private String phone;




    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }
    @Builder
    public Records(String firstName, String secondName, String lastName, String phone,
                   int day, int month, int year) {
        super(day, month, year);
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phone = phone;
    }

   @Annotation
    public void getDaysBeforeBirthday() {
        Calendar current = Calendar.getInstance();
        int currentDate = current.get(Calendar.DATE);
        int currentMonth = current.get(Calendar.MONTH) + 1;
        int currentYear = current.get(Calendar.YEAR);

        Period period = Period.between(LocalDate.of(currentYear, currentMonth, currentDate),
                LocalDate.of(currentYear + 1, getMonth(), getDay()));
        System.out.println("Days: " + period.getDays() + " Months: " + period.getMonths());
    }


}
