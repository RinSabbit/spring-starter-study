package spring;

import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
    @Autowired(required = false)
    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM원 dd일");
    }

    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out
                .printf("member info: id= %d, email= %s, name=%s, registerDate= %tF\n",
                    member.getId(),
                    member.getEmail(), member.getName(), member.getRegisterDateTime());
        } else {
            System.out
                .printf("member info: id= %d, email= %s, name=%s, registerDate= %s\n",
                    member.getId(),
                    member.getEmail(), member.getName(), dateTimeFormatter.format(
                        member.getRegisterDateTime()));
        }
    }

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
}
