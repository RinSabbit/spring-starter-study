package chap03to06.spring;

public class MemberPrinter {

    public void print(Member member){
        System.out.printf("member info: id= %d, email= %s, name=%s, registerDate= %tF\n",member.getId(),member.getEmail(),member.getName(),member.getRegisterDateTime());
    }

}
